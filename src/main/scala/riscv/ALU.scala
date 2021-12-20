package riscv
import chisel3._
import chisel3.util._


class ALUIO extends Bundle with Config {
val in_A = Input(UInt(32.W))
val in_B = Input(UInt(32.W))
val alu_Op = Input(UInt(4.W))
val out = Output(SInt(32.W))
val sum = Output(UInt(32.W))
val mem_write = Input(Bool())
val mem_to_reg = Input(Bool())
val branch = Input(Bool())

}
class ALU extends Module with Config {
val io = IO (new ALUIO )
val sum = io.in_A + Mux( io.alu_Op (3) , -io.in_B , io.in_B )
val Branches = io.branch
val andd = io.in_A & io.in_B
val orr = io.in_A | io.in_B
val xorr = io.in_A ^ io.in_B    
val slll = io.in_A << io.in_B(4,0)
val sltt = io.in_A < io.in_B
val sr = io.in_A >> io.in_B(4,0)
val mem_writes = io.mem_write
val mem_to_regs = io.mem_to_reg
val BEQ = io.in_A === io.in_B
val b_bGE = io.in_A > io.in_B
val BGE = b_bGE | BEQ
val BNE = ~BEQ

io.sum := sum
io.out := Mux(Branches,BGE,andd).asSInt
switch ( io.alu_Op(2,0) ) {
    is ("b000".U){
        io.out := Mux(Branches,BEQ,io.sum).asSInt
    } 
    is ("b001".U){
        // io.out := slll
        io.out := Mux(Branches,BNE,slll).asSInt
    }
    is ("b010".U){
        // io.out := sl

        // val ful_mux = Mux()
        io.out := Mux(mem_writes,io.in_A + io.in_B,Mux(mem_to_regs,io.in_A + io.in_B,sltt)).asSInt
    }
    is ("b011".U){
        io.out := sltt.asSInt
    }
    is ("b100".U){
        // io.out := xorr
        io.out := Mux(Branches,sltt,xorr).asSInt
    }
    is ("b101".U){
        io.out := Mux(Branches,BGE,sr).asSInt
        // io.out := sr
    }
    is ("b110".U){
        // io.out := orr
        io.out := Mux(Branches,sltt,orr).asSInt

   
 }
}
}
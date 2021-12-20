package riscv
import chisel3._


trait Config {
    val REGFILE_LEN = 32
    val XLEN = 32
    val five = 5

}

class register32 extends Module with Config{ 
    val io = IO(new Bundle{
        val rs_1 = Input(UInt(five.W))
        val rs_2 = Input(UInt(five.W))
        val Reg_write = Input(Bool())
        val rd = Input(UInt(five.W))
        
        val Data_write = Input(SInt(XLEN.W))
        val Bus_A = Output(SInt(XLEN.W))
        val Bus_B = Output(SInt(XLEN.W))
    })
        val registers = Reg(Vec (REGFILE_LEN, SInt(XLEN.W)))
        registers(0) := 0.S
        io.Bus_A := registers(io.rs_1)
		io.Bus_B := registers(io.rs_2)
        when(io.Reg_write ){
			when(io.rd === "b00000".U){
				registers(io.rd) := 0.S
			}.otherwise {
				registers(io.rd) := io.Data_write
			}
		}
		
}
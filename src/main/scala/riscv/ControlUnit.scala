package riscv
import chisel3._
import chisel3.util._


class ControlUnit extends Module{
	val io = IO(new Bundle{
		val opcode = Input(UInt(7.W))


		val RegWrite = Output(Bool())
		val Operand_B_sel = Output(Bool())
		val MemWrite = Output(Bool())
		val MemRead = Output(Bool())
		val MemtoReg = Output(Bool())
		val Branch_out = Output(Bool())
		val Lui_control = Output(Bool())
		val Auipc_sel = Output(Bool())
		val Jal_sel = Output(Bool())
		val Jalr_sel = Output(Bool())
	})
    


    val tdeco = Module (new TypeDecoder())
    val cdec = Module (new ControlDecode())
    
    tdeco.io.opCode := io.opcode


    cdec.io.R_Type := tdeco.io.RType
    cdec.io.Load := tdeco.io.Load
    cdec.io.Store := tdeco.io.Store
    cdec.io.Branch := tdeco.io.Branch
    cdec.io.I_Type := tdeco.io.IType
    cdec.io.JALR := tdeco.io.Jalr
    cdec.io.JAL := tdeco.io.Jal
    cdec.io.LUI := tdeco.io.Lui
    cdec.io.Auipc := tdeco.io.auipc


    io.Branch_out := cdec.io.Branch_out
    io.RegWrite :=cdec.io.RegWrite
    io.Operand_B_sel := cdec.io.Operand_B_sel
    io.MemRead := cdec.io.MemRead
    io.MemtoReg := cdec.io.MemtoReg
    io.Lui_control := cdec.io.Lui_control
    io.Auipc_sel := cdec.io.Auipc_sel
    io.Jal_sel :=cdec.io.Jal_sel
    io.Jalr_sel :=cdec.io.Jalr_sel
    io.MemWrite := cdec.io.MemWrite
}


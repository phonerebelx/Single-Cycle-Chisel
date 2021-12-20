package riscv
import chisel3._
import chisel3.util._


class ControlDecode extends Module{
	val io = IO(new Bundle{
		val R_Type = Input(Bool())
		val Load = Input(Bool())
		val Store = Input(Bool())
		val Branch = Input(Bool())
		val I_Type = Input(Bool())
		val JALR = Input(Bool())
		val JAL = Input(Bool())
		val LUI = Input(Bool())
		val Auipc = Input(Bool())

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
		io.RegWrite := 0.B
		io.Operand_B_sel := 0.B
		io.MemWrite := 0.B
		io.MemRead := 0.B
		io.MemtoReg := 0.B
		io.Branch_out := 0.B
		io.Lui_control := 0.B
		io.Auipc_sel := 0.B
		io.Jal_sel := 0.B
		io.Jalr_sel := 0.B

		when(io.R_Type === 1.B){

			io.RegWrite := 1.B

		}.elsewhen(io.Load === 1.B){
			io.RegWrite := 1.B
			io.MemRead := 1.B
			io.MemtoReg := 1.B

		}.elsewhen(io.Store === 1.B){
			io.MemWrite := 1.B

		}.elsewhen(io.Branch === 1.B){

			io.Branch_out := 1.B

		}.elsewhen(io.I_Type === 1.B){
			io.RegWrite := 1.B
			io.Operand_B_sel := 1.B

		}.elsewhen(io.JALR === 1.B){
			io.RegWrite := 1.B

			io.Jalr_sel := 1.B
		}.elsewhen(io.JAL === 1.B){
			io.RegWrite := 1.B

			io.Jal_sel := 1.B

		}.elsewhen(io.LUI === 1.B){
			io.RegWrite := 1.B
			io.Operand_B_sel := 1.B

			io.Lui_control := 1.B

		}.elsewhen(io.Auipc === 1.B){
			io.RegWrite := 1.B
			io.Operand_B_sel := 1.B
			io.Auipc_sel := 1.B

		}
}

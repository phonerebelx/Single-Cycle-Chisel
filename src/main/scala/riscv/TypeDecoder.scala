package riscv
import chisel3._
import chisel3.util._
import chisel3.core

class TypeDecoder extends Module {
	val  io = IO(new Bundle {
		val opCode = Input(UInt(7.W))
		val RType = Output(Bool())
		val Load = Output(Bool())
		val Store = Output(Bool())
		val Branch = Output(Bool())
		val IType = Output(Bool())
		val Jalr = Output(Bool())
		val Jal = Output(Bool())
		val Lui = Output(Bool())
		val auipc = Output(Bool())
	})
	
	io.RType := 0.B
	io.Load := 0.B
	io.Store := 0.B
	io.Branch := 0.B
	io.IType := 0.B
	io.Jalr := 0.B
	io.Jal := 0.B
	io.Lui := 0.B
	io.auipc := 0.B

	when(io.opCode === "b0110011".U){
		io.RType := 1.B	
	}.elsewhen(io.opCode === "b0000011".U){
		io.Load := 1.B
	}.elsewhen(io.opCode === "b0100011".U){
		io.Store := 1.B
	}.elsewhen(io.opCode === "b1100011".U){
		io.Branch := 1.B
	}.elsewhen(io.opCode === "b0010011".U){
		io.IType := 1.B
	}.elsewhen(io.opCode === "b1100111".U){
		io.Jalr := 1.B
	}.elsewhen(io.opCode === "b1101111".U){
		io.Jal := 1.B
	}.elsewhen(io.opCode === "b0110111".U){
		io.Lui := 1.B
	}.elsewhen(io.opCode === "b00010111".U){
		io.auipc := 1.B
	}
		
}
package riscv
import chisel3._
import chisel3.util.experimental.loadMemoryFromFile

class InsMemory extends Module{
    val io = IO(new Bundle{
        val instAddr = Input(UInt(10.W))
        val instOut = Output(UInt(32.W))
    })
    val mem = Mem(1024,UInt(32.W))
    io.instOut := mem(io.instAddr)
	loadMemoryFromFile(mem, "/home/ali/Desktop/Scala-Chisel-Learning-Journey/src/main/scala/instruction.txt")

}
package riscv
import chisel3._
import chisel3.util.experimental.loadMemoryFromFile

class DataMemory extends Module{
    val io = IO(new Bundle{
        val dataAddress = Input(SInt(32.W))
        val dataIn = Input(SInt(32.W))
        val loadMem = Input(Bool())
        val storeMem = Input(Bool())
        val memOut = Output(SInt(32.W))

    })
    val breakAddress = io.dataAddress(23,0)
    val mem = Mem(1024,SInt(32.W))
    when(io.storeMem === 1.B){
        mem(breakAddress) := io.dataIn
    }.otherwise{
        mem(breakAddress) := 0.S
    }
    when(io.loadMem === 1.B){
        io.memOut := mem(breakAddress) 
    }.otherwise{
        io.memOut := 0.S
    }
}
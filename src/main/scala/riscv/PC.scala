package riscv
import chisel3._
import chisel3.util._

// trait Configs {
// val SLEN = 1
// val WLEN = 32

// }
class ProgramCounter extends Module  {
val io = IO (new Bundle{
    val pcInput = Input(UInt(32.W))
    val pcOut = Output(UInt(32.W))
    
    
}
)   
    val reg = RegNext(0.U(32.W))
    reg := io.pcInput
	reg := reg+4.U
	io.pcOut := reg
}
package riscv
import chisel3._


// trait Configs {
// val SLEN = 1
// val WLEN = 32

// }
class StoreGenerator extends Module  {
val io = IO (new Bundle{
    val B_BusInput = Input(UInt(32.W))
    val I_tpyeInput = Input(UInt(32.W))
    val S_tpyeInput = Input(UInt(32.W))
    val Op_bSelect = Input(Bool())
    val Mem_wSelect = Input(Bool())
    val B_AluOutput = Output(SInt(32.W))
    
    
}
)   

    val Check_BusB_Itype = Mux(io.Op_bSelect,io.I_tpyeInput,io.B_BusInput)
    io.B_AluOutput := (Mux(io.Mem_wSelect,io.S_tpyeInput,Check_BusB_Itype)).asSInt


    
}
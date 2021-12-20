package riscv
import chisel3._
import chisel3.util._
// import ALUOP ._
trait Configs {
// word length configuration parameter
val WLEN = 32


}

class bitExtend32 extends Module with Configs {
val io = IO (new Bundle{
    val Instruction = Input(UInt(WLEN.W))
    val PC = Input(UInt(WLEN.W))
    val IExtend = Output(SInt(WLEN.W))
    val SExtend = Output(SInt(WLEN.W))
    val BExtend = Output(SInt(WLEN.W))
    val SbExtend = Output(SInt(WLEN.W))
    val UjExtend = Output(SInt(WLEN.W))
    val AuipcExtend = Output(SInt(WLEN.W))
}
)   
    val ex_1 = "b1111111111111111111".U
    val ex_0 = "b0000000000000000000".U

    ///////////////////////// For Immediate ////////////////////////////////////
    val Immbreak = io.Instruction(31,20)
    val ex_31 = io.Instruction(31)
    val select1 = Mux(ex_31,Cat(ex_1,ex_31),Cat(ex_0,ex_31)) 
    io.IExtend := Cat(select1,Immbreak).asSInt
  ///////////////////////// For Store ////////////////////////////////////
    val StBreak1 = io.Instruction(11,7)
    val StBreak2 = io.Instruction(31,25)
    val select2 = Mux(ex_31,Cat(ex_1,ex_31),Cat(ex_0,ex_31))
    io.SExtend := Cat(select2,Cat(StBreak2,StBreak1)).asSInt
///////////////////////// For Branch ////////////////////////////////////
    val const = 0.U
    val BBreak1 =  io.Instruction(7)
    val BBreak2 =  io.Instruction(11,8)
    val BBreak3 =  io.Instruction(30,25)
    val select3 = Mux(ex_31,Cat(ex_1,ex_31),Cat(ex_0,ex_31))
    val select4 = Cat(select3,Cat(BBreak1,Cat(BBreak3,Cat(BBreak2,const))))
    io.BExtend := (select4 + io.PC).asSInt
///////////////////////// For LUI Extend ////////////////////////////////////
    val lBreak = io.Instruction(31,12)
    val luiConstant = 12.U
    io.SbExtend := (lBreak << luiConstant).asSInt
///////////////////////// For UJ Extend ////////////////////////////////////
    val UJBreak1 = io.Instruction(19,12)
    val UJBreak2 = io.Instruction(20)
    val UJBreak3 = io.Instruction(21)
    val UJBreak4 = io.Instruction(30,22)
    // val UJBreak4 = io.Instruction(31)
    val UJSelect = Mux(ex_31,Cat(ex_1,ex_31),Cat(ex_0,ex_31))
    val UJSelect2 =Cat(Cat(UJSelect,Cat(UJBreak1,Cat(UJBreak2,Cat(UJBreak4,UJBreak3)))),const)
    val UJSelect3 = UJSelect2 + io.PC
    io.UjExtend := UJSelect3.asSInt
///////////////////////// For AUIPC Extend ////////////////////////////////////
    val AuiSelect = lBreak << luiConstant
    io.AuipcExtend := (AuiSelect + io.PC).asSInt
}


//  val UJBreak1 = io.Instruction(21,12)
//     val UJBreak2 = io.Instruction(22)
//     val UJBreak3 = io.Instruction(30,23)
//     // val UJBreak4 = io.Instruction(31)
//     val UJSelect = Mux(ex_31,Cat(ex_1,ex_31),Cat(ex_0,ex_31))
//     val UJSelect2 =Cat(ex_31,Cat( UJBreak1,Cat(UJBreak2,UJBreak3)))
//     io.UjExtend := UJSelect2.asSInt

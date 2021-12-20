
package riscv

import chisel3._
import org.scalatest._
import chiseltest._

class register32test extends FreeSpec with ChiselScalatestTester {
 
    "Register File Test" in {

        test(new register32) { c =>
        c.io.Reg_write.poke(1.B)
        c.io.rd.poke(2.U)
        c.io.Data_write.poke(5.S)
        c.clock.step(1)
        c.io.rs_1.poke(2.U)
        c.io.rs_2.poke(2.U)
        c.clock.step(5)
        }
    }
}



//  val out1 = io.Instruction(19,12)
//     val out2 = io.Instruction(20)
//     val out3 = io.Instruction(21)
//     val out4 = io.Instruction(30,22)
//     val UJSelect = Mux(ex_31,Cat(ex_1,ex_31),Cat(ex_0,ex_31))
//     // val UJSelect2 = Cat(UJSelect,UJBreak1,Cat(UJBreak2,Cat(UJBreak3,const)))
//     // val out5 = Cat(Cat(UJSelect,Cat(Cat(out1,out2),Cat(out4,out3))),const)
//         val out5 = Cat()
//     io.UjExtend := out5.asSInt
// // (io.PC + UJSelect2)
// }
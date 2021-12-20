package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class ControlUnitest extends FreeSpec with ChiselScalatestTester{
    "Control Unit"  in {
     test (new ControlUnit()){ c =>
        c.io.opcode.poke(51.U)         
        c.clock.step(10)
        }
    }
}
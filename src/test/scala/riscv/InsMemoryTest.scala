package riscv
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._

class InsMemoryTest extends FreeSpec with ChiselScalatestTester{
    "inst memory test" in {
        test(new InsMemory()){c=>
        c.io.instAddr.poke(1.U)
        c.clock.step(10)
        
        }
    }
}
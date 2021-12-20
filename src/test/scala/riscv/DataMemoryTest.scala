package riscv
import chisel3._
import org.scalatest._
import chiseltest._

class DataMemoryTest extends FreeSpec with ChiselScalatestTester{
    "dataMemoryTest" in {
        test(new DataMemory()){c=>
        c.io.dataAddress.poke(0.S)
        c.io.dataIn.poke(17.S)
        c.io.storeMem.poke(1.B)
        c.io.loadMem.poke(1.B)
        c.clock.step(1)
        }
    }
}
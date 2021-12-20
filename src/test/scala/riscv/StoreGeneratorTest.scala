package riscv

import chisel3._
import org.scalatest._
import chiseltest._


class StoreGeneratorTest extends FreeSpec with ChiselScalatestTester {
 
    "StoreGenerator" in {

        test(new StoreGenerator) { c =>
            c.io.B_BusInput.poke(12.U)
            c.io.I_tpyeInput.poke(5.U)
            c.io.S_tpyeInput.poke(3.U)
            c.io.Op_bSelect.poke(1.B)
            c.io.Mem_wSelect.poke(1.B)
            c.clock.step(5)
        }
    }
}
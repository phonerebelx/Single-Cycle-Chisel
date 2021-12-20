package riscv

import chisel3._
import org.scalatest._
import chiseltest._


class PCtest extends FreeSpec with ChiselScalatestTester {
 
    "PCtester" in {

        test(new ProgramCounter) { c =>
            c.io.pcInput.poke(0.U)
            c.clock.step(5)
        }
    }
}
package riscv
import org.scalatest._
import chiseltest._
import chisel3._

class bitextendertest extends FreeSpec with ChiselScalatestTester{
    "BitExtender" in {
        test(new bitExtend32){ c =>
        c.io.Instruction.poke("b10001000000000000000000000000000".U)
        c.io.PC.poke("b10000000000000000000000000000001".U)
        c.clock.step(20)
        
}}
}


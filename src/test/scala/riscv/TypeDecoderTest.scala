package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._



class TypeDecoderTest extends FreeSpec with ChiselScalatestTester{
    "type Decoder"  in {
     test (new TypeDecoder()){ c =>
        c.io.opCode.poke("b0010011".U)
        c.io.IType.expect(1.B)       
        c.clock.step(100)
        }
    }
}
package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._



class ControlDecodeTests extends FreeSpec with ChiselScalatestTester{
	   "Controler"  in {
     	test (new ControlDecode()){ c =>
        c.io.Load.poke(1.B)
       
        c.clock.step(10)
        }
    }
}

	
// 	// expect(c.io.MemWrite, 0)
// 	// expect(c.io.branch, 0)
// 	// expect(c.io.MemRead, 0)
// 	// expect(c.io.RegWrite, 1)
// 	// expect(c.io.MemtoReg, 0)
// 	// expect(c.io.ALUoperation, 6)
// 	// expect(c.io.operand_A_sel, 3)
// 	// expect(c.io.operand_B_sel, 1)
// 	// expect(c.io.extend_sel, 1)
// 	// expect(c.io.Next_pc_sel, 0)


// }
package riscv
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class Main extends Module{
	val io = IO(new Bundle{
        val instruction = Input(UInt(32.W))
        val Result = Output(UInt(32.W))
    })
    val PC = Module(new ProgramCounter) 
    val ALU = Module(new ALU)
    val regfile = Module(new register32)
}   
//         val output = Output(SInt(32.W))
// })
//     val alu = Module(new ALU)
//     // val aluop = Module(new AluOp)
//     // val  branch = Module(new BranchCtrl)//
   
//     // val conunit =Module (new ControlUnit)
//     val datameme = Module (new DataMemory)//
//     val immegen = Module (new ImmeGenerator)//
//     val insmem = Module (new InsMemory)//
//     val pc = Module (new PC)//
//     val regfile = Module (new Reg32)
//     val tdeco = Module (new TypeDecoder())
//     val cdec = Module (new ControlDecoder())
    


//     //jal
//     when (cdec.io.jalr === 1.U){
//         pc.io.input := immegen.io.out
//     }
//     //branch
//     .elsewhen(cdec.io.Branch === 1.U){
//         pc.io.input := immegen.io.out
//     }
//     //jalr
//     .elsewhen(cdec.io.jalr === 1.U){
//         pc.io.input := immegen.io.out
//     }
//     .otherwise{
//         pc.io.input := 0.U
//     }
    
//     insmem.io.write_address := pc.io.pc_output
//     //Opcode identify
//     // typedec.io.opCode := insmem.io.r_data(6,0)

//     tdeco.io.opCode := insmem.io.r_data(6,0)


//     cdec.io.RType := tdeco.io.RType
//     cdec.io.load := tdeco.io.Load
//     cdec.io.Store := tdeco.io.Store
//     cdec.io.SBType := tdeco.io.Branch
//     cdec.io.IType := tdeco.io.IType
//     cdec.io.Jalr := tdeco.io.Jalr
//     cdec.io.Jal := tdeco.io.Jal
//     cdec.io.Lui := tdeco.io.Lui
//     cdec.io.auipc := tdeco.io.auipc





//     //RegisterFile
//     regfile.io.imm_rs1 := insmem.io.r_data(19,15)
//     regfile.io.imm_rs2 := insmem.io.r_data(24,20)
//     regfile.io.rd_reg:= insmem.io.r_data(11,7)
//     regfile.io.reg_write:=cdec.io.RegWrite


//     //Immediate Generator
//     immegen.io.Instruction:= insmem.io.r_data
//     immegen.io.PC := pc.io.pc_output

//     //ALUOP 
//     (aluop.io.Inst).asUInt := insmem.io.r_data
//     aluop.io.branch := cdec.io.Branch

//     //alu
//     alu.io.in_1 := Mux((cdec.io.Auipc).asBool,(pc.io.pc_output).asSInt,regfile.io.rs1_output)


//     val esi = ((cdec.io.Immediate).asBool | (cdec.io.U_type).asBool | (cdec.io.store).asBool)
//     alu.io.in_2 := Mux(esi,(immegen.io.out)asSInt,regfile.io.rs2_output)
//     alu.io.select := Mux(((cdec.io.store).asBool|(cdec.io.Load).asBool),0.U,aluop.io.AluOut)
//     regfile.io.write_data := alu.io.output

//     //DataMemory

//     datameme.io.addr := alu.io.output(7,0)
//     datameme.io.store_data:= regfile.io.imm_rs2.asSInt
//     datameme.io.load := cdec.io.Load
//     datameme.io.store := cdec.io.store
//     regfile.io.write_data :=  datameme.io.Data_Out
//     io.output := alu.io.output

// }
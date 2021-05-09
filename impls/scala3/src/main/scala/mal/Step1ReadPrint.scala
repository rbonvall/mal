package mal

import scala.io.StdIn

object Step1 extends MalRepl[MalType]:
   def READ(s: String): MalType = Reader.readStr(s).head
   def EVAL(m: MalType): MalType = m
   def PRINT(m: MalType): Unit = println(Printer.printString(m))

@main
def step1_read_print(): Unit = Step1.run()


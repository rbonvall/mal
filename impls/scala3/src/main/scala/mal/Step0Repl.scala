package mal

import scala.io.StdIn

object Step0 extends MalRepl[String]:
   def READ(s: String): String = s
   def EVAL(s: String): String = s
   def PRINT(s: String): Unit = println(s)

@main
def step0_repl(): Unit = Step0.run()

package mal

import scala.io.StdIn

object Step0:
   
   def READ(s: String): String =
      s

   def EVAL(s: String): String =
      s

   def PRINT(s: String): Unit =
      println(s)

   def rep(s: String) =
      PRINT(EVAL(READ(s)))

@main
def step0_repl(): Unit =
   var userInput = ""
   while
      print("user> ")
      userInput = StdIn.readLine()
      userInput != null
   do
      Step0.rep(userInput)


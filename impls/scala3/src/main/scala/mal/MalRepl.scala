package mal

import scala.io.StdIn

trait MalRepl[T]:
   def READ(s: String): T
   def EVAL(m: T): T
   def PRINT(m: T): Unit
   
   def rep(s: String) =
      PRINT(EVAL(READ(s)))

   def run() =
      var userInput = ""
      while
         print("user> ")
         userInput = StdIn.readLine()
         userInput != null && userInput != "quit"
      do
         rep(userInput)

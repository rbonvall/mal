package mal

import scala.io.StdIn

def READ(s: String): String =
   s

def EVAL(s: String): String =
   s

def PRINT(s: String): Unit =
   println(s)

def rep(s: String) =
   PRINT(EVAL(READ(s)))


@main
def step0Repl(): Unit =
   var userInput = ""
   while
      print("user> ")
      userInput = StdIn.readLine()
      userInput != null
   do
      rep(userInput)


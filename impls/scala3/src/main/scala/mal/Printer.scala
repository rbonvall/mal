package mal

object Printer:
   inline val q = "\""

   def printString(value: MalType): String =
      value match
         case MalType.String(value) => s"$q$value$q"
         case MalType.Number(repr) => s"#$repr"
         case MalType.Symbol(name) => s"'$name"
         case MalType.List(items) => items.map(printString).mkString("(", " ", ")")
         case _ => "???"

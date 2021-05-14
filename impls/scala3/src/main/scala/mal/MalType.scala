package mal

// Alias to avoid name collision with mal's String.
import java.lang.{String => JavaString}

enum MalType:
   case List(values: MalType*)
   case Symbol(name: JavaString)
   case String(value: JavaString)
   case Bool(value: Boolean)
   case Number(repr: JavaString)
   case Nil



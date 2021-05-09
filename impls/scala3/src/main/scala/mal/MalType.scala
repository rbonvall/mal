package mal

// Aliases to avoid name collisions with our types.
import java.lang.{String => JavaString}
import scala.{List => ScalaList}

enum MalType:
   case List(values: ScalaList[MalType])
   case Symbol(name: JavaString)
   case String(value: JavaString)
   case Bool(value: Boolean)
   case Number(repr: JavaString)
   case Nil



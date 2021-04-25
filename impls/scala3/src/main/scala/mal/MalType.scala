package mal


enum MalType:
   case List(values: scala.List[MalType])
   case Symbol(name: String)
   case String(value: String)
   case Bool(value: Boolean)
   case Number(repr: String)
   case Nil



package mal


object Reader:

   val tokensPattern ="""[\s,]*(~@|[\[\]{}()'`~^@]|"(?:\\.|[^\\"])*"?|;.*|[^\s\[\]{}('"`,;)]*)""".r

   def tokenize(str: String): List[String] =
      tokensPattern.findAllIn(str).map(_.trim).filter(_.nonEmpty).toList

   def readStr(str: String): List[MalType] =
      List(readForm(tokenize(str))._1)

   def readForm(tokens: List[String]): (MalType, List[String]) =
      tokens match
         case "(" :: rest => readList(rest, Nil)
         case fst :: rest => (parseAtom(fst), rest)
         case Nil         => (MalType.Nil, Nil)

   def readList(tokens: List[String], acc: List[MalType]): (MalType, List[String]) =
      tokens match
         case ")" :: rest => (MalType.List(acc.reverse*), rest)
         case fst :: rest =>
            val (fstValue, restTokens) = readForm(tokens)
            readList(restTokens, fstValue :: acc)
         case Nil         => (MalType.Nil, Nil)

   def parseAtom(token: String): MalType =
      token match
         case "true"  => MalType.Bool(true)
         case "false" => MalType.Bool(false)
         case "nil"   => MalType.Nil
         case int(n)  => MalType.Number(n)
         case str(s)  => MalType.String(s)
         case other   => MalType.Symbol(other)

   object int:
      def unapply(s: String): Option[String] =
         s.toIntOption.map(_ => s)

   object str:
      val stringPattern = """["]([^"]*)["]""".r
      def unapply(s: String): Option[String] =
         s match
            case stringPattern(s) => Some(s)
            case _ => None


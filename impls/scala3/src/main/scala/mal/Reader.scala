package mal


object Reader:

   val tokensPattern ="""[\s,]*(~@|[\[\]{}()'`~^@]|"(?:\\.|[^\\"])*"?|;.*|[^\s\[\]{}('"`,;)]*)""".r

   def tokenize(str: String): List[String] =
      tokensPattern.findAllIn(str).map(_.trim).filter(_.nonEmpty).toList


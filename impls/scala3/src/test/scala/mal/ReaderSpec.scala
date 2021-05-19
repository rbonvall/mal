package mal

import munit.FunSuite

class ReaderSpec extends FunSuite:

   test("reader reads symbol") {
      assertEquals(
         Reader.readStr("a").head,
         MalType.Symbol("a")
      )
   }

   test("reader reads number") {
      assertEquals(
         Reader.readStr("1").head,
         MalType.Number("1")
      )
   }

   test("reader reads empty string") {
      assertEquals(
         Reader.readStr("\"\"").head,
         MalType.String("")
      )
   }

   test("reader reads string") {
      assertEquals(
         Reader.readStr("\"hello world\"").head,
         MalType.String("hello world")
      )
   }

   test("reader reads boolean") {
      assertEquals(
         Reader.readStr("true").head,
         MalType.Bool(true)
      )
   }

   test("reader reads empty list") {
      assertEquals(
         Reader.readStr("()").head,
         MalType.List()
      )
   }

   test("reader reads non-nested list") {
      assertEquals(
         Reader.readStr("(a b c)").head,
         MalType.List(
            MalType.Symbol("a"),
            MalType.Symbol("b"),
            MalType.Symbol("c"),
         )
      )
   }

   test("reader reads nested list") {
      assertEquals(
         Reader.readStr("(a (b c) d)").head,
         MalType.List(
            MalType.Symbol("a"),
            MalType.List(
               MalType.Symbol("b"),
               MalType.Symbol("c"),
            ),
            MalType.Symbol("d"),
         )
      )
   }




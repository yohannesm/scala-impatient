

object AsciiArtApp extends App {
  class AsciiArt(private val lines: Array[String]) {
    override def toString = '\n' + lines.mkString("\n")
    val width = lines.map(_.length).max
    val height = lines.size

    def | (that: AsciiArt) = {
      new AsciiArt(
          for ((a, b) <- this.lines.zipAll(that.lines, " ", " "))
            yield a + " " + b
        )
    }

    def ++ (that: AsciiArt) = {
      val maxWidth = Math.max(this.width, that.width)
      val thisLines = this.lines.map(_.padTo(maxWidth, ' '))
      val thatLines = that.lines.map(_.padTo(maxWidth, ' '))
      new AsciiArt(thisLines ++ thatLines)
    }
  }

  object AsciiArt {
    def apply(lines: String*): AsciiArt = new AsciiArt(lines.toArray)
  }

  val bunny = AsciiArt(
  """ /\_/\ """ ,
  """( ' ' )""" ,
  """(  _  )""" ,
  """ | | | """ ,
  """(__|__)""" )

  val quote = AsciiArt(
  """  -----   """ ,
  """ / Hello \ """ ,
  """<  Scala | """ ,
  """ \ Coder / """ ,
  """   -----   """ )

  println( bunny | quote )
  println( bunny ++ AsciiArt("""   %""") | quote ++ AsciiArt("""   ^^^^^""" ) )
  println( bunny ++ quote | AsciiArt("""Cyka """, """blaaat""" ) )

}

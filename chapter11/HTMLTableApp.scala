

object HTMLTableApp extends App {
  class Table(initial: String) {
    val value = initial

    override def toString = "<table>" + value + "</tr></table>"
    def | (s: String) = new Table(value + "<td>" + s + "</td>")
    def ||(s: String) = new Table(value + "</tr>\n<tr>" + "<td>" + s + "</td>")

  }
  object Table {
    def apply() = new Table("<tr>")
  }

  println( Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET" )
}

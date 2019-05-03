import scala.annotation._

object ComputeUnicodeProduct extends App {
  def computeUnicodeProduct(str: String): Long = {
    var res : Long = 1L
    for( i <- str ){
      res *= i.toLong
    }
    res
  }

  def mapUnicodeProduct(str: String): Long = {
    str.map(_.toLong).product
  }

  def recursiveUnicodeProduct(str: String): Long = {
    if(str.tail == "")  str.head.toLong
    else{
      str.head.toLong * recursiveUnicodeProduct(str.tail)
    }
  }

object s_+: {
  def unapply(s: String): Option[(Char, String)] = s.headOption.map{ (_, s.tail) }
}

@tailrec
  def UnicodeWithAcc(str: String, acc: Long): Long = {
    str match {
      case "" => acc
      case x s_+: xs => UnicodeWithAcc(xs, acc * x.toLong)
    }
  }

  println(computeUnicodeProduct("Hello"))
  println(mapUnicodeProduct("Hello"))
  println(recursiveUnicodeProduct("Hello"))
  println(UnicodeWithAcc("Hello", 1L))
}

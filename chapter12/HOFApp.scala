import scala.math._

object HOFApp extends App {
  //#1
  def values(fun: (Int) => Int, low: Int, high: Int): Seq[ (Int, Int) ]= {
    (low to high).map(x => (x, fun(x))).toSeq
  }
  println("test suite #1")
  println(values(x => x * x, -5, 5))

  //#2
  def largestElement(arr: Array[Int]): Int = arr.reduceLeftOption( (a, b) => if (a > b) a else b).getOrElse(-1)
  println("test suite #2")
  println(largestElement(Array(5, 1, 3)))
  println(largestElement(Array()))
  println(largestElement(Array(5, 2, 3, 13, 7, 8)))

  //#3
  def factoFunc(n: Int): Int = signum(n) match {
    case 0 => 1
    case 1 => (1 to n).reduceLeftOption(_ * _).getOrElse(1)
    case -1 => - (( 1 to -n).reduceLeftOption(_ * _).getOrElse(-1))
  }
  println("test suite #3")
  println(factoFunc(1))
  println(factoFunc(5))
  println(factoFunc(0))
  println(factoFunc(-5))

  //#4
  def factoFold(n: Int) = (1 to abs(n)).foldLeft(1)(_ * _) * signum(n)
  println("test suite #4")
  println(factoFold(1))
  println(factoFold(5))
  println(factoFold(0))
  println(factoFold(-5))

  //#5
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = inputs.map{fun}.max

  println("test suite #5")
  println(largest(x => 10 * x - x * x, 1 to 10))
}

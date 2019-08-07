

object Swap extends App {
  def swap(pair: (Int, Int)): (Int, Int) = pair match {
    case (a, b) => (b, a)
  }

  def swap(arr: Array[Int]) : Array[Int] = arr match {
    case Array(v1, v2, rest @ _*) => 
      Array(v2, v1) ++ rest
    case _ => arr
  }
}

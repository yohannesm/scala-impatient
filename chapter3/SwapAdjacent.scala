

object SwapAdjacent extends App {
  def swapAdjacent(arr : Array[Int]) : Array[Int] = arr.grouped(2).flatMap(_.reverse).toArray

  swapAdjacent( Array(1, 2, 3, 4, 5)).foreach(println)
}

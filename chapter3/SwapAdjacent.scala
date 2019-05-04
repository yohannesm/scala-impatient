

object SwapAdjacent extends App {
  def swapAdjacent(arr : Array[Int]) : Array[Int] = arr.grouped(2).flatMap(_.reverse).toArray

  def swapWithForYield(arr: Array[Int]): Array[Int] = {
    val iter = for { 
      b <- arr.grouped(2)
      c <- b.reverse 
    } yield c

    iter.toArray
  }

  swapAdjacent( Array(1, 2, 3, 4, 5)).foreach(println)
  swapWithForYield( Array(1, 2, 3, 4, 5)).foreach(println)
}



object PositiveFirst extends App {
  def sortPositiveFirst(arr: Array[Int]) = arr.filter( _ > 0) ++ arr.filter( _ <= 0)

  val testArr1 = Array(-1, -3, -5, -2, 1, 0 , 9, 17, -8, -1, 3, 4, 5)

  sortPositiveFirst(testArr1).foreach(println)
}

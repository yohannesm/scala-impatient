

object ComputeAverage extends App {
  def computeAverage( arr : Array[Double] ) = arr.sum/arr.length

  val arrDouble = Array(1.0, 1.0, 2.0, 3.0, 4.0, 4.0, 5.0, 6.0)

  println(computeAverage(arrDouble))
}

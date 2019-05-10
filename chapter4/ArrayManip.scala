

object ArrayManip extends App {
  def minmax(values: Array[Int]) = (values.min, values.max)

  def lteqgt(values: Array[Int], v: Int) = {
    var lt, eq, gt = 0

    for( n <- values){
      if( n < v ) lt += 1
      else if( n > v ) gt += 1
      else eq += 1
    }
    (lt, eq, gt)
  }
}

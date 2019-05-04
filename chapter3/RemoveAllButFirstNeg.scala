import scala.collection.mutable.ArrayBuffer


object RemoveAllButFirstNeg extends App {
  def iterativeJava(a : ArrayBuffer[Int]) : Array[Int] = {
    var first = true
    var n = a.length
    var i = 0
    while( i < n ) {
      if( a(i) >= 0 ) i += 1
      else {
        if (first) { first = false; i+= 1 }
        else { a.remove(i); n -= 1}
      }
    }
    a.toArray
  }

  def scalaSolution1(a : ArrayBuffer[Int]) = {
    val indices = a.indices.filter( a(_) < 0).drop(1)
    for( i <- a.indices) a.remove(indices(i)-i)
    a.toArray
  }

  def ScalaSolution2(a : ArrayBuffer[Int]) = {
    val arr = a.toArray
    for(i <- arr.indices if (i<=arr.indexWhere(_<0) || a(i) > 0)) yield a(i)
  }
}

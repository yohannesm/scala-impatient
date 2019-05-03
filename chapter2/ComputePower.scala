import scala.math.pow

object ComputePower extends App {
  def computePower(x: Double, n: Int): Double = {
    if( n > 0 && n % 2 == 0) pow( pow(x, n / 2), 2)
    else if(n > 0 && n % 2 == 1) x * pow(x, n - 1)
    else if(n < 0) 1 / pow(x, -n)
    else 1
  }
}


object ComputeSignum extends App {
  def signum(n: Int): Int = {
    if (n > 0) 1 else if (n < 0) -1 else 0
  }
}



object HOFApp extends App {
  def values(fun: (Int) => Int, low: Int, high: Int): Seq[ (Int, Int) ]= {
    (low to high).map(x => (x, fun(x))).toSeq
  }

  println(values(x => x * x, -5, 5))
}

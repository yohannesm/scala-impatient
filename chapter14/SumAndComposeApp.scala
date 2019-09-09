

object SumAndComposeApp extends App {
  def mySum0(list: List[Option[Int]]) = (for (Some(value) <- list) yield value).sum

  def mySum1(list: List[Option[Int]]) = list.foldLeft(0){ (acc, value) => acc + value.getOrElse(0)}

  def mySum2(list: List[Option[Int]]) = list.flatten.reduce(_ + _)

  def mySum3(list: List[Option[Int]]) = list.flatMap(identity(_)).sum

  def mySum4(list: List[Option[Int]]) = list.collect{ case Some(x) => x}.fold(0)(_ + _) 

  type DFunc = Double => Option[Double]

  def myCompose0(f: DFunc, g: DFunc): DFunc = f(_).flatMap(g)

  def myCompose1(f: DFunc, g: DFunc): DFunc = {
    (x: Double) => f(x) match {
      case Some(x0) => g(x0)
      case _ => None
    }
  }
}

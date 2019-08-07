

object TreeApp extends App {
  def leafSum(lst: List[Any]): Int = lst.foldLeft(0)((acc, item) => item match {
    case n: Int => acc + n
    case lst: List[_] => acc + leafSum(lst)
    case _ => acc
  })

  println("#5 test cases")
  val lst5 = List(List(3, 8), 2, List(5))

  println( leafSum(lst5) )
}

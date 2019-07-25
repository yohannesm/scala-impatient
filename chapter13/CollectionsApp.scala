import scala.collection.immutable._
import scala.collection.mutable.ListBuffer
import scala.io.Source

object CollectionsApp extends App {

  def indexMapToSet(str: String) = {
    import scala.collection.mutable._
    val charsToIndices = new HashMap[Char, Set[Int]] with MultiMap[Char, Int] {
      override protected def makeSet: Set[Int] = new TreeSet[Int]
    }
    for (i <- str.indices) charsToIndices.addBinding(str(i), i)
    charsToIndices
  }

  val strMiss = "Mississippi"
  println("#1 test case")
  println( indexMapToSet(strMiss))

  def indexMapToSetFunc(str: String) = {
    str.zipWithIndex.groupBy(p => p._1).map(p => (p._1, p._2.map(q => q._2)))
  }

  println("#2 test case")
  println( indexMapToSetFunc(strMiss))

  def indexMapToSetFold(str: String) = {
    val initialMap = HashMap[Char, List[Int]]().withDefaultValue(Nil)
    str.zipWithIndex.foldLeft(initialMap)( (map, pair) => map + (pair._1 -> (pair._2 :: map(pair._1))))
  }

  println("#3 test case")
  println( indexMapToSetFold(strMiss))

  /* Other approaches
   *
   */
    def merge[K,V,X](map: Map[K,V], entry: (K,X))(fun: (V, X) => V) = entry match {
      case (k, v) => map + (k -> fun(map(k), v))
    }
    def indexes2c(s: String): Map[Char,List[Int]] = {
      val initial = HashMap[Char,List[Int]]().withDefaultValue(Nil)
      s.zipWithIndex.foldLeft(initial)(merge(_, _)((lst, i) => i :: lst))
    }
    indexes2c("Mississippi")

    // other approach for merge
    def merge2[K,V](map: Map[K,V], entry: (K,V))(fun: (V, V) => V) = entry match {
      case (k, v) => map + (if (map.contains(k)) (k -> fun(map(k), v))else (k -> v))
    }
    def indexes2d(s: String): Map[Char,List[Int]] = {
      val initial = Map[Char,List[Int]]()
      s.zipWithIndex.foldLeft(initial)((map, pair) =>
        merge2(map, (pair._1 -> List(pair._2)))(_ ::: _))
    }
    indexes2d("Mississippi")

  /*********************
   * end other approaches
   */

  println("#4 test case")
  def filterZeroes(l: List[Int]): List[Int] = {
    l.filterNot(_ == 0)
  }


  def correspondMap(strs: Array[String], map: Map[String, Int]) = 
    strs.flatMap(map.get(_))

  def printArr[A](arr: Array[A]) = arr.map(_.toString).mkString(" ")

  val strs = Array("Tom", "Fred", "Harry")
  val map = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
  val res5 =  correspondMap(strs, map) 
  val print5 = printArr(res5)
  println( s"Array( $print5  )" )

  // 5
  // using only reduceLeft, but only supporting strings:
  def mkStringImitator(strs: Seq[String], between: String = ", "): String =
    strs.reduceLeft((a, b) => a + between + b)

  mkStringImitator(List("Foo", "Bar", "Quux"), " | ")

  // generic but using map in addition to reduceLeft:
  def mkStringImitator2[T](strs: Seq[T], between: String = ", "): String =
    strs.map(_.toString).reduceLeft((a, b) => a + between + b)

  println("#5 test case")
  println( mkStringImitator2(List("Foo", "Bar", "Quux"), " | ") )

  // 6
  val lst = (1 to 16).toList
  // 1st: fold right lst, starting with an empty list,
  // combining successive elements by prepending them to the accumulating list,
  // so effectively recreating the list
  println("#6 test case")
  (lst :\ List[Int]())(_ :: _) // => faster
  // 2nd: same but using fold left and appending (so less efficient I think)
  (List[Int]() /: lst)(_ :+ _)
  // reverse soln:
  (lst :\ List[Int]())((a, b) => b :+ a)
  (List[Int]() /: lst)((a, b) => b :: a) // => faster

  // 7
  val prices = List(5.0, 20.0, 9.95)
  val quants = List(10, 2, 1)
  println("#7 test case")
  println( (prices zip quants).map(((a: Double, b: Int) => a * b).tupled) )
  println( (prices zip quants).map(((_: Double) * (_: Int)).tupled) ) // a bit shorter

}

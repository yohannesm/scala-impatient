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
    // other approach
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
}

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
}

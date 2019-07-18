import scala.collection.immutable._
import scala.collection.mutable.ListBuffer
import scala.io.Source

object CollectionsApp extends App {

  def indexMapToSet(str: String) = {
    import scala.collection.mutable._
    val charsToIndices = new HashMap[Char, Set[Int]] with MultiMap[Char, Int] {
      override protected def makeSet: Set[Int] = new TreeSet[Int]
    }
    for (i <- str.indices) charsToIndices.addBinding(s(i), i)
    charsToIndices
  }

  val strMiss = "Mississippi"

  println( indexMapToSet(strMiss))
}

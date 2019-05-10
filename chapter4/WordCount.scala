import java.util._
import scala.collection.mutable._

object WordCount extends App {
  val in = new java.util.Scanner(new java.io.File("myfile.txt"))
  val wordCounts = scala.collection.mutable.Map[String, Int]()
  while(in.hasNext()) {
    val word = in.next().split("\\W+").headOption.getOrElse("")
    wordCounts(word) = wordCounts.getOrElse(word, 0) + 1
  }

  wordCounts.foreach{ case(k, v) => println(s"word = $k, count = $v")  }

}

import java.util._
import scala.collection.mutable._

import scala.collection.JavaConversions.mapAsScalaMap //for java TreeMap

object WordCount extends App {
  val in = new java.util.Scanner(new java.io.File("myfile.txt"))
  val wordCounts = scala.collection.mutable.Map[String, Int]()
  var immWordCounts = scala.collection.immutable.Map[String, Int]()
  var sortedWordCounts = scala.collection.immutable.SortedMap[String, Int]()
  var treeWordCounts = new java.util.TreeMap[String, Int]()
  while(in.hasNext()) {
    val word = in.next().split("\\W+").headOption.getOrElse("")
    wordCounts(word) = wordCounts.getOrElse(word, 0) + 1
    immWordCounts += (word -> (immWordCounts.getOrElse(word, 0) + 1))
    sortedWordCounts += (word -> (sortedWordCounts.getOrElse(word, 0) + 1))
    treeWordCounts += (word -> (treeWordCounts.getOrElse(word, 0) + 1))
  }

  //wordCounts.foreach{ case(k, v) => println(s"word = $k, count = $v")  }
  //immWordCounts.foreach{ case(k, v) => println(s"word = $k, count = $v")  }
  //sortedWordCounts.foreach{ case(k, v) => println(s"word = $k, count = $v")  }
  treeWordCounts.foreach{ case(k, v) => println(s"word = $k, count = $v")  }


}

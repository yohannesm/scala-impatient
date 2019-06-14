import scala.io._
import java.nio.file._
import java.io._

object PrintWordsWithLengthFilter extends App {
  
  def printLongWords(file: String): Unit = {
    val maxWordLen = 12
    Source.fromFile(file).mkString.split("\\s+").filter(_.length > maxWordLen).foreach(println)
  }
}

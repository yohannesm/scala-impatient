import scala.io._
import java.nio.file._
import java.io._

object ReplaceTabs {
  def replaceTabs(fileName: String, charsPerColumn: Int = 4) = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines()) {
      val parts = line.split("\t").map(s => s.padTo(s.length + 4 - s.length % 4, ' '))
      println(parts.mkString)
    }
    
  }
}

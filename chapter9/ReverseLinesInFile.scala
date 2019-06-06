import scala.io._
import java.nio.file._
import java.io._


object ReverseLinesInFile {
  def reverseLines(fileName: String): Unit = {
    val src: BufferedSource = Source.fromFile(fileName)
    val lines = try {
      src.getLines().toBuffer.reverse
    }
    finally {
      src.close()
    }

    val writer = new PrintWriter(fileName)
    try {
      lines.foreach(writer.println)
    }
    finally {
      writer.close()
    }
  }
}


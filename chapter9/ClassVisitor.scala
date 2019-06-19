import scala.io._
import java.nio.file._
import java.io._
import java.nio.file.attribute.BasicFileAttributes
import scala.language.implicitConversions

object ClassVisitor extends App {

  def countClassFiles(dir: String): Int = {
    var count = 0
    Files.walkFileTree(new File(dir).toPath, (f: Path) => {
      if (f.toString.endsWith(".class"))
        count += 1
    })

    count 
  }

  implicit def makeFileVisitor(func: (Path) => Unit): FileVisitor[Path] =
    new SimpleFileVisitor[Path] {
      override def visitFile(path: Path, attrs: BasicFileAttributes) = {
        func(path)
        FileVisitResult.CONTINUE
      }
    }


}

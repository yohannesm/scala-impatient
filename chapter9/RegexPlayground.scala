import scala.io._
import java.nio.file._
import java.io._

object RegexPlayground extends App {
  def printQuotedStrings(file: String): Unit = {
    // got from here:
    // http://stackoverflow.com/questions/2498635/java-regex-for-matching-quoted-string-with-escaped-quotes
    val pattern = "\"(([^\\\\\"]+|\\\\([btnfr\"'\\\\]|[0-3]?[0-7]{1,2}|u[0-9a-fA-F]{4}))*)\"".r

    for (pattern(s, _, _) <- pattern.findAllIn(Source.fromFile(file).mkString)) {
      println(s)
    }
  }

   /**
   * Write a Scala program that reads a text file and prints all tokens in the file
   * that are not floating-point numbers. Use a regular expression.
   */
  def printNonNumberTokens(file: String): Unit = {
    val pattern = "(?![\\d]+(\\.[\\d]+)?)\\w+".r

    for (s <- pattern.findAllIn(Source.fromFile(file).mkString)) {
      println(s)
    }
  }

   /**
   * Write a Scala program that prints the `src` attributes of all `img` tags of a web page.
   * Use regular expressions and groups.
   */
  def printSrcOfImageTags(file: String): Unit = {
    val pattern = "(?i)<img\\s+(.*?\\s+)?src\\s*=\\s*\"([^\"]+)\"".r

    for (pattern(_, s) <- pattern.findAllIn(Source.fromFile(file).mkString)) {
      println(s)
    }
  }

}

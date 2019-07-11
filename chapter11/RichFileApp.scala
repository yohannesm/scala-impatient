import scala.collection.mutable.ListBuffer

/**
   * Task 9:
   *
   * Define an `unapply` operation for the `RichFile` class that extracts the file path, name,
   * and extension. For example, the `file/home/cay/readme.txt` has path `/home/cay`,
   * name `readme`, and extension `txt`.
   */

    /**
   * Task 10:
   *
   * Define an `unapplySeq` operation for the `RichFile` class that extracts all path segments.
   * For example, for the `file/home/cay/readme.txt`, you should produce a sequence of
   * three segments: `home`, `cay`, and `readme.txt`.
   */

object RichFileApp extends App {
  object RichFile {
    private val pathNameExtRegex = """file(.*)/(.+)\.(.*)""".r

    def unapply(file: String): Option[(String, String, String)] = file match {
      case pathNameExtRegex(path, name, extension) => Some((path, name, extension))
      case _ => None
    }

    private val pathSeqRegex = """([^/]+)/?""".r

    def unapplySeq(file: String): Option[Seq[String]] = {
      val seq = new ListBuffer[String]
      for (pathSeqRegex(p) <- pathSeqRegex.findAllIn(file)) {
        seq += p
      }

      if (seq.nonEmpty && seq.head == "file") Some(seq.tail)
      else None
    }
  }
}

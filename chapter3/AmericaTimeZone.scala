import java.util.TimeZone

object AmericaTimeZone extends App {
  val america = "America/"

  val  allAmericaTimeZone = TimeZone.getAvailableIDs.filter(_.startsWith(america)).map(_.stripPrefix(america)).sorted

  allAmericaTimeZone.foreach(println)
}

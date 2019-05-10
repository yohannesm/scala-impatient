import java.lang._
import scala.collection.JavaConversions.propertiesAsScalaMap

object ScalaGetProperties extends App {
  val properties : scala.collection.Map[String, String] = System.getProperties()
  val maxKeyLength = (for ((key, _) <- properties) yield key.length).max

  for( (k, v) <- properties)
    printf("%-" + maxKeyLength + "s | %s\n", k, v)

}

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
import scala.collection.JavaConverters
import java.awt.datatransfer._

/**
 * Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
 * val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
 *
 * Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and
 * get the return value as a Scala buffer.
 *
 * (Why this obscure class? It’s hard to find uses of java.util.List in the standard Java library.)
 */
object JavaAWTFlavorMap extends App {

  def javaListAsScalaBuffer: collection.mutable.Buffer[String] = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val flavorBuffer: Buffer[String] = JavaConverters.asScalaBufferConverter(flavors.getNativesForFlavor(DataFlavor.imageFlavor)).asScala
    flavorBuffer.foreach(println)
    flavorBuffer
  }
  
  javaListAsScalaBuffer

}

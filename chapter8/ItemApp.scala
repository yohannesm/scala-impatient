import scala.collection.mutable._

object ItemApp extends App {
  abstract class Item {
    def price: Double
    def description: String
  }

  class SimpleItem(override val price: Double, override val description: String) extends Item 

  class Bundle extends Item {
    private val itemsBuffer = new ArrayBuffer[Item]()

    override def price = itemsBuffer.map(_.price).sum
    override def description = itemsBuffer.map(_.description).mkString(" ")

    def addItem(item : Item) = itemsBuffer += item
  }
}

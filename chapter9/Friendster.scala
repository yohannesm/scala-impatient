import scala.io._
import java.nio.file._
import java.io._
import scala.collection.mutable.ArrayBuffer
//import org.scalatest.{FlatSpec, Matchers}

object Friendster extends App {
  
  class Person(val name: String) extends Serializable with Iterable[Person] {
    private val friends = new ArrayBuffer[Person]

    def addFriend(friend: Person): Person = {
      friends += friend
      this
    }

    override def iterator: Iterator[Person] = friends.toIterator
  } //end Person class

  def savePersons(file: File, persons: Array[Person]): Unit = {
    val out = new ObjectOutputStream(new FileOutputStream(file))
    try {
      out.writeObject(persons)
    } finally {
      out.close()
    }
  }

  def readPersons(file: File): Array[Person] = {
    val in = new ObjectInputStream(new FileInputStream(file))
    try {
      in.readObject().asInstanceOf[Array[Person]]
    } finally {
      in.close()
    }
  }
}

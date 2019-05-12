

object EnumTest extends App {

  object Suits extends Enumeration {
    type Suits = Value
    val Clubs = Value("\u2667") //black
    val Diamonds = Value("\u2662") //red
    val Hearts = Value("\u2661") //red
    val Spades = Value("\u2664") //black

    def isRed(value: Suits) = value == Diamonds || value == Hearts
  }

  import Suits._
  Suits.values.foreach( suit => println(s"$suit") )
}

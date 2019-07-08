import scala.annotation.tailrec
import scala.math._

object MoneyApp extends App {
  class Money private(d: Int, c: Int) {
    if (d < 0) throw new IllegalArgumentException("")
    if (c < 0) throw new IllegalArgumentException("")

    val dollars: Int = if (c > 99) d + (c / 100) else d
    val cents: Int = if (c > 99) c % 100 else c

    def +(that: Money): Money = Money(dollars + that.dollars, cents + that.cents)

    def -(that: Money): Money = {
      val d: Int = dollars - that.dollars
      val c: Int = cents - that.cents
      if(c < 0) Money(d-1, c + 100)
      else Money(d, c)
    }

    def ==(that: Money): Boolean = dollars == that.dollars && cents == that.cents

    def <(that: Money): Boolean = ((dollars * 100) + cents) < ((that.dollars * 100) + that.cents)

    override def toString = "%d.%02d".format(dollars, + cents)


  }

  object Money{
    def apply(d: Int, c: Int) = new Money(d, c)
  }
}

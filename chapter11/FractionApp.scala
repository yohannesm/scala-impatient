import scala.annotation.tailrec
import scala.math._

object FractionApp extends App {

  class Fraction(n: Int, d: Int){
    private val num: Int = if ( d == 0) 1 else n * signum(d) / gcd(n, d)
    private val den: Int = if (d == 0) 0 else d * signum(d) / gcd(n, d)

    @tailrec
    private def gcd(a: Int, b: Int): Int = {
      if(b == 0) Math.abs(a)
      else gcd(b, a % b)
    }

    def +(other: Fraction): Fraction = sumOp(other, _ + _)

    def -(other: Fraction): Fraction = sumOp(other, _ - _)

    def *(other: Fraction): Fraction = Fraction(num * other.num, den * other.den)

    def /(other: Fraction): Fraction = Fraction(num * other.den, den * other.num)

    private def sumOp(other: Fraction, op: (Int, Int) => Int): Fraction = {
      Fraction(op(num * other.den, den * other.num), den * other.den)
    }

    override def toString = s"$num/$den"
  }

  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)
  }

  val a = Fraction(15, -6)
  val b = Fraction(3, 4)
  println( a + b)

}

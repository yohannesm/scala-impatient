import scala.math._
import scala.util._

object GenerateRandomBase36 {
      def main(args: Array[String]): Unit = {
              val randGen = Random
              val probPrime = BigInt.probablePrime(100, randGen)
              val genB36 = probPrime.toString(36)
              println(genB36)
      }
}

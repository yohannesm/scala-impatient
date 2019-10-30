import scala.annotation.tailrec
import scala.collection.immutable.NumericRange
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn

object PrimeComputeApp extends App {
  
  def await[T](f: Future[T]) = Await.result(f, 10.seconds)

  def countPrimes(n: BigInt): Future[Int] = {
    val cores = Runtime.getRuntime.availableProcessors()
    ( BigInt(1) to n).grouped( (n/cores).toInt)
      .map(g => Future{ g.count(_.isProbablePrime(100))})
      .reduce( (af, bf) => {
        for (a <- af; b <- bf) yield a + b
      })
  }

  println(await(countPrimes(1000)))
  println(await(countPrimes(10000)))
  println(await(countPrimes(100000)))
  println(await(countPrimes(1000000)))
}

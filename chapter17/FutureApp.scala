import java.time.LocalDate

import scala.annotation.tailrec
import scala.collection.immutable.NumericRange
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
import scala.xml.Node
import scala.xml.parsing.XhtmlParser


object FutureApp extends App {
  def await[T](f: Future[T]) = Await.result(f, 10.seconds)

  def future(n: Int) = Future{ Thread.sleep(1000); n}

 val life =  await( for (n1 <- future(2); n2 <- future(40))
   yield(n1 + n2))

 println(life)

 def doInOrder[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[V] = {
  x => f(x).flatMap(g)
 }

 def f(n: Int) = Future{ n + 1 }
 def g(n: Int) = Future{ n * 2 }

 println( await(doInOrder(f, g)(10)) )

 def doAllInOrder[T](fs: (T => Future[T])*): T => Future[T] = 
   fs.reduceLeft( (a, b) => x => a(x).flatMap(b))

 def h(n: Int) =  Future{ n - 1}
 await(doAllInOrder(f, g, h)(10))

 def doTogether[T, U, V](f: T => Future[U], g: T => Future[V]): T => Future[(U, V)] = {
  x => {
    val fFuture = f(x); val gFuture = g(x)
    for( n1 <- fFuture; n2 <- gFuture) yield (n1, n2)
  }
 }

 def futureSequence[T](futures: Seq[Future[T]]): Future[Seq[T]] = ???
}

import java.time.LocalDate

import scala.annotation.tailrec
import scala.collection.immutable.NumericRange
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
import scala.xml.Node
import scala.xml.parsing.XhtmlParser
import scala.util._


object FutureApp extends App {
  def completeFuture[T](f: Future[T]) = f.onComplete{
    case Success(v) => v
    case Failure(f) => println(f)
  }

  def await[T](f: Future[T]) = Await.result(f, 10.seconds)

  def future(n: Int) = Future{ Thread.sleep(1000); n}

 val life =  await( for (n1 <- future(2); n2 <- future(40))
   yield(n1 + n2))

 //equivalent to 
 //future(2).flatMap(n1 => future(40).map(n2 => println(n1 + n2)))
 //println is executed by the 2nd/last future thread

 println(life)

 //2 
 def doInOrder[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[V] = {
  x => f(x).flatMap(g)
 }

 def f(n: Int) = Future{ println("f executes"); n + 1 }
 def g(n: Int) = Future{ println("g executes"); n * 2 }

 println( await(doInOrder(f, g)(10)) )

 def doAllInOrder[T](fs: (T => Future[T])*): T => Future[T] = 
   fs.reduceLeft( (a, b) => x => a(x).flatMap(b))

 def doAllInOrderWithSeq[T](fs: Seq[(T => Future[T])]): T => Future[T] = 
   fs.reduceLeft( (a, b) => x => a(x).flatMap(b))


 def h(n: Int) =  Future{println("h executes";  n - 1}
 await(doAllInOrder(f, g, h)(10))
 //await(doAllInOrderWithSeq(List(f(_), g(_), h(_)))(10))

 def doTogether[T, U, V](f: T => Future[U], g: T => Future[V]): T => Future[(U, V)] = {
  x => {
    val fFuture = f(x); val gFuture = g(x)
    for( n1 <- fFuture; n2 <- gFuture) yield (n1, n2)
  }
 }

 def futureSequence[T](futures: Seq[Future[T]]): Future[Seq[T]] = {
   val initialVal = Future{ List[T]() }
   futures.foldRight(initialVal)( (future, acc) => acc.flatMap(r2 => future.map(r1 => r1 :: r2)))
 }

 def repeat[T](action: => T, until: T => Boolean): Future[T] = {
   def doRepeat(action: => T, until: T=> Boolean): T = {
     val r = action
     if (until(r)) r else doRepeat(action, until)
   }

   val p = Promise[T]
   Future{ p.success(doRepeat(action, until)) }
   p.future
 }

 //6
 //await( repeat( StdIn.readLine("Enter secret password: "), (pwd: String) => pwd == "secret" ) )
}

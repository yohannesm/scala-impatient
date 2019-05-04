import scala.util.Random

object GenerateRandomArr extends App {
  def generateArr(n: Int) = new Array[Int](n).map(_ => Random.nextInt(n))

  val arr = generateArr(20)

  arr.foreach(println)

}


object CountBackward extends App {
  def countBackward(): Unit = {
    (0 to 10).reverse.foreach(println)

    for( i <- 10.to(0, -1)) println(i)
  }

  countBackward()

}

import java.awt.Point

object OrderedPointApp extends App {
  
  class OrderedPoint extends Point with scala.math.Ordered[Point] {
    override def compare(that: Point): Int = {
      if (x < that.x || (x == that.x && y < that.y )) -1
      else if (x == that.x && y == that.y) 0
      else 1
    }
  }
}

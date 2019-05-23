

object PointsApp extends App {
  class Point(val x: Double, val y: Double)

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)

  abstract class Shape {
    def centerPoint: Point
  }
  class Rectangle(val topLeft: Point,val width: Double, val height: Double) extends Shape {
    def centerPoint = new Point(topLeft.x + width / 2.0, topLeft.y + height / 2.0)
  }
  class Circle(override val centerPoint: Point, val radius: Double) extends Shape {}

  class Square(x: Int, y: Int, size: Int) extends java.awt.Rectangle(x, y, size, size) {
    def this(size: Int) = this(0, 0, size)
    def this() = this(0, 0, 0)
    override def toString() = s"Square[x=$x, y=$y, size=$size]"
  }

}

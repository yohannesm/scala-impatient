import java.awt.Point

object EggGeometry extends App {
  
  trait RectangleLike {
    def getX(): Double
    def getY(): Double
    def getWidth(): Double
    def getHeight(): Double
    def setFrame(x: Double, y: Double, w: Double, h: Double): Unit
    def translate(dx: Double, dy: Double): Unit = {
      setFrame(getX() + dx, getY() + dy, getWidth(), getHeight())
    }
    def grow(dw: Double, dh: Double): Unit = {
      setFrame(getX() , getY(), getWidth() + dw, getHeight() + dh)
    }

    override def toString() =
      s"${getX()}, ${getY()}, ${getWidth()}, ${getHeight()}"
  }

  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  println(egg)
  egg.translate(10, -10)
  println(egg)
  egg.grow(10, 20)
  println(egg)
}

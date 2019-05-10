

object Gizmo extends App {
  val gizmoMap = Map("Excalibur" -> 200, "Bismarck" -> 300, "AWP" -> 5000, "Dragmor" -> 150, "Aventador" -> 125000)
  
  val discountRate = 0.9
  val discountedGizmoMap = gizmoMap.map{ case (k, v) => (k, v * discountRate)}
  for((k, v) <- gizmoMap){ println(s"$k $v")}
  println("after Discount")
  for((k, v) <- discountedGizmoMap){ println(s"$k $v")}
}

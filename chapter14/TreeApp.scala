

object TreeApp extends App {
  def leafSum(lst: List[Any]): Int = lst.foldLeft(0)((acc, item) => item match {
    case n: Int => acc + n
    case lst: List[_] => acc + leafSum(lst)
    case _ => acc
  })

  println("#5 test cases")
  val lst5 = List(List(3, 8), 2, List(5))

  println( leafSum(lst5) )

  object Task6 {
    sealed trait BinaryTree

    case class Leaf(value: Int) extends BinaryTree

    case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

    def leafSum(bt: BinaryTree): Int = bt match {
      case leaf: Leaf => leaf.value
      case node: Node => leafSum(node.left) + leafSum(node.right)
    }
  }
}

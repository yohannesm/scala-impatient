

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

  object Task7 {
      sealed trait Tree

      case class Leaf(value: Int) extends Tree

      case class Node(children: Tree*) extends Tree

      def leafSum(tree: Tree): Int = tree match {
        case Leaf(value) => value
        case Node(children @ _*) => children.map(leafSum).sum
      }
  }

  sealed trait OpTree

  case class OpLeaf(value: Int) extends OpTree
  case class OpNode(op: Char, leftOp: OpTree, rightOp: OpTree) extends OpTree

  def eval(tree: OpTree): Int = tree match {
    case OpLeaf(value) => value
    case OpNode('+', l, r) => eval(l) + eval(r)
    case OpNode('-', l, r) => eval(l) - eval(r)
    case OpNode('*', l, r) => eval(l) * eval(r)
    case _ => throw new RuntimeException("operator not supported")
  }

  val expr = OpNode('+', (OpNode('*', OpLeaf(3), OpLeaf(8))), (OpNode('-', OpLeaf(2), OpNode('-', OpLeaf(0), OpLeaf(5)))))
  println( eval(expr) )


}

//https://www.hackerrank.com/challenges/swap-nodes

object SwapNodes extends App {

	sealed trait Tree {
		def inOrder: List[Int] = this match {
			case Empty => Nil
			case Node(left, value, right) => left.inOrder ++ (value :: right.inOrder)
			//case Node(left, value, right) => (value :: left.preOrder) ++ right.preOrder // preOrder
			//case Node(left, value, right) => left.postOrder ++ right.postOrder ++ List(value) // postOrder
		}

	}

	case object Empty extends Tree
	case class Node(left: Tree, value: Int, right: Tree) extends Tree

	object Tree {
		def build(value: Int, nodes: Map[Int, (Int, Int)]):Tree = nodes(value) match {
			case (-1, -1) => Node(Empty, value, Empty)
			case (-1, right) => Node(Empty, value, build(right, nodes))
			case (left, -1) => Node(build(left, nodes), value, Empty)
			case (left, right) => Node(build(left, nodes), value, build(right, nodes))
		}
		def swap(depth: Int, tree: Tree):Tree = {
			def swap(level: Int, tree: Tree): Tree = tree match {
				case Empty => Empty
				case Node(left, value, right) if level % depth == 0 => Node(swap(level + 1, right), value, swap(level + 1, left)) // swap!
				case Node(left, value, right) => Node(swap(level + 1, left), value, swap(level + 1, right))
			}
			swap(1, tree)
		}
	}

	val lines = io.Source.stdin.getLines
	
	val nNodes = lines.take(1).toList(0).toInt // number of nodes
	require(1 <= nNodes && nNodes <= 1024)
	val nodes = lines.take(nNodes).toList.map(_.split(" ").map(_.toInt)).zipWithIndex.map{case (xs, i) => (i + 1 -> (xs(0), xs(1))) }.toMap
	//println(nodes)

	var tree = Tree.build(1, nodes) // build the tree
	//println(tree.inOrder.mkString(" "))

	val nSwaps = lines.take(1).toList(0).toInt // number of swaps
	require(1 <= nSwaps && nSwaps <= 100)
	val dephs = lines.take(nSwaps).toList.map(_.toInt)
	
	for (depth <- dephs) {
		tree = Tree.swap(depth, tree)
		println(tree.inOrder.mkString(" "))
	}
}
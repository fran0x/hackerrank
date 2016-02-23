//https://www.hackerrank.com/challenges/valid-bst

object ValidBST extends App {

	def isBST(L: List[Int]):Boolean = L match {
		case Nil => true
		case x :: xs => {
			val (left, right) = xs.span(_ < x)
			if (right.filter(_ < x).size > 0) false
			else isBST(left) && isBST(right)
		}
	}

	val T = io.StdIn.readInt // number of test cases
	for (t <- 1 to T) {
		val N = io.StdIn.readInt // number of nodes
		val L = io.StdIn.readLine.split(" ").map(_.toInt).toList // preorder
		println(if (isBST(L)) "YES" else "NO")
	}
}
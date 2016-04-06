//https://www.hackerrank.com/challenges/range-minimum-query

object RangeMinimumQuery extends App {

	case class Range(left: Int, right: Int)

	sealed trait SegmentTree {
		def min: Int
		def min(range: Range): Int
	}
	case class Leaf(idx: Int, min: Int) extends SegmentTree {
		println(idx + "-" + idx + ":" + min)
		override def min(range: Range): Int = min
	}
	case class Node(range: Range, min: Int, leftTree: SegmentTree, rightTree: SegmentTree) extends SegmentTree {
		println(range.left + "-" + range.right + ":" + min)		
		override def min(range: Range): Int = min
	}

	object SegmentTree {
		def build(data: Array[Int]):SegmentTree = {
			def buildTree(range: Range):SegmentTree = {
				if (range.left == range.right) Leaf(range.left, data(range.left))
				else {
					val center = (range.left + range.right) / 2
					val leftTree = buildTree(Range(range.left, center))
					val rightTree = buildTree(Range(center + 1, range.right))
					Node(range, math.min(leftTree.min, rightTree.min), leftTree, rightTree)
				}
			}
			buildTree(Range(0, data.length - 1))
		}
	}

	val lines = io.Source.stdin.getLines	
	val Array(m, n) = lines.take(1).toList(0).split(" ").map(_.toInt)
	val A = lines.take(1).toList(0).split(" ").map(_.toInt)
	val Q = lines.take(n).toList.map(_.split(" ").map(_.toInt))

	//Q map { case Array(left, right) => println(A.slice(left, right).min) }
	SegmentTree.build(A)
}
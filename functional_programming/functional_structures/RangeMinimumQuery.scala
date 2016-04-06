//https://www.hackerrank.com/challenges/range-minimum-query

object RangeMinimumQuery extends App {

	case class Range(left: Int, right: Int)

	sealed trait SegmentTree {
		def min: Int
		def min(target: Range): Int
	}
	case class Leaf(idx: Int, min: Int) extends SegmentTree {
		//println(idx + "-" + idx + ":" + min)
		override def min(target: Range): Int = min
	}
	case class Node(range: Range, min: Int, leftTree: SegmentTree, rightTree: SegmentTree) extends SegmentTree {
		//println(range.left + "-" + range.right + ":" + min)		
		override def min(target: Range): Int = {
            //println(range.left + "-" + range.right + "::" + target.left + "-" + target.right)
			if (target == range) min
			else {
				val n = (range.left + range.right) / 2
				if (n < target.left) rightTree.min(target)
				else if (n + 1 > target.right) leftTree.min(target)
				else math.min(leftTree.min(Range(target.left, n)), rightTree.min(Range(n + 1, target.right))) 
			}
		}

	}

	object SegmentTree {
		def build(data: Array[Int]):SegmentTree = {
			def buildTree(range: Range):SegmentTree = {
				if (range.left == range.right) Leaf(range.left, data(range.left))
				else {
					val n = (range.left + range.right) / 2
					val leftTree = buildTree(Range(range.left, n))
					val rightTree = buildTree(Range(n + 1, range.right))
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
	val root = SegmentTree.build(A)
	Q map { case Array(left, right) => println(root.min(Range(left, right))) }
}
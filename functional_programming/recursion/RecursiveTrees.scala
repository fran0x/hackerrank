//https://www.hackerrank.com/challenges/fractal-trees

object RecursiveTrees extends App {

	val Rows = 63
	val Columns = 100
	val Empty = List.empty
	def full = List.fill(Columns)('_')

	class Row(vert: List[Int], left: List[Int], right: List[Int]) {
		def fork = { val tuple = for (v <- vert) yield (v - 1, v + 1); Row(Empty, tuple map (_._1), tuple map (_._2)) }
		def vertical = Row(left ::: right, Empty, Empty)
		def next = vert match {
			case Empty => Row(Empty, left map (_ - 1), right map (_ + 1))
			case _ => Row(vert, Empty, Empty)
		}
		//def toString = { val string = Full; (vert ::: left ::: right) map (string(_) = '1') }
	}
	object Row { def apply(vert: List[Int], left: List[Int], right: List[Int]) = new Row(vert, left, right) }

	/*
	def f(n: Int, prev: Row):List[List[Int]] = n match {
		case 0 => List.empty
		case _ =>  
		}
	}
	*/

	val n = io.StdIn.readInt
	//val result = f(n, Empty)
	//(1 until n) map (i => println(result(i).mkString))
}
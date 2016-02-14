//https://www.hackerrank.com/challenges/fractal-trees

object RecursiveTrees extends App {

	val Rows = 63
	val Columns = 100
	val Empty = List.empty

	def full = Array.fill(Columns)('_')

	class Row(val vert: List[Int], val left: List[Int], val right: List[Int]) {
		def fork = { val tuple = for (v <- vert) yield (v - 1, v + 1); Row(Empty, tuple map (_._1), tuple map (_._2)) }
		def vertical = Row(left ::: right, Empty, Empty)
		def next = vert match {
			case Empty => Row(Empty, left map (_ - 1), right map (_ + 1))
			case _ => Row(vert, Empty, Empty)
		}
		def out = { val out = full; (vert ::: left ::: right) map (out(_) = '1'); out.mkString }
	}
	object Row { def apply(vert: List[Int], left: List[Int], right: List[Int]) = new Row(vert, left, right) }

	def f(n: Int, seg: Int, segpos: Int, prev: Row):List[String] = n match {
		case 0 => List.empty
		case _ => segpos match {
			case 1 => {
					if (prev.vert == Empty) {
						val next = prev.vertical
						next.out :: f(n - 1, seg / 2, seg / 2, next)						
					}
					else {
						val next = prev.fork
						next.out :: f(n - 1, seg, seg, next)
					}
			}
			case _ => val next = prev.next; next.out :: f(n - 1, seg, segpos - 1, next)
		}  
	}

	val n = io.StdIn.readInt
	val row = Row(List(49), Empty, Empty) 
	val out = f(n, 16, 16, row)	
	out.reverse map (println)
}
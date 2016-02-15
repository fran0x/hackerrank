//https://www.hackerrank.com/challenges/fractal-trees



object RecursiveTrees extends App {

	import scala.collection.mutable.ListBuffer
	
	val Rows = 63
	val Columns = 100
	val Center = 49
	val Segment = 16
	val Empty = List.empty

	def full = Array.fill(Columns)('_')
	val fullOut = full.mkString

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
					if (prev.vert == Empty) { // next iteration!
						val next = prev.vertical
						if (n > 1) next.out :: f(n - 1, seg / 2, seg / 2, next)
						else f(n - 1, seg / 2, seg / 2, next)				
					}
					else {
						val next = prev.fork
						next.out :: f(n, seg, seg, next)
					}
			}
			case _ => val next = prev.next; next.out :: f(n, seg, segpos - 1, next)
		}  
	}

	val n = io.StdIn.readInt // number of iterations (n <= 5)
	val row = Row(List(Center), Empty, Empty) 
	val out = (row.out :: f(n, Segment, Segment, row)).to[ListBuffer]		
	for (i <- 1 to (Rows - out.size)) out += fullOut
	out.reverse map (println)
}
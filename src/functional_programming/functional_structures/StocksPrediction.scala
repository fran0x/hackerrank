//https://www.hackerrank.com/challenges/stocks-prediction

object StocksPrediction extends App {

	case class Query(d: Int, m: Int)

	import scala.collection.mutable.{HashMap ⇒ MMap}
	val cache = MMap[Query, Int]() // let's cache prev results

	// reading inputs like this is faster than following io.Source.stdin.getLines approach
    val N = io.StdIn.readInt()
    val A = io.StdIn.readLine().split(' ').toArray.map(_.toInt)
    val Q = io.StdIn.readInt()

	def search(d: Int, m: Int) = {
		val low = A(d)
		val high = low + m
		def offRange(a: Int) = (a < low || a > high)		

		// let's play with indexes
		def searchLeft(idx: Int): Int = {
			if (idx < 0 || offRange(A(idx))) d - (idx + 1)
			else searchLeft(idx - 1)
		}
		def searchRight(idx: Int): Int = {
			if (idx >= N || offRange(A(idx))) idx - d
			else searchRight(idx + 1)			
		}

		searchLeft(d - 1) + searchRight(d + 1)
    }

	for (_ <- 1 to Q) {
       val Array(d, m) = io.StdIn.readLine().split(' ').toArray.map(_.toInt)
       println(cache getOrElseUpdate (Query(d, m), search(d, m)))
    }
}
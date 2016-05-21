object DifferentWays extends App {

	val MODULO: Int = 100000007;

	case class Query(n: Int, k: Int)

	import scala.collection.mutable.{HashMap ⇒ MMap}
	val mem = MMap[Query, Int]() // let's cache prev results

	def memCount(n: Int, k: Int) = mem getOrElseUpdate (Query(n, k), count(n, k))
	def count(n: Int, k: Int): Int = k match {
		case 0 => 1
		case `n` => 1
		case _ => (memCount(n - 1, k - 1) + memCount(n - 1, k)) % MODULO
	}

  	val t = io.StdIn.readInt // number of test cases 		
	for (_ <- 1 to t) {
		val Array(n, k) = io.StdIn.readLine.split(" ").map(_.toInt) // total number, number to be selected
		println(count(n, k))
	}

}
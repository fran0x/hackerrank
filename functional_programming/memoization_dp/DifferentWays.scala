object DifferentWays extends App {

	def count(n: Int, k: Int): Int = k match {
		case 0 => 1
		case `n` => 1
		case _ => count(n - 1, k - 1) + count(n - 1, k)
	}

  	val t = io.StdIn.readInt // number of test cases 		
	for (_ <- 1 to t) {
		val Array(n, k) = io.StdIn.readLine.split(" ").map(_.toInt) // total number, number to be selected
		println(count(n, k))
	}

}
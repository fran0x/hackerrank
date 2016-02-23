//https://www.hackerrank.com/challenges/kmp-fp

//https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
object SubstringSearching extends App {

	import scala.annotation.tailrec

	def isPresent(pat: Array[Char], text: Array[Char]) = {
		@tailrec
		def loop(p: Int, t: Int):Boolean = { // the scala idiomatic way... (aka "no returns please")
			if (p + t > text.size - 1) false
			else if (pat(p) == text(p + t)) {
				if (p == pat.size - 1) true else loop(p + 1, t)
			}
			else loop(0, t + 1)
		}

		if (pat.size > text.size) false // easy check
		else loop(0, 0)
	}

	val T = io.StdIn.readInt
	for (t <- 1 to T) {
		val text = io.StdIn.readLine.toArray
		val pat = io.StdIn.readLine.toArray
		
		println(if (isPresent(pat, text)) "YES" else "NO")
	}
}
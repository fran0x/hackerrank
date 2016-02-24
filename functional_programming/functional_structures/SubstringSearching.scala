//https://www.hackerrank.com/challenges/kmp-fp

//https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
object SubstringSearching extends App {

	import scala.annotation.tailrec

	def makeTable(pat: Array[Char]) = {
		val table = Array.fill(pat.size)(0)
		table(0) = -1
		table(1) = 0

		var pos = 2
		var cnd = 0
		while (pos < pat.size) {
			if (pat(pos - 1) == pat(cnd)) {
				table(pos) = cnd + 1
				cnd += 1
				pos += 1
			}
			else if (cnd > 0) cnd = table(cnd)
			else {
				table(pos) = 0
				pos += 1
			}
		}

		table
	}

	def isPresent(pat: Array[Char], text: Array[Char]) = {
		val T = if (pat.size == 1) Array(-1) else makeTable(pat)
		//println(T.mkString(" "))

		@tailrec
		def loop(p: Int, t: Int):Boolean = { // the scala idiomatic way... (aka "no returns please")
			if (p + t > text.size - 1) false
			else if (pat(p) == text(p + t)) {
				if (p == pat.size - 1) true else loop(p + 1, t)
			}
			else if (T(p) > -1) loop(T(p), p + t - T(p)) // backtracking
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
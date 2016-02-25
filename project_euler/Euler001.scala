//https://www.hackerrank.com/contests/projecteuler/challenges/euler001

//https://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle
object Euler001 extends App {

	def f(n: Int) = (n * n + n) / 2

	val T = io.StdIn.readInt
	for (t <- 1 to T) {
		val n = io.StdIn.readInt - 1
		println(3 * f(n / 3) + 5 * f(n / 5) - 15 * f(n / 15))
	}
}
//https://www.hackerrank.com/contests/projecteuler/challenges/euler001

//multiples of 3 and 5
object Euler001 extends App {

	//easy choice, not good performance
	//(1 until N).view.filter(x => x % 3 == 0 || x % 5 == 0).sum

	//https://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle
	//https://www.quora.com/What-is-the-sum-of-all-the-multiples-of-3-or-5-below-1000
	def f(n: Int) = (n * n + n) / 2

	val T = io.StdIn.readInt
	for (t <- 1 to T) {
		val n = io.StdIn.readInt - 1
		println(3 * f(n / 3) + 5 * f(n / 5) - 15 * f(n / 15))
	}
}
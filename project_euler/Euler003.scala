//https://www.hackerrank.com/contests/projecteuler/challenges/euler003

//largest prime factor
object Euler003 extends App {

	def isPrime(n: Int) = (2 until n).forall(d => n % d != 0)
	def largestPrimeFactor(n: Int) = (1 to math.sqrt(n).toInt).filter(isPrime(_)).filter(n % _ == 0).last

	val lines = io.Source.stdin.getLines
	val t = lines.take(1).toList(0).toInt
	lines.take(t).toList.map(_.toInt).map(n => println(largestPrimeFactor(n)))
}
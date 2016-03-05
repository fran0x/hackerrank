//https://www.hackerrank.com/contests/projecteuler/challenges/euler004

object Euler004 extends App {

	import scala.language.postfixOps
	
	def palindrome(n: Long) = (100 to 999) flatMap (x => (x to 999) map (x * _)) filter (_ < n) filter (x => x.toString == x.toString.reverse) max

	val lines = io.Source.stdin.getLines
	val t = lines.take(1).toList(0).toInt
	lines.take(t).toList.map(_.toLong).map(n => println(palindrome(n)))	
}
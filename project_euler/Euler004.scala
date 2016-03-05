//https://www.hackerrank.com/contests/projecteuler/challenges/euler004

object Euler004 extends App {

	def time(f: => Unit)= { val s = System.currentTimeMillis; f; (System.currentTimeMillis - s) + " ms" }

	import scala.language.postfixOps

  	def palindrome(str: String) = str.substring(0, str.length / 2) == str.substring(str.length / 2).reverse
  	def f(n: Long) = (for (a <- 100 until 999 ; b <- a until 999 if (a * b < n && palindrome(a * b toString))) yield a * b).max

	//def palindrome(n: Long) = (100 to 999).view flatMap (x => (x to 999).view map (x * _)) filter (_ < n) filter (x => x.toString == x.toString.reverse) max

	val lines = io.Source.stdin.getLines
	val t = lines.take(1).toList(0).toInt
	lines.take(t).toList.map(_.toLong).map(n => println(f(n)))	
}
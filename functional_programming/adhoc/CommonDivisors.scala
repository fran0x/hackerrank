//https://www.hackerrank.com/challenges/common-divisors

import scala.language.postfixOps

object CommonDivisors extends App {

	def divisors(n: Int):List[Int] = (1 to n) filter (n % _ == 0) toList
	def commonDivisors(a: Int, b: Int):Int = divisors(a).intersect(divisors(b)).size
	def parseLine(line: String):List[Int] = line.trim.split(" ").toList.map(_.toInt)

  	val lines = io.Source.stdin.getLines  		
	val n = lines.next.toInt
	for (i <- 1 to n) {
		val line = parseLine(lines.next)
		println(commonDivisors(line(0), line(1)))
	}
}
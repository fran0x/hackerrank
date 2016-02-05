//https://www.hackerrank.com/challenges/common-divisors

import scala.language.postfixOps

object CommonDivisors extends App {

	// to measure time elapsed...
	def time(f: => Unit) = {
		val s = System.currentTimeMillis
		f
		System.currentTimeMillis - s
	}

	def divisors(n: Int):List[Int] = ((1 to n / 2) filter (n % _ == 0) toList) ::: List(n) // tried first (1 to n) but timeout
	def commonDivisors(a: Int, b: Int):Int = divisors(a).intersect(divisors(b)).size
	def parseLine(line: String):List[Int] = line.trim.split(" ").toList.map(_.toInt)

  	val lines = io.Source.stdin.getLines  		
	val n = lines.next.toInt
	for (i <- 1 to n) {
		val line = parseLine(lines.next)
		//println(time { commonDivisors(line(0), line(1)) } + "ms")
		println(commonDivisors(line(0), line(1)))
	}
}
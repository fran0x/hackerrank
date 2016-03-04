//https://www.hackerrank.com/contests/projecteuler/challenges/euler003

//largest prime factor
object Euler003 extends App {

	def factors(n: Long):List[Long] = (2 to math.sqrt(n).toInt).find(n % _ == 0).fold(List(n))(i => i.toLong :: factors(n / i))

	val lines = io.Source.stdin.getLines
	val t = lines.take(1).toList(0).toInt
	lines.take(t).toList.map(_.toLong).map(n => println(factors(n).last))
}
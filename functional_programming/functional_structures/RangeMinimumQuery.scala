//https://www.hackerrank.com/challenges/range-minimum-query

object RangeMinimumQuery extends App {

	// naive approach: 0(n)
	// next: static segment tree
	
	val lines = io.Source.stdin.getLines	
	val Array(m, n) = lines.take(1).toList(0).split(" ").map(_.toInt)
	val A = lines.take(1).toList(0).split(" ").map(_.toInt)
	val Q = lines.take(n).toList.map(_.split(" ").map(_.toInt))

	Q map { case Array(left, right) => println(A.slice(left, right).min) }
}
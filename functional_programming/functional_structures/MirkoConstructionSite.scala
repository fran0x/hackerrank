//https://www.hackerrank.com/challenges/mirko-at-construction-site

object MirkoConstructionSite extends App {

	val Array(n, q) = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // n = number of buildings, q = number of queries
	val base = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // base height
	val step = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // step height

	def findTallest(q: Int): Int = 1

	for (_ <- 1 to q) println(findTallest(io.StdIn.readInt()))
}
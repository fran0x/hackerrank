//https://www.hackerrank.com/challenges/mirko-at-construction-site

object MirkoConstructionSite extends App {

	val Array(n, q) = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // n = number of buildings, q = number of queries
	val base = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // base height
	val step = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // step height

	def build(q: Int) = (0 until n) map (i => base(i) + step(i) * q)
	def find(q: Int) = build(q).zipWithIndex.maxBy(x => (x._1, x._2))._2 + 1 // see http://reactive.xploregroup.be/blog/8/Sorting-on-multiple-fields-and-Tuples

	for (_ <- 1 to q) println(find(io.StdIn.readInt()))
}
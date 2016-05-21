//https://www.hackerrank.com/challenges/mirko-at-construction-site

object MirkoConstructionSite extends App {

	val Array(n, q) = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // n = number of buildings, q = number of queries
	val base = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // base height
	val step = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // step height

	case class Query(i: Int, q: Int) // i: building index; q: number of steps

	import scala.collection.mutable.{HashMap ⇒ MMap}
	val mem = MMap[Query, Int]() // let's cache prev results

	def build(q: Int) = (0 until n) map (i => mem getOrElseUpdate(Query(i, q), base(i) + step(i) * q))
	def find(q: Int) = build(q).zipWithIndex.maxBy(x => (x._1, x._2))._2 + 1 // see http://reactive.xploregroup.be/blog/8/Sorting-on-multiple-fields-and-Tuples

	for (_ <- 1 to q) println(find(io.StdIn.readInt()))
	
	// try the following:
	// 1. read all steps and get the max
	// 2. start by the min step and calculate order
	// 3. continue with next step (reuse prev calculation?) and compare order:
	//    a. no changes then same result
	//    b. changes then last building is candidate to be ignored for further calculations
	//    c. by removing buildings we will eventually reach a point in which only 1 building will remain
}

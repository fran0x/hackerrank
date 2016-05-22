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
	// 1. read all steps and get ordered list with the indexes mapped (step 1 -> query 3, step 2 -> query 7, step 5 -> query 1)
	// 2. start by the min step and calculate order (step 1 -> 1, 4, 5, 2, 7, 3, 6); query 3 (step 1) = 1
	// 3. continue with next step (reuse prev calculation?) and compare order: (step 2 -> 1, 4, 2, 5, 7, 6, 3)
	//    a. no changes then same result: query 7 (step 2) = 1
	//    b. changes then some buildings are candidate to be ignored for further calculations: 5 and 3 go down then ignored from now on
	// by removing buildings we will eventually reach a point in which only 1 building will remain
}

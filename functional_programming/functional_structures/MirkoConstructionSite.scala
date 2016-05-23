//https://www.hackerrank.com/challenges/mirko-at-construction-site

object MirkoConstructionSite extends App {

	val Array(n, q) = io.StdIn.readLine().split(' ').toArray.map(_.toInt) // n = number of buildings, q = number of queries
	val base = io.StdIn.readLine().split(' ').toList.map(_.toInt) // base height
	val step = io.StdIn.readLine().split(' ').toList.map(_.toInt) // step height

	// (bs: building indexes, q: steps) = Map(height -> building index)
	def build(bs:List[Int], q: Int) = bs.map(b => (base(b) + step(b) * q, b)).sorted.toMap

	// buildings (indexes) in the game
	var buildings = (0 until n).toList

	// create a list of tuples (query, position)	
	var queries = List[Int]()
	for (_ <- 1 to q) queries ++= List(io.StdIn.readInt())
	val sortedQueries = queries.zipWithIndex.sorted // List[(query, original position)]

	var answers = Map[Int, Int]() // Map(query -> building index)

	// this is to get rid of buildings that get a worse position from iteration to iteration	
	var prev = Map[Int, Int]()
	def down(x:(Int, Int)) = if (prev(x._1) > x._2) true else false

	for (query <- sortedQueries) {
		val actual = build(buildings, query._1)
		answers ++= Map(query._1 -> actual.head._1)

		if (!prev.isEmpty) buildings = actual.filterNot(down).unzip._1.toList
		prev = actual
	}
	for (query <- queries) println(answers(query))  
}

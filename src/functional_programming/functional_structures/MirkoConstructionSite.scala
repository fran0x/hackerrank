//https://www.hackerrank.com/challenges/mirko-at-construction-site

object Control {
 
 	import scala.language.reflectiveCalls

	def using[A <: { def close(): Unit }, B](param: A)(f: A => B): B =
		try {
			f(param)
		} finally {
			param.close()
		}

}

object Perf {
	import java.util.concurrent.TimeUnit
	def time[R](block: => R): R = {  
    	val s = System.nanoTime()
    	val r = block    // call-by-name
    	println("Elapsed time: " + TimeUnit.SECONDS.convert(System.nanoTime() - s, TimeUnit.NANOSECONDS) + " seconds")
    	r
	}
}

object MirkoConstructionSite extends App {

    import Control._
    def readLines(filename:String):Option[Iterator[String]] = {
    	try {
    		val lines = using(io.Source.fromFile(filename)) {
    			source => (for (line <- source.getLines) yield line).toList.iterator
    		}
    		Some(lines)
    	} catch {
    		case e: Exception => None
    	}
    }

    def run(lines: Iterator[String]):Unit = {
		val Array(n, q) = lines.next.split(' ').toArray.map(_.toInt) // n = number of buildings, q = number of queries
		//println(s"n:${n} q:${q}")
		val base = lines.next.split(' ').toList.map(_.toInt) // base height
		val step = lines.next.split(' ').toList.map(_.toInt) // step height
		//println(s"bases:${base.length} steps:${step.length}")

		// (bs: building indexes, q: steps) = List((height,building index)) ordered from tallest to shortest
		def build(bs:List[Int], q: Int) = 
			bs.
			map(b => (base(b) + step(b) * q, b)).
			sorted(Ordering[(Int,Int)].reverse).
			unzip._2.
			zipWithIndex

		// buildings (indexes) in the game
		var buildings = (0 until n).toList

		// create a list of tuples (query, position)	
		val queries = new Array[Int](q)
		(0 until q).foreach(queries(_) = lines.next.toInt)
	 	val sortedQueries = queries.zipWithIndex.sorted // List[(query, original position)]
		//println(s"queries:${queries.length}")

	 	import scala.collection.mutable.{Map => MutableMap}
		var answers = MutableMap[Int, Int]() // Map(query -> building index)

		// this is to get rid of buildings that get a worse position from iteration to iteration	
		var prev = Map[Int, Int]()

		import Perf._
		time {
		    for (query <- sortedQueries) {
		    	print(buildings.length + " ")
		        if (buildings.length == 1) answers += (query._1 -> (buildings(0) + 1))
		        else {
					val actual = build(buildings, query._1) // building -> position
					answers += query._1 -> (actual.head._1 + 1)

			        if (!prev.isEmpty) buildings = for (x <- actual if (prev(x._1) >= x._2)) yield x._1
					prev = actual.toMap
		        }
			}
		}
		//for (query <- queries) println(answers(query)) 
	}

	if (args.length == 1) {
		readLines(args(0)) match {
			case Some(lines) => run(lines)
			case None => println("No lines")
		}
	}
	else println("No input")
}
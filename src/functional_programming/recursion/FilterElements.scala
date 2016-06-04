//https://www.hackerrank.com/challenges/filter-elements

object FilterElements extends App {

	import scala.collection.mutable.{Map => Map}
	import scala.annotation.tailrec
    
    @tailrec
    def f(a: List[Int], k: Int, m: Map[Int, Int]): List[Int] = a match {
        case Nil => m.filter(_._2 >= k).keys.toList
        case head :: tail => m(head) += 1; f(tail, k, m)
    }

  	val t = io.StdIn.readInt // number of test cases 		
	for (_ <- 1 to t) {
		val Array(n, k) = io.StdIn.readLine.split(" ").map(_.toInt) // list size, repetition count
		val a = io.StdIn.readLine.split(" ").map(_.toInt).toList
		
		val m = scala.collection.mutable.LinkedHashMap.empty[Int, Int] withDefaultValue 0
		val filtered = f(a, k, m)
		println(if (filtered.isEmpty) "-1" else filtered.mkString(" "))
	}
}
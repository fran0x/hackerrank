//https://www.hackerrank.com/challenges/fp-update-list

object UpdateList extends App {

	def f(arr:List[Int]):List[Int] = for (i <- arr) yield math.abs(i)

  	def parseLine(line:String):List[Int] = line.trim().split(" ").toList.map(_.toInt)

	val line = io.Source.stdin.getLines().next
    println(f(parseLine(line)))
}
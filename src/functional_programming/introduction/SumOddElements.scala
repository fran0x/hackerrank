//https://www.hackerrank.com/challenges/fp-sum-of-odd-elements

object SumOddElements extends App {

	def f(arr:List[Int]):Int = (arr filter (x => math.abs(x % 2) == 1)).sum

  	def parseLine(line:String):List[Int] = line.trim().split(" ").toList.map(_.toInt)

	val line = io.Source.stdin.getLines().next
    println(f(parseLine(line)))
}
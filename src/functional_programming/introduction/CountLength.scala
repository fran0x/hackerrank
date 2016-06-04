//https://www.hackerrank.com/challenges/fp-update-list

object CountLength extends App {

	def f(arr:List[Int]):Int = (arr map (_ => 1)).sum

  	def parseLine(line:String):List[Int] = line.trim().split(" ").toList.map(_.toInt)

	val line = io.Source.stdin.getLines().next
    println(f(parseLine(line)))
}
//https://www.hackerrank.com/challenges/fp-reverse-a-list

object ReverseList {
	
	def f(arr:List[Int]):List[Int] = arr.foldLeft(List[Int]())((r, c) => c :: r)

  	def parseLine(line:String):List[Int] = line.trim().split(" ").toList.map(_.toInt)

	def main(args: Array[String]) {
		val line = io.Source.stdin.getLines().next
    	println(f(parseLine(line)))
  	}
}
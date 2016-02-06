//https://www.hackerrank.com/challenges/string-reductions

import scala.annotation.tailrec

object StringReduction extends App {

	@tailrec
	def f(str: List[Char], output: List[Char]): List[Char] = str match {		
		case Nil => output
		case head :: tail if output.contains(head) => f(tail, output)
		case head :: tail => f(tail, head :: output)
	}

  	val line = io.StdIn.readLine
  	//println(io.StdIn.readLine.distinct)
	println(f(line.toList, List[Char]()).reverse.mkString)
}
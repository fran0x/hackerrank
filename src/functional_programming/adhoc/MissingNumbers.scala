//https://www.hackerrank.com/challenges/missing-numbers-fp

object MissingNumbers extends App {

  	val n = io.StdIn.readInt // not really needed
  	val a = io.StdIn.readLine.split(" ").toList.map(_.toInt)
  	val m = io.StdIn.readInt // not really needed
  	val b = io.StdIn.readLine.split(" ").toList.map(_.toInt)  	
  	
  	println((b diff a).distinct.sortWith(_ < _).mkString(" "))
}
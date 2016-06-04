//https://www.hackerrank.com/challenges/mango

import scala.language.postfixOps

// this one took me more than expected due to the corner cases and performance
object Mango extends App {

  	val Array(f, m) = io.StdIn.readLine.split(" ").map(_.toLong) // friends and mangoes
  	val a = io.StdIn.readLine.split(" ").map(_.toLong) // appetite
  	val h = io.StdIn.readLine.split(" ").map(_.toLong) // happiness

    var head = 0L
    var tail = a.size.toLong
    while (head < tail) {
      	val mid = (tail - head + 1) / 2 + head
  		val sum = (a, h).zipped.map(_ + (mid - 1) * _).sorted.take(mid.toInt).reduce(_ + _)
      	if (sum > m) tail = mid - 1 else head = mid
  	}
  	println(head)
}
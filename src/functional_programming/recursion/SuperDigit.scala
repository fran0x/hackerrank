//https://www.hackerrank.com/challenges/super-digit

object SuperDigit extends App {

	import scala.annotation.tailrec

	def sumDigit(s: String):BigInt = BigInt(s.foldLeft(0)(_ + _.asDigit))

	@tailrec
	def superDigit(x: BigInt):BigInt = {
		if (x < 10) x
		else superDigit(sumDigit(x.toString))
	}

	val Array(n, k) = io.StdIn.readLine.split(" ")
	val x = sumDigit(n) * k.toLong
	println(superDigit(x))
}
//https://www.hackerrank.com/challenges/super-digit

object SuperDigit extends App {

	import scala.annotation.tailrec

	@tailrec
	def superDigit(x: String):Int = {
		if (x.size == 1) x.toInt
		else superDigit(x.toList.map(_.asDigit).sum.toString)
	}

	val Array(n, k) = io.StdIn.readLine.split(" ")
	val x = n * k.toInt
	println(superDigit(x))
}
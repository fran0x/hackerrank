//https://www.hackerrank.com/challenges/stocks-prediction

object StocksPrediction extends App {

	def search(A: List[Int], d: Int, m: Int) = {
		val (left, target :: right) = A splitAt(d)
		def inRange(a: Int) = (a >= target && a <= target + m)		

		val (leftIn, leftOut) = left.reverse span (inRange(_))
		val (rightIn, rightOut) = right span (inRange(_))
		leftIn.size + 1 + rightIn.size
    }

	val lines = io.Source.stdin.getLines
	val a = lines.take(1).toList(0).toInt
	val A = lines.take(1).toList(0).split(" ").map(_.toInt).toList // require(A.length == a)
	val q = lines.take(1).toList(0).toInt
	val Q = lines.take(q).toList.map(_.split(" ").map(_.toInt))

	Q map { case Array(d, m) => println(search(A, d, m)) }
}
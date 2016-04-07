//https://www.hackerrank.com/challenges/stocks-prediction

object StocksPrediction extends App {

	def search(A: Array[Int], d: Int, m: Int) = {
		def inRange(a: Int) = (a >= A(d) && a <= A(d) + m)
    	var max, c = 0

		for (a <- A) {
      		if (inRange(a)) {
      			c += 1
      			if (c > max) max = c
      		}
      		else {
      			if (c > max) max = c
      			c = 0
      		}
      		//println(a + ":" + c + ":" + max)
      	}
      	max
    }

	val lines = io.Source.stdin.getLines
	val a = lines.take(1).toList(0).toInt
	val A = lines.take(1).toList(0).split(" ").map(_.toInt) // require(A.length == a)
	val q = lines.take(1).toList(0).toInt
	val Q = lines.take(q).toList.map(_.split(" ").map(_.toInt))

	Q map { case Array(d, m) => println(search(A, d, m)) }
}
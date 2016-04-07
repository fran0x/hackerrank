//https://www.hackerrank.com/challenges/stocks-prediction

object StocksPrediction extends App {

	val lines = io.Source.stdin.getLines
	val a = lines.take(1).toList(0).toInt
	val A = lines.take(a).toList.map(_.split(" ").map(_.toInt))
	val q = lines.take(1).toList(0).toInt
	val Q = lines.take(q).toList.map(_.split(" ").map(_.toInt))

	Q map { case Array(d, m) => println(d + "::" + m) }
}
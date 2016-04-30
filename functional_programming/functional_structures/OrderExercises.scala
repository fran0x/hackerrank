// https://www.hackerrank.com/challenges/order-exercises

// see https://en.wikipedia.org/wiki/Maximum_subarray_problem
object OrderExercises extends App {

	def max(A: Array[Int]): Int = {
		var maxLocal, maxTotal = 0
		for (a <- A) {
			maxLocal = math.max(0, maxLocal + a)
			maxTotal = math.max(maxTotal, maxLocal)
		}
		maxTotal
	}
	
	val lines = io.Source.stdin.getLines	
	val Array(n, k) = lines.take(1).toList(0).split(" ").map(_.toInt)
	val A = lines.take(1).toList(0).split(" ").map(_.toInt)
	
	println(max(A))
}
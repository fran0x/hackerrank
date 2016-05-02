// https://www.hackerrank.com/challenges/order-exercises

// see https://en.wikipedia.org/wiki/Maximum_subarray_problem
object OrderExercises extends App {

	// kadane
	def max(A: Array[Int]): Int = {
		var maxLocal, maxTotal = 0
		for (a <- A) {
			maxLocal = math.max(0, maxLocal + a)
			maxTotal = math.max(maxTotal, maxLocal)
		}
		maxTotal
	}
	// another approach, more FP: A.scanLeft(0)((acc, n) => math.max(0, acc + n)).max
	
	// ...but that´s not enough to solve this problem thus try the following:
	// run kadane and return a triplet (max, start_idx, end_idx)
	// recursively run kadane in both sides (0 to start_idx, end_idx to end), add more maxs
	
	val lines = io.Source.stdin.getLines	
	val Array(n, k) = lines.take(1).toList(0).split(" ").map(_.toInt)
	val A = lines.take(1).toList(0).split(" ").map(_.toInt)
	
	println(max(A))
}

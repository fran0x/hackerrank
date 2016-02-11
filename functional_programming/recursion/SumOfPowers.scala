//https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers

object SumOfPowers extends App {
	
	val n = io.StdIn.readInt
	val power = io.StdIn.readInt
    
    def pow(step: Int):Int = math.pow(step, power).toInt
    def sumOfPow(n: Int, step: Int): Int = n match {
      case n if n < pow(step) => 0
      case n if n == pow(step) => 1
      case _ => sumOfPow(n, step + 1) + sumOfPow(n - pow(step), step + 1)
    }
    
	println(sumOfPow(n, 1))
}
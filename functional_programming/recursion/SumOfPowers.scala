//https://www.hackerrank.com/challenges/functional-programming-the-sums-of-powers

object SumOfPowers extends App {

	// for n = 100 with power = 3, the major number we can use is 4 (4^3 = 64) because 5 exceeds 100 (5^3 = 125) 
	def logBase(n: Int, base: Int):Double = math.log(n) / math.log(base)
		
	// 100 >>> logBase(100, 3) = 4.19180654857877 >>> 4^3 = 64
	// 100 - 64 = 36 >>> logBase(36, 3) = 3.2618595071429146 >>> 3^3 = 27
	// 36 - 27 = 9 >>> logBase(9, 3) = 3 >>> 3^3 = 9
	// 9 - 9 = 0 >>> solution!

	val n = io.StdIn.readInt
	val power = io.StdIn.readInt
}
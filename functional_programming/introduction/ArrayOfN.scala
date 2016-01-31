//https://www.hackerrank.com/challenges/fp-array-of-n-elements

object ArrayOfN extends App {

	def f(num:Int):List[Int] = List.fill(num)(1)

	val n = io.StdIn.readInt
    println(f(n))
}
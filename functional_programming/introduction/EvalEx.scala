//https://www.hackerrank.com/challenges/eval-ex

object EvalEx {

	def fact(x: Int) = (1 to x).product

	def f(x: Float):Float = ((1 to 9) map (i => math.pow(x, i) / fact(i))).sum.toFloat + 1

    def main(args: Array[String]) {
       val n = io.StdIn.readInt
       (1 to n) map (_ => println(f(io.StdIn.readFloat)))
    }
}
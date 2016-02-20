//https://www.hackerrank.com/challenges/fibonacci-fp

// applying dynamic programming; performance goes from O(2^n) to O(n)
object Fibonacci extends App {

  import scala.annotation.tailrec
  
  val Zero = BigInt(0)
  val One = BigInt(1)
  val Mod = BigInt(10).pow(8) + 7

  def print(fib: BigInt) = println(fib % Mod)

  // fib(0) = 0
  // fib(1) = 1
  // fib(n) = fib(n - 1) + fib(n - 2) // for n > 1
  // https://en.wikipedia.org/wiki/tail_call
  @tailrec
  def fibonacciTail(x: BigInt, a: BigInt, b: BigInt): BigInt = {
    x match {
   		case z: BigInt if z == 0 => b // BigInt is not a case class!
    	case _ => fibonacciTail(x - 1, b, a + b)
  	}
  }

  def fibonacci(x: BigInt):BigInt = {
  	x match {
  		case z: BigInt if z == 0 => Zero
  		case _ => return fibonacciTail(x, One, Zero)
  	}		
  }

	val n = io.StdIn.readInt
  for (i <- 1 to n) print(fibonacci(io.StdIn.readInt))
}
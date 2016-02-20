//https://www.hackerrank.com/challenges/fibonacci-fp

// applying dynamic programming; performance goes from O(2^n) to O(n)
// my first approach was based on BigInt but 4th test case timed out: I did not pay attention to the point about module (see link below)
object FibonacciDP extends App {

  import scala.annotation.tailrec
  
  val Zero = 0
  val One = 1
  val Mod = (math.pow(10, 8) + 7).toInt

  // fib(0) = 0
  // fib(1) = 1
  // fib(n) = fib(n - 1) + fib(n - 2) // for n > 1
  // https://en.wikipedia.org/wiki/tail_call
  // https://codeaccepted.wordpress.com/2014/02/15/output-the-answer-modulo-109-7/
  @tailrec
  def fibonacciTail(x: Int, a: Int, b: Int): Int = {
    x match {
   		case Zero => b
    	case _ => fibonacciTail(x - 1, b, (a + b) % Mod)
  	}
  }

  def fibonacci(x: Int):Int = {
  	x match {
  		case Zero => Zero
  		case _ => return fibonacciTail(x, One, Zero)
  	}		
  }

	val n = io.StdIn.readInt
  for (i <- 1 to n) println(fibonacci(io.StdIn.readInt))
}
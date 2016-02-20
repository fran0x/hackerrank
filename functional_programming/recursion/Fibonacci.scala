//https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers

// O(2n)
object Fibonacci extends App {
  
  import scala.annotation.tailrec
  
  // fib(0) = 0
  // fib(1) = 0 // pay attention to this!
  // fib(n) = fib(n - 1) + fib(n - 2) // for n > 1
  // https://en.wikipedia.org/wiki/tail_call
  @tailrec
  def fibonacciTail(x: Int, a:Int, b:Int): Int = {
    x match {
   		case 0 => a 
    	case _ => fibonacciTail(x-1, b, a+b)
  	}
  }

  def fibonacci(x:Int):BigInt = {
  	x match {
  		case 0 => 0
  		case _ => return fibonacciTail(x, 1, 0)
  	}		
  }

	val n = io.StdIn.readInt
  println(fibonacci(n))
}
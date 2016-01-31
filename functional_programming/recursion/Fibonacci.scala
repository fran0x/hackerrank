//https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers

import scala.annotation.tailrec

// O(2n)
object Fibonacci extends App {

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
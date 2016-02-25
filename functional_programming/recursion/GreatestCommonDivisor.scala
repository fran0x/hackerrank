//https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd

// euclidean method
// example: gcd(48, 18)
//          is 18 == 0? no
//          48 % 18 = 12 (quotient)
//          gcd(18, 12)
//          is 12 == 0? no
//          18 % 12 = 6
//          gcd(12, 6)
//          is 6 == 0? no
//          12 % 6 = 0
//          gcd(6, 0)
//          is 6 == 0? yes then return 6
object GreatestCommonDivisor extends App {

  import scala.annotation.tailrec
  
  @tailrec
  def gcd(x: Int, y: Int): Int =
	{
    y match {
      case 0 => x
      case _ => gcd(y, x%y)
    }
  }
  
  def parseLine(line:String):List[Int] = line.trim().split(" ").toList.map(_.toInt)

	val input = parseLine(io.Source.stdin.getLines().next)
  println(gcd(input.head, input.reverse.head))
}
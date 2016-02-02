//https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd

object GreatestCommonDivisor extends App {

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
//https://www.hackerrank.com/challenges/huge-gcd-fp

import scala.annotation.tailrec

object HugeGreatestCommonDivisor extends App {

  @tailrec
  def gcd(x: BigInt, y: BigInt): BigInt =
	{
    y match {
      case z: BigInt if z == 0 => x // remember: BigInt is not a case class
      case _ => gcd(y, x%y)
    }
  }
  
  io.StdIn.readInt // no need for the first line thus ignore it
	val a = io.StdIn.readLine.split(" ").toList.map { BigInt(_) }.reduce(_ * _)
  io.StdIn.readInt // no need for the third line thus ignore it
  val b = io.StdIn.readLine.split(" ").toList.map { BigInt(_) }.product // only to use something different

  println(gcd(a, b) % BigInt(1000000007)) // remember: print the gcd of numbers A and B modulo 1000000007
}
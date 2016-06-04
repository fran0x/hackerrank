//https://www.hackerrank.com/challenges/jumping-bunnies

//see https://en.wikipedia.org/wiki/least_common_multiple
object JumpingBunnies extends App {

	import scala.annotation.tailrec
  
 	@tailrec
  	def gcd(x: BigInt, y: BigInt): BigInt = y match {
      case z: BigInt if z == 0 => x
      case _ => gcd(y, x%y)
    }

    def lcm(a: BigInt, b: BigInt): BigInt = (a * b).abs / gcd(a, b)

	val n = io.StdIn.readInt
	val jumps = io.StdIn.readLine.split(" ").map(BigInt(_))
	println(jumps.reduce(lcm(_, _)))
}
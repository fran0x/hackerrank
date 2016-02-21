//https://www.hackerrank.com/challenges/lists-and-gcd

object ListGCD extends App {

  import scala.collection.mutable.{HashMap => MMap}

  val EmptyList = List[Int]()
  val mem = MMap[Int, List[Int]]()

  def parseLine(line: String):List[(Int, Int)] = line.split(" ").map(_.toInt).grouped(2).toList.map(x => (x(0), x(1)))  
  def add(xs: List[(Int, Int)]) = for ((prime, exp) <- xs) mem += (prime -> (exp :: mem.getOrElse(prime, EmptyList)))
  def gcd(n: Int) = for ((prime, exps) <- mem if exps.size == n) yield (prime, exps.min)

  val n = io.StdIn.readInt
  for (i <- 1 to n) add(parseLine(io.StdIn.readLine))

  val output = gcd(n).toList.sorted.flatMap(x => x.productIterator.toList)
  println(output.mkString(" "))
}
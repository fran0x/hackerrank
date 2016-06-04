//https://www.hackerrank.com/challenges/lists-and-gcd

object ListGCD extends App {

  import scala.collection.mutable.{HashMap => MMap}

  type Factors = List[(Int, Int)]
  val EmptyList = List[Int]()
  val mem = MMap[Int, List[Int]]()

  def parseLine(line: String):Factors = line.split(" ").map(_.toInt).grouped(2).toList.map(x => (x(0), x(1)))  
  def addFactors(factors: Factors) = for ((prime, exp) <- factors) mem += (prime -> (exp :: mem.getOrElse(prime, EmptyList)))
  def gcd(n: Int) = for ((prime, exps) <- mem if exps.size == n) yield (prime, exps.min)

  val n = io.StdIn.readInt
  for (i <- 1 to n) addFactors(parseLine(io.StdIn.readLine))

  val output = gcd(n).toList.sorted.flatMap(x => x.productIterator.toList)
  println(output.mkString(" "))
}
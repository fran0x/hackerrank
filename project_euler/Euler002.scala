//https://www.hackerrank.com/contests/projecteuler/challenges/euler002

// even fibonacci numbers
object Euler002 extends App {

	//https://lampsvn.epfl.ch/trac/scala/browser/scala/trunk/src///library/scala/collection/immutable/Stream.scala
	lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)

	val T = io.StdIn.readInt
	for (t <- 1 to T) {
		val N = io.StdIn.readLong
		println((fibs takeWhile(_ < N) filter(_ % 2 == 0)).sum)
	}
}
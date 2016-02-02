//https://www.hackerrank.com/challenges/rotate-string
import scala.language.postfixOps

object RotateString extends App {
    
    def rotate(word: String): List[String] = { for (i <- 1 to word.length toList) yield word.drop(i) + word.take(i) }
        
	val lines = io.Source.stdin.getLines()
    val n = lines.next.toInt
	for (i <- 1 to n) println(rotate(lines.next).mkString(" "))
}
//https://www.hackerrank.com/challenges/string-compression

object StringCompression extends App {

	def f(word: List[Char]): List[Char] = word match {
    	case Nil => List.empty
        case x :: xs =>
          	val (y, ys) = xs span (_ == x)
          	if (y.nonEmpty) x :: (y.length + 1).toString.toList ::: f(ys)
          	else x :: f(xs)
    }   	

  	val line = io.StdIn.readLine()
	println(f(line.toList).mkString)
}
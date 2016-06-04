//https://www.hackerrank.com/challenges/prefix-compression

object PrefixCompression extends App {

	def f(x: List[Char], y: List[Char]): List[Char] =
	{
    	if (x.isEmpty) return List.empty
    	return x.head :: y.head :: f(x.tail, y.tail)
  	}

  	val lines = io.Source.stdin.getLines()
	val x = lines.next.toList
  	val y = lines.next.toList
  	println(f(x, y).mkString)
} 
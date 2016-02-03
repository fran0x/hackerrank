//https://www.hackerrank.com/challenges/string-mingling

object StringMingling extends App {

	def f(pawel: List[Char], shaka: List[Char]): List[Char] =
	{
    	if (pawel.isEmpty) return List.empty
    	return pawel.head :: shaka.head :: f(pawel.tail, shaka.tail)
  	}

  	val lines = io.Source.stdin.getLines()
	val pawel = lines.next.toList
  	val shaka = lines.next.toList
  	println(f(pawel, shaka).mkString)
}
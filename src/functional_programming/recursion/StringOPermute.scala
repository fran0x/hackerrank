//https://www.hackerrank.com/challenges/string-o-permute

object StringOPermute extends App {

	def f(word: List[Char]): List[Char] =
	{
    	if (word.isEmpty) return List.empty
    	return word(1) :: word(0) :: f(word.drop(2))
  	}

  	val lines = io.Source.stdin.getLines()
  	val n = lines.next.toInt
	for (i <- 1 to n) println(f(lines.next.toList).mkString)
}
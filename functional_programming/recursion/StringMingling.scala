//https://www.hackerrank.com/challenges/string-mingling

object StringMingling extends App {

  def f(pawel: String, shaka: String): String =
	{
    if (pawel.isEmpty) return ""
    return pawel.take(1) + shaka.take(1) + f(pawel.tail, shaka.tail)
  }

  val lines = io.Source.stdin.getLines()
	val pawel = lines.next
  val shaka = lines.next
  println(f(pawel, shaka))
}
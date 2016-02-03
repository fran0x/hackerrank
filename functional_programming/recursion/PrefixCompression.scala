//https://www.hackerrank.com/challenges/prefix-compression

object PrefixCompression extends App {

  	def f(a: List[Char], b: List[Char], count: Int): Int = {
    	if (a.isEmpty || b.isEmpty || a.head != b.head) count
    	else f(a.tail, b.tail, count + 1)
	}

  	val lines = io.Source.stdin.getLines()
  	val a = lines.next
  	val b = lines.next
	val count = f(a.toList, b.toList, 0)
	println(count + " " + a.substring(0, count))
	println((a.length - count) + " " + a.substring(count, a.length))
	println((b.length - count) + " " + b.substring(count, b.length))
}
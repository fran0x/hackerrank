//https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv

object AreaAndVolumeCurve {
	
	//def f(c:List[Int], p:List[Int], x:Double):Double = ((0 until c.length) map (i => c(i) * math.pow(x, p(i)))).sum
	def f(c:List[Int], p:List[Int], x:Double):Double = ((c zip p) map (i => i._1 * math.pow(x, i._2))).sum

	// V=π∫{f(x)}^2 dx (see http://www.intmath.com/applications-integration/4-volume-solid-revolution.php)
	def area(c:List[Int], p:List[Int], x:Double):Double = math.Pi * math.pow(f(c, p, x), 2)

	def summation(func:(List[Int], List[Int], Double) => Double, high:Int, low:Int, c:List[Int], p:List[Int]):Double = {
    	((low.toDouble to high.toDouble by 0.001d) map (func(c, p, _) * 0.001d)).sum
 	}

	def displayAnswers(c:List[Int], p:List[Int], limits:List[Int])
	{
		println("Area=" + summation(f, limits.reverse.head, limits.head, c, p))
    	println("Volume=" + summation(area, limits.reverse.head, limits.head, c, p))
  	}

  	def parseLine(line:String):List[Int] = line.trim().split(" ").toList.map(_.toInt)

	def main(args: Array[String]) {
		val lines = io.Source.stdin.getLines()
		val c = parseLine(lines.next)
		val p = parseLine(lines.next)
		val limits = parseLine(lines.next)
    	displayAnswers(c, p, limits)
  	}
}
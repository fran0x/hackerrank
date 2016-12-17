//https://www.hackerrank.com/challenges/sherlock-and-array

object SherlockArray extends App {

    def equilibrium(a: Array[Long]): Boolean = {
        if (a.length < 2) return true
            
        var p1 = 0L
        var v = a(0)            
        var p2 = a.drop(1).sum
         
        (1 until a.length) foreach { idx => {
            if (p1 == p2) return true
            p1 += v
            v = a(idx)
            p2 -= v
        }}
        false
    }

    val t = io.StdIn.readInt 
    (1 to t) foreach { _ =>
      val n = io.StdIn.readLine
      val a = io.StdIn.readLine.split(" ").map(_.toLong)
      if (equilibrium(a)) println("YES") else println("NO")
    }
}

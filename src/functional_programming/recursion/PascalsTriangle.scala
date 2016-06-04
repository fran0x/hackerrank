//https://www.hackerrank.com/challenges/pascals-triangle

object PascalsTriangle extends App {
    
    def pascalsRow(i: Int, k: Int, row: Array[Int]) {
        if (i > k) return

        for (j <- i-2 until 0 by -1) { row(j) = row(j) + row(j-1) }
        
        println(row.slice(0, i).mkString(" "))
        pascalsRow(i+1, k, row)
    }

	val n = io.StdIn.readInt
	pascalsRow(1, n, Array.fill(n)(1))
}
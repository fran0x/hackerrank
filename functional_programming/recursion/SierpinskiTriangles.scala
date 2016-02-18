 //https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles

// iteration 0: triangle = 32 rows x 63 columns
// iteration 1: triangle = 16 rows x 31 columns >> 16 = 32 / 2; 31 = (63 - 1) / 2 >> 
// iteration 2: triangle = 8 rows x 15 columns
// iteration 3: triangle = 4 rows x 7 columns
// iteration 4: triangle = 2 rows x 3 columns
// iteration 5: triangle = 1 row x 1 column

object SierpinskiTriangles extends App {

	val Rows = 32
	val Columns = 63

	val One = '1'
	val Dash = '_'

	def print(triangle: Array[Array[Char]]) = triangle map (x  => println(x.mkString))
	def slice(list: List[Int], n: Int) = list.drop(n).dropRight(n)
	def ones(n: Int) = Array.fill(n)(Dash) ++ Array.fill(Columns - 2 * n)(One) ++ Array.fill(n)(Dash) 
	def dashRow(row: Array[Char], columns: List[Int]) = columns foreach (row(_) = Dash)
	def dashTriangle(triangle: Array[Array[Char]], rows: List[Int], columns: List[Int]) = rows.zipWithIndex foreach (x => dashRow(triangle(x._1), slice(columns, x._2))) 

	val n = io.StdIn.readInt

	val triangle = Array.ofDim[Char](Rows, Columns)
	(0 until Rows) foreach (x => triangle(x) = ones(x))
	print(triangle)

	dashTriangle(triangle.reverse, List.range(Rows / 2, Rows), List.range(1 + Columns / 4, 3 * Columns / 4))
}
 //https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles

object SierpinskiTriangles extends App {

	val Rows = 32
	val Columns = 63

	val One = '1'
	val Dash = '_' // more than Dash it should be called Underscore

	// create a row with 'side' dashes at each side filling with ones the rest
	def onesRow(side: Int) = Array.fill(size)(Dash) ++ Array.fill(Columns - 2 * side)(One) ++ Array.fill(side)(Dash) 
	def isOne(row: Array[Char], c: Int) = row(c) == One // check if a certain cell has a one
	def dashesTriangle(triangle: Array[Array[Char]], m)
	def dashesRow(row: Array[Char], m: Int, d: Int) = if (isOne(row(c))) (m - d to m + d) foreach(row(_) = Dash) // change from ones to dashes

	
	// iteration 0: triangle = 32 rows x 63 columns
	// iteration 1: triangle = 16 rows x 31 columns >> 16 = 32 / 2; 31 = (63 - 1) / 2 >> 
	// iteration 2: triangle = 8 rows x 15 columns
	// iteration 3: triangle = 4 rows x 7 columns
	// iteration 4: triangle = 2 rows x 3 columns
	// iteration 5: triangle = 1 row x 1 column

	// at each iteration an input is the triangle from the previous iteration, and then, based on the indexes, we change elements from 1 to _
	// starting from the top we work with a list of center points for inverted triangles; sometimes it will
	
	def iterate(n: Int, prev: Array[Array[Char]], r: Int, c: Int):Array[Array[Char]] = n match {
		case 0 => prev
		case _ => {
			
		}
	}

	val n = io.StdIn.readInt // number of iterations (n <= 5)

	// generate the triangle for iteration 0
	val triangle = Array.ofDim[Char](Rows, Columns)
	(0 until Rows) foreach (x => triangle(x) = ones(x))

	val result = iterate(n, triangle, 32, 63)
}
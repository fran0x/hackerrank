 //https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles

object SierpinskiTriangles extends App {

	import scala.annotation.tailrec
	import scala.collection.mutable.{ListBuffer ⇒ MList}

	type Position = (Int, Int)
	type Indexes = List[Int]
	type SectionType = Boolean
	type Row = Array[Char]
	type Triangle = Array[Array[Char]]

	val Rows = 32
	val Columns = 63

	val One = '1'
	val Dash = '_'

	val RowSection = true
	val ColumnSection = false

	def triangle0 = {
		def row(n: Int) = Array.fill(n)(Dash) ++ Array.fill(Columns - 2 * n)(One) ++ Array.fill(n)(Dash)

		val triangle = Array.ofDim[Char](Rows, Columns)
		(0 to Rows - 1) foreach (x => triangle(x) = row(x))
		triangle
	}

	def nextSize(prev: Int, sectionType: SectionType):Int = if (sectionType == RowSection) prev / 2 else (prev - 1) / 2
	def nextIndexes(sectionSize: Int, sectionType: SectionType):Indexes = {
		val mlist = MList[Int]()
		if (sectionType == RowSection) mlist += 0

		var acc = sectionSize
		val sectionLimit = if (sectionType == RowSection) Rows else Columns
		val sectionExtra = 
		while (acc < sectionLimit) {
			mlist += acc
			if (sectionType == RowSection) acc += sectionSize else acc += sectionSize + 1
		}

		mlist.toList
	}
	def crossIndexes(columns: Indexes, rows: Indexes):List[Position] = for {c <- columns; r <- rows } yield (c, r)

	def isOne(triangle: Triangle, position: Position) = triangle(position._2)(position._1) == One
	def print(triangle: Triangle) = triangle.reverse map (x  => println(x.mkString))

	def columns(center: Int, n: Int) = List.range(center - n, center + n + 1)
	def dashRow(row: Row, columns: List[Int]) = columns foreach (row(_) = Dash)
	def dashTriangle(triangle: Triangle, position: Position, rowSize: Int) = (0 until rowSize) foreach(x => dashRow(triangle(position._2 + x), columns(position._1, x)))

	@tailrec
	def iterate(n: Int, triangle: Triangle, columnSize: Int, rowSize: Int):Triangle = n match {
		case 0 => triangle
		case _ => {
			val columns = nextIndexes(columnSize, ColumnSection)
			val rows = nextIndexes(rowSize * 2, RowSection)
			val positions = crossIndexes(columns, rows)
			for (position <- positions) if (isOne(triangle, position)) dashTriangle(triangle, position, rowSize)

			iterate(n - 1, triangle, nextSize(columnSize, ColumnSection), nextSize(rowSize, RowSection))
		}
	}

	val n = io.StdIn.readInt
	val triangle = iterate(n, triangle0, nextSize(Columns, ColumnSection), nextSize(Rows, RowSection))
	print(triangle)
}
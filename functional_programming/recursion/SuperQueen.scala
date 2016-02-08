//https://www.hackerrank.com/challenges/super-queens-on-a-chessboard

//backtracking problem
object SuperQueen extends App {

	type Queen = (Int, Int)
	def isSafe(queen: Queen, others: List[Queen]) = others forall (!isAttacked(queen, _))
	def isAttacked(q: Queen, o: Queen) = {
		q._1 == o._1 || // same row
		q._2 == o._2 || // same column
		(o._1 - q._1).abs == (o._2 - q._2).abs || // same diagonal
		((o._1 - q._1).abs + (o._2 - q._2).abs) == 3 // knight
	}

	val n = io.StdIn.readInt
	val board = Array.fill(n, n)(0)
}
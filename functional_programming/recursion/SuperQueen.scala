//https://www.hackerrank.com/challenges/super-queens-on-a-chessboard

//backtracking problem
object SuperQueen extends App {

	type Queen = (Int, Int)
	
	// true if no other queen is attacking this position
	def isSafe(queen: Queen, others: List[Queen]) = others forall (!isAttacked(queen, _))
	
	// true if the other queen is attacking this position (moves: queen + knight)
	def isAttacked(q: Queen, o: Queen) = q._1 == o._1 || q._2 == o._2 || (o._1 - q._1).abs == (o._2 - q._2).abs || ((o._1 - q._1).abs + (o._2 - q._2).abs) == 3
    
    def placeQueens(bsize: Int, col: Int): List[List[Queen]] = col match {
		case 0 => List(Nil)
		case _ => for {
			queens <- placeQueens(col-1)
			row <- 1 to col
			queen = (col, row)
			if (isSafe(queen, queens))
		} yield queen :: queens
	}

	val bsize = io.StdIn.readInt // board size
    println(placeQueens(bsize, bsize).size)	
}
//https://www.hackerrank.com/challenges/super-queens-on-a-chessboard

//typical propagation and backtracking problem
object SuperQueen extends App {

	type Queen = (Int, Int)
	
	// true if no other queen is attacking this position
	def isSafe(queen: Queen, others: List[Queen]) = others forall (!isAttacked(queen, _))
	
	// true if the other queen is attacking this position (moves: queen + knight)
	def isAttacked(q: Queen, o: Queen) = q._1 == o._1 || q._2 == o._2 || (o._1 - q._1).abs == (o._2 - q._2).abs || ((o._1 - q._1).abs + (o._2 - q._2).abs) == 3
    
    def placeQueens(n: Int, x: Int): List[List[Queen]] = x match {
		case 0 => List(Nil)
		case _ => for {
			queens <- placeQueens(n, x-1) // move column from right to left
			y <- 1 to n // move row from top to bottom
			queen = (x, y)
			if (isSafe(queen, queens)) // only add the queen if is safe
		} yield queen :: queens // compose a list of lists of queens
	}

	val n = io.StdIn.readInt // board size
    println(placeQueens(n, n).size)	
}
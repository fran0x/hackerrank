//https://www.hackerrank.com/challenges/sequence-full-of-colors

object FullOfColors extends App {
	
  class Deck(var r: Int, var g: Int, var y: Int, var b: Int) {
    def isPrefixOK = (r - g).abs < 2 && (y - b).abs < 2 
    def isEqualOK = r == g && y == b
  }
  object Deck { def apply(r: Int, g: Int, y: Int, b: Int) = new Deck(r, g, y, b) }

  def isFull(xs: List[Char], deck: Deck):Boolean = xs match {
    case 'R' :: xs => deck.r += 1; if (deck.isPrefixOK) isFull(xs, deck) else false
    case 'G' :: xs => deck.g += 1; if (deck.isPrefixOK) isFull(xs, deck) else false
    case 'Y' :: xs => deck.y += 1; if (deck.isPrefixOK) isFull(xs, deck) else false
    case 'B' :: xs => deck.b += 1; if (deck.isPrefixOK) isFull(xs, deck) else false
    case _ => deck.isEqualOK
  }

  val n = io.StdIn.readInt
  for (_ <- 1 to n) {
    val line = io.StdIn.readLine.toList
    val deck = Deck(0, 0, 0, 0)
    println(if (isFull(line, deck)) "True" else "False")
  }
}
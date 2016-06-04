//https://www.hackerrank.com/challenges/remove-duplicates

object RemoveDuplicates extends App {

  	val line = io.StdIn.readLine
  	println(line.distinct)
  	
  	// other options:
  	//line.toSet.mkString
  	//scala.collection.mutable.SortedSet[Char]()
	//line.foldLeft[List[Char]] (List.empty) { (list, current) => { if ((list find { _ == current }) == None) current :: list else list }}.reverse  	
}
object Choices {
  val stone = new Option("Stone", 0)
  val lizard = new Option("Lizard", 1)
  val spock = new Option("Spock", 2)
  val scissors = new Option("Scissors", 3)
  val paper = new Option("Paper", 4)

  def getRandom() = {
    val rand =  Math.floor(4.9999999 * Math.random() )
    rand match {
      case 0 => stone
      case 1 => lizard
      case 2 => spock
      case 3 => scissors
      case 4 => paper
    }
  }
}

final class Option(val choice: String, val value: Int) {

}


class Board(val numberOfRounds: Int) {

  def play() {
    val total = game(numberOfRounds)
    if (total > 0) println ("Player 1 wins the tournament!")
    else if (total < 0) println ("Player 2 wins the tournament!")
    else println("Tournament resulted in a draw!")
  }

  def game(remainingRounds: Int):  Int = {
    val player1 = Choices.getRandom()
    val player2 = Choices.getRandom()

    println("Round: " + (numberOfRounds - remainingRounds + 1))
    println("Player 1 chooses: " + player1.choice)
    println("Player 2 chooses: " + player2.choice)

    val round = new Round(player1, player2)
    val result = round.evaluate()

    println(if (result == 1) "Player 1 won!" else if (result == -1) "Player 2 won!" else "Draw!")
    println("----------------------------")
    if (remainingRounds > 1) game(remainingRounds -1) + result
    else result
  }
}

import org.scalatest.FunSuite

class RoundTest extends FunSuite {

  private def testEvaluation(first: Option, second: Option, winner: Int): Unit = {
    val round = new Round(first, second)
    assert(round.evaluate() == winner)
  }

  test("sciscors cuts paper") {
    testEvaluation(Choices.scissors, Choices.paper, Result.firstWins)
  }

  test("sciscors cuts paper reverse") {
    testEvaluation(Choices.paper, Choices.scissors, Result.secondWins)
  }

  test("same choice means draw") {
    val round1 = new Round(Choices.scissors, Choices.scissors)
    assert(round1.evaluate() == Result.draw)
    val round2 = new Round(Choices.paper, Choices.paper)
    assert(round2.evaluate() == Result.draw)
    val round3 = new Round(Choices.stone, Choices.stone)
    assert(round3.evaluate() == Result.draw)
    val round4 = new Round(Choices.lizard, Choices.lizard)
    assert(round4.evaluate() == Result.draw)
    val round5 = new Round(Choices.spock, Choices.spock)
    assert(round5.evaluate() == Result.draw)
  }

  test("paper beats stone") {
    testEvaluation(Choices.paper, Choices.stone, Result.firstWins)
  }

  test("paper beats stone reverse") {
    testEvaluation(Choices.stone, Choices.paper, Result.secondWins)
  }

  test("stone beats lizard") {
    testEvaluation(Choices.stone, Choices.lizard, Result.firstWins)
  }

  test("stone beats lizard reverse") {
    testEvaluation(Choices.lizard, Choices.stone, Result.secondWins)
  }

  test("lizard poisons Spock") {
    testEvaluation(Choices.lizard, Choices.spock, Result.firstWins)
  }

  test("lizard poisons Spock reverse") {
    testEvaluation(Choices.spock, Choices.lizard, Result.secondWins)
  }

  test("Spock destroys scissors") {
    testEvaluation(Choices.spock, Choices.scissors, Result.firstWins)
  }

  test("Spock destroys scissors reverse") {
    testEvaluation(Choices.scissors, Choices.spock, Result.secondWins)
  }

  test("Scissors beheads lizard") {
    testEvaluation(Choices.scissors, Choices.lizard, Result.firstWins)
  }

  test("Scissors beheads lizard reverse") {
    testEvaluation(Choices.lizard, Choices.scissors, Result.secondWins)
  }

  test("lizard eats paper") {
    testEvaluation(Choices.lizard, Choices.paper, Result.firstWins)
  }

  test("lizard eats paper reverse") {
    testEvaluation(Choices.paper, Choices.lizard, Result.secondWins)
  }

  test("paper contradicts Spock") {
    testEvaluation(Choices.paper, Choices.spock, Result.firstWins)
  }

  test("paper contradicts Spock reverse") {
    testEvaluation(Choices.spock, Choices.paper, Result.secondWins)
  }

  test("Spock evaporates stone") {
    testEvaluation(Choices.spock, Choices.stone, Result.firstWins)
  }

  test("Spock evaporates stone reverse") {
    testEvaluation(Choices.stone, Choices.spock, Result.secondWins)
  }

  test("stone sharpens scissors") {
    testEvaluation(Choices.stone, Choices.scissors, Result.firstWins)
  }

  test("stone sharpens scissors reverse") {
    testEvaluation(Choices.scissors, Choices.stone, Result.secondWins)
  }
}

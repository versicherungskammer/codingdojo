
object Result extends Enumeration {
  val firstWins = -1
  val secondWins = 1
  val draw = 0
}

class Round(first: Option, second: Option) {
  def evaluate(): Int = {
    val temp = first.value - second.value
    if (temp == 0) return Result.draw
    var res = 0
    if (temp < 0)
      res = temp + 5
    else
      res = temp

    if (res ==1 || res == 3)
      Result.secondWins
    else
      Result.firstWins
  }
}


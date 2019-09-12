import 'dart:math';

void main(List<String> inputList) {
  const attacks = ["schere", "papier", "stein", "echse", "spock"];
  var playerAttack = inputList[0];

  if (!attacks.contains(playerAttack)) throw Exception;

  var r = Random();
  var computerAttack = attacks[r.nextInt(5)];
  var output = duelAndReturnWinnerNumber(playerAttack, computerAttack);

  if (output == 0) {
    print("Draw: $playerAttack vs. $playerAttack");
    return;
  }
  if (output == 1) {
    print("Player wins: $playerAttack vs. ${computerAttack}");
    return;
  } else {
    {
      print("Computer wins: $playerAttack vs. ${computerAttack}");
      return;
    }
  }
}

int duelAndReturnWinnerNumber(String attack1, String attack2) {
  var temp;
  if (attack1 == attack2) return 0;
  for (int i = 1; i < 3; i++) {
    if (attack1 == "schere" && attack2 == "papier") return i;
    if (attack1 == "papier" && attack2 == "stein") return i;
    if (attack1 == "echse" && attack2 == "spock") return i;
    if (attack1 == "spock" && attack2 == "schere") return i;
    if (attack1 == "schere" && attack2 == "echse") return i;
    if (attack1 == "echse" && attack2 == "papier") return i;
    if (attack1 == "papier" && attack2 == "spock") return i;
    if (attack1 == "spock" && attack2 == "stein") return i;
    if (attack1 == "stein" && attack2 == "schere") return i;
    temp = attack1;
    attack1 = attack2;
    attack2 = temp;
  }
  return null;
}

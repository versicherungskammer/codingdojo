guess_dict: dict = {'rock': 0, 'spock': 1, 'paper': 2, 'lizard': 3, 'scissors': 4}
def play(player1: str, player2: str) -> None:
    try:
        distance: int = (guess_dict[player1] - guess_dict[player2]) % 5
        print("equal" if distance == 0 else player1 + " wins" if 0 < distance <= 2 else player2 + " wins")
    except:
        print("Please choose two from:\n" + "\n".join(guess_dict))

if __name__ == "__main__":
    play(player1 = 'scissors', player2 = 'paper')
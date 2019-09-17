guess_dict: dict = {'rock': 0, 'spock': 1, 'paper': 2, 'lizard': 3, 'scissors': 4}

def play(player1: str, player2: str) -> None:
    try:
        distance: int = (guess_dict[player1] - guess_dict[player2]) % 5
    except:
        distance: int = -1
        print("Please choose two from:\n" + "\n".join(guess_dict))
    if distance == 0:
        print("equal")
    elif 0 < distance <= 2:
        print(player1, "wins")
    elif distance > 2:
        print(player2, "wins")

if __name__ == "__main__":
    play(player1 = 'scissors', player2 = 'paper')

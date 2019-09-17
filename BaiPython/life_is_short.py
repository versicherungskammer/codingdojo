guess_dict: dict = {'rock': 0, 'spock': 1, 'paper': 2, 'lizard': 3, 'scissors': 4}

def main(player1: str, player2: str) -> None:
    dist: int = (guess_dict[player1] - guess_dict[player2]) % 5
    if dist == 0:
        print("equal")
    elif 0 < dist <= 2:
        print("player1 wins")
    elif dist > 2:
        print("player2 wins")
    else:
        print("wrong play")

if __name__ == "__main__":
    main(player1 = 'scissors', player2 = 'rock')
class Card:
    def __init__(self, suit, value):
        self.suit = suit
        self.value = value
    
    def __str__(self):
        cardname = ""
        match self.value:
            case 11:
                cardname = "Jack"
            case 12:
                cardname = "Queen"
            case 13:
                cardname = "King"
            case 1:
                cardname = "Ace"
            case _:
                cardname = str(self.value)
        match self.suit:
            case 0:
                return cardname + " of Clubs"
            case 1:
                return cardname + " of Diamonds"
            case 2:
                return cardname + " of Hearts"
            case 3:
                return cardname + " of Spades"



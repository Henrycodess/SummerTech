from card import Card
from random import randint
class Deck:
    def __init__(self):
        self.deck = []
        for j in range(13):
            for i in range(4):
                card = Card(i, j+1)
                self.deck.append(card)
    def shuffle(self):
        for i in range(len(self.deck)):
            x = randint(i, len(self.deck) - 1)
            TEMP = self.deck[i]
            self.deck[i] = self.deck[x]
            self.deck[x] = TEMP
            TEMP = None
    def functionthatssolefunctionistoremoveacardfromthedeck(self):
        self.deck.pop()
            

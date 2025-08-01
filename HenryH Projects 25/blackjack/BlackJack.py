from deck import Deck
from card import Card
import emoji
deck = Deck()
psum = 0
dsum = 0
playerhand = []
dealerhand = []
def sumhand(hand, sum):
    sum = 0
    acetracker2000 = 0
    aces11 = 0
    cn = 0
    for i in range(len(hand)):
        if hand[i].value > 10:
            cn = 10
        elif hand[i].value == 1:
            cn = 11
            acetracker2000 += 1
            aces11 += 1
        else:
            cn = hand[i].value
        sum += cn
        if sum > 21 and aces11 > 0:
            sum -= 10
            aces11 -= 1
    return sum
        


def hit(hand):
    hand.append(deck.deck.pop(0))
def turn(hand, sum):
    sum = sumhand(hand, sum)
    pturn = True
    while pturn:
        sum = sumhand(hand, sum)
        for i in range(len(hand)):
            print(hand[i])
        print(sum)
        if sum < 21:
            move = input("hit or stand?")
            if move == "hit":
                hit(hand)
            elif move == "stand":
                pturn = False
            elif move == "choose":
                rcard = 21 - sum
                for i in range(len(deck.deck)):
                    if deck.deck[i].value == rcard:
                        hand.append(deck.deck.pop(i))
                        pturn = False
                        break
            else:
                print("Incorrect move, please try again")
        elif sum > 21:
            print("YOU LOSE HAHAHAHA BYE BYE MONEY LETS GO GAMBLING AW DANGIT")
            exit()
        else:
            print("YOU WIN LETS GO GAMBLING AW YEAH, AW YEAH")
            print(emoji.emojize(":money-mouth_face:"))
            exit()

deck.shuffle()

hit(playerhand)
hit(playerhand)
hit(dealerhand)
hit(dealerhand)
print("dealers upcard " + str(dealerhand[0]))
print("playerhand:")
turn(playerhand, psum)
print("players upcard " + str(playerhand[0]))
print("dealerhand:")
turn(dealerhand, dsum)
if sumhand(dealerhand, dsum) > sumhand(playerhand, psum):
    print("Dealer wins")
    exit()
elif sumhand(dealerhand, dsum) < sumhand(playerhand, psum):
    print("Player wins")
    print(emoji.emojize(":money-mouth_face:"))
    exit()
else:
    print("PUSH")
    exit()
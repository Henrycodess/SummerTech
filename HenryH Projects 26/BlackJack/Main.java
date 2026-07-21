import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Boolean playerTurn = true;
    public static void main(String[] args) {
        ArrayList<Card> playerHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        Deck deck = new Deck();
        deck.Shuffle();
        playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck()); //upcard
        dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        System.out.println(dealerHand.get(0));
        while (playerTurn){
            Turn(playerHand, deck);
        }
        for (int i = 0; i < 100; i++){
            System.out.println("");
        }
    }
    public static int sumHand(ArrayList<Card> hand){
        int sum = 0;
        int ace11s = 0;
        for (int i = 0; i < hand.size(); i++){
            sum += hand.get(i).getValue();
            if (hand.get(i).toString().contains("Ace")){
                if (sum + 10 <= 21){
                    sum += 10;
                    ace11s += 1;
                }
            }
        }
        if (sum > 21 && ace11s > 0){
            sum -= 10;
        }
        return sum;
    }
    public static void Turn(ArrayList<Card> hand, Deck deck){
        Scanner scanny = new Scanner(System.in);
        System.out.println(hand);
        System.out.println(String.valueOf(sumHand(hand)));
        System.out.println("Hit or Stand?");
        if (scanny.next().equalsIgnoreCase("hit")){
            hand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        }
        else if (scanny.next().equalsIgnoreCase("stand")){
            playerTurn = !playerTurn;
        }
        else{
            System.out.println("Wrong move bucko");
        }
        if (sumHand(hand) > 21){
            System.out.println("Bust");
            System.exit(67);
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static Boolean playerTurn = true;
    public static ArrayList<Card> playerHand = new ArrayList<Card>();
    public static ArrayList<Card> dealerHand = new ArrayList<Card>();
    public static Deck deck = new Deck();
    public static void main(String[] args) {
        deck.Shuffle();
        playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck()); //upcard
        dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        System.out.println(dealerHand.get(0));
        while (playerTurn){
            Turn();
            System.out.println(playerTurn);
        }
        while (!playerTurn){
            Turn();
        }
        if (sumHand(playerHand) > sumHand(dealerHand)){
            System.out.println("Player wins");
        }
        else if (sumHand(playerHand) < sumHand(dealerHand)){
            System.out.println("Dealer wins");
        }
        else{
            System.out.println("Tie...");
        }
        System.out.println("yaay");
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
    public static boolean Turn(){
        Scanner scanny = new Scanner(System.in);
        if (playerTurn){        
            System.out.println(playerHand);
            System.out.println(String.valueOf(sumHand(playerHand)));
        }
        else{
            System.out.println(dealerHand);
            System.out.println(String.valueOf(sumHand(dealerHand)));
        }
        System.out.println("Hit or Stand?");
        String input = scanny.next();
        if (input.equalsIgnoreCase("hit")){
            if (playerTurn){
                playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
                if (playerHand.get(playerHand.size() - 1).getSuit() == 0){
                    System.out.println("gfijofdihjgofdihgfdkiikddiiddididiid");
                }
            }
            else{dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());}
        }
        else if (input.equalsIgnoreCase("stand")){
            playerTurn = !playerTurn;
            scanny.close();
            return true;
        }
        else{
            System.out.println("Wrong move bucko");
        }
        if (playerTurn){        
            if (sumHand(playerHand) > 21){
                System.out.println("Bust");
                System.exit(67);
            }
        }
        else{
            if (sumHand(dealerHand) > 21){
                System.out.println("Bust");
                System.exit(67);
            }
        }
        scanny.close();
        return true;

    }
}
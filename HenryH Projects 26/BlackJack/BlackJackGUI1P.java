import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BlackJackGUI1P{
    public static JButton Hit = new JButton("Hit");
    public static JButton Stand = new JButton("Stand");
    public static JFrame jJFrame = new JFrame("Blackjack");
    public static ImageIcon cardIcon = new ImageIcon("C:\\Users\\user\\HHST\\SummerTech\\HenryH Projects 26\\BlackJack\\Deck\\BJcard_0.aapng");
    public static String imagePath = "C:\\Users\\user\\HHST\\SummerTech\\HenryH Projects 26\\BlackJack\\Deck\\";
    public static JLabel dealerUp = new JLabel("");
    public static JLabel dealerDown = new JLabel("");
    public static JLabel playerUp = new JLabel("");
    public static JLabel playerDown = new JLabel("");
    public static JLabel playerThree = new JLabel("");
    public static JLabel playerFour = new JLabel("");
    public static JLabel playerFive = new JLabel("");
    public static JLabel dealerLabel = new JLabel("Dealer");
    public static JLabel playerLabel = new JLabel("Player");
    public static JPanel dealerSide = new JPanel();
    public static JPanel playerSide = new JPanel();
    public static JPanel buttonSide = new JPanel();
    public static Boolean playerTurn = true;
    public static Boolean gameOver = false;
    public static ArrayList<Card> playerHand = new ArrayList<Card>();
    public static ArrayList<Card> dealerHand = new ArrayList<Card>();
    public static ArrayList<JLabel> playerCards = new ArrayList<JLabel>();
    public static ArrayList<JLabel> dealerCards = new ArrayList<JLabel>();
    public static Deck deck = new Deck();
    public static void Turn(){
        if (playerTurn){        
            System.out.println(playerHand);
            System.out.println(String.valueOf(sumHand(playerHand)));
        }
        else{
            System.out.println(dealerHand);
            System.out.println(String.valueOf(sumHand(dealerHand)));
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
    public static String getImagePath(Card card){
        switch (card.getSuit()){
            case 0:
                return imagePath + "BJcard_" + String.valueOf(card.getValue() + 25) + ".png";
            case 1:
                return imagePath + "BJcard_" + String.valueOf(card.getValue() - 1) + ".png";
            case 2:
                return imagePath + "BJcard_" + String.valueOf(card.getValue() + 12) + ".png";
            case 3:
                return imagePath + "BJcard_" + String.valueOf(card.getValue() + 38) + ".png";
            default:
                return "failed... somehow";
        }

    }
    public static void main(String[] args) {

        String[] deckImages = new String[60];

        //dealer
        dealerSide.setLayout(new BoxLayout(dealerSide, BoxLayout.Y_AXIS));
        dealerSide.add(dealerLabel);
        dealerSide.add(dealerUp);
        dealerSide.add(dealerDown);
        dealerSide.add(Hit);
        //player
        playerSide.setLayout(new BoxLayout(playerSide, BoxLayout.Y_AXIS));
        playerSide.add(playerLabel);
        playerSide.add(playerUp);
        playerSide.add(playerDown);
        playerSide.add(Stand);
        //buttons
        buttonSide.setLayout(null);
        Hit.setBounds(500, 500, 100, 100);
        Stand.setBounds(1250, 500, 100, 100);
        //Cards
        for (int i = 0; i < 60; i++){
            deckImages[i] = "BJcard_" + String.valueOf(i) + ".png";
        }
        buttonSide.add(Hit);
        buttonSide.add(Stand);
        jJFrame.setLayout(new BorderLayout());
        jJFrame.add(dealerSide, BorderLayout.EAST);
        jJFrame.add(playerSide, BorderLayout.WEST);
        jJFrame.add(buttonSide);

        // MyButton.setbounds(x, y, width, height)

        jJFrame.setVisible(true);
        jJFrame.setSize(500, 500);
        // Game
        deck = new Deck();
        deck.Shuffle();
        playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck()); //upcard
        cardIcon = new ImageIcon(getImagePath(playerHand.get(playerHand.size() - 1)));
        playerUp.setIcon(cardIcon);
        playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        cardIcon = new ImageIcon(getImagePath(playerHand.get(playerHand.size() - 1)));
        playerDown.setIcon(cardIcon);
        dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck()); //upcard
        cardIcon = new ImageIcon(getImagePath(dealerHand.get(dealerHand.size() - 1)));
        dealerUp.setIcon(cardIcon);
        dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
        cardIcon = new ImageIcon(imagePath + "BJcard_52.png");
        dealerDown.setIcon(cardIcon);
        System.out.println(dealerHand.get(0) + "dealers upcard");
        System.out.println(playerHand);
        System.out.println(String.valueOf(sumHand(playerHand)));
        Hit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerTurn){
                    playerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
                    cardIcon = new ImageIcon(getImagePath(playerHand.get(playerHand.size() - 1)));
                    System.out.println(cardIcon.toString());
                    playerCards.add(new JLabel(""));
                    playerCards.get(playerCards.size() - 1).setIcon(cardIcon);
                    playerSide.add(playerCards.get(playerCards.size() - 1));
                    jJFrame.add(playerSide, BorderLayout.WEST);
                    jJFrame.revalidate();
                    jJFrame.repaint();
                }
                else{
                    dealerHand.add(deck.functionThatsSoleFunctionIsToDrawACardFromTheDeck());
                    cardIcon = new ImageIcon(getImagePath(dealerHand.get(dealerHand.size() - 1)));
                    System.out.println(cardIcon.toString());
                    dealerCards.add(new JLabel(""));
                    dealerCards.get(dealerCards.size() - 1).setIcon(cardIcon);
                    dealerSide.add(dealerCards.get(dealerCards.size() - 1));
                    jJFrame.add(dealerSide, BorderLayout.EAST);
                    jJFrame.revalidate();
                    jJFrame.repaint();
                }
                System.out.println("gogogogogoogogogogogo");
                if (playerTurn){        
                    System.out.println(playerHand);
                    System.out.println(String.valueOf(sumHand(playerHand)));
                }
                else{
                    System.out.println(dealerHand);
                    System.out.println(String.valueOf(sumHand(dealerHand)));
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
            }
            
        });
        Stand.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bleh");
                playerTurn = !playerTurn;
                if (playerTurn){        
                    System.out.println(playerHand);
                    System.out.println(String.valueOf(sumHand(playerHand)));
                }
                else{
                    System.out.println(dealerHand);
                    System.out.println(String.valueOf(sumHand(dealerHand)));
                    cardIcon = new ImageIcon(getImagePath(dealerHand.get(1)));
                    dealerDown.setIcon(cardIcon);
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
                if (playerTurn){
                    if (sumHand(playerHand) > sumHand(dealerHand)){
                        System.out.println("Player wins");
                        System.exit(67);
                    }
                    else if (sumHand(playerHand) < sumHand(dealerHand)){
                        System.out.println("Dealer wins");
                        System.exit(67);
                    }
                    else{
                        System.out.println("Tie...");
                        System.exit(67);
                    }
                }
            } 
        });

        while (true){
            System.out.println(playerTurn);
            if (!playerTurn){
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException e){
                    
                }
                System.out.println("blehhhhhhhh");  
                if (sumHand(dealerHand) < 17){
                    Hit.doClick(250);
                }
                else{
                    Stand.doClick(250);
                }
            }
        }
    }
}
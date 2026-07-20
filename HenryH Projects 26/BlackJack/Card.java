public class Card {
    private int suit;
    private int value;
    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }
    public int getSuit(){
        return suit;
    }
    public int getValue(){
        return value;
    }
    public void setSuit(int suit){
        this.suit = suit;
    }
    public void setValue(int value){
        this.value = value;
    }
    public String toString(){
        String cardName;
        switch (value) {
            case 1:
                cardName = "Ace";
                break;
        
            case 11:
                cardName = "Jack";
                break;
            case 12:
                cardName = "Queen";
                break;
            case 13:
                cardName = "King";
                break;
            default:
                cardName = String.valueOf(value);
                break;
        }
        switch (suit) {
            case 0:
                cardName += " Of Spades";
                break;
            case 1:
                cardName += " Of Hearts";
                break;
            case 2:
                cardName += " Of Diamonds";
                break;
            case 3:
                cardName += " Of Clubs";
                break;
        }
        return cardName;
    }
    public static void main(String[] args) {
        System.out.println(new Card(0, 1));
    }
}
import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int deckSize;
    public Deck(){
        for (int i = 1; i < 12; i++){
            for (int j = 0; j < 4; j++){
                deck.add(new Card(j++, i));
                deckSize = i++ * j++;
            }
        }
    }
    public int getSize(){
        return deckSize;
    }
    public Card functionThatsSoleFunctionIsToDrawACardFromTheDeck(){
        deckSize--;
        return deck.remove(0);
    }
    public void Shuffle(){
        Collections.shuffle(deck);
    }
    
}

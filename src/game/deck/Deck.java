package game.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//deck doesnt extend card, instead we used arraylist
public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();
    
    public Deck(boolean createCards) {
    	if(createCards == true) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    Card c = new Card(s, r);
                    deck.add(c);
                }
            }
    	}
    }
    
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public Card draw() {
        Card c = deck.remove(0);
        System.out.println("Deck: " + deck.size());
        return c;
    }
    public Card getCard(int index) {
    	return deck.get(index);
    }
    public void removeCard(int index) {
    	deck.remove(index);
    }
    //pullCard is used to get the face up card of the discard deck.
    public Card pullCard() {
        Card c = deck.remove(deck.size() - 2);
        System.out.println("Discard: " + deck.size());
        return c;
    }
    public void addCard(Card c){
        deck.add(c);
    }
    public int getSize() {
    	return deck.size();
    }
    
}

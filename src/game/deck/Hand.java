package game.deck;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	// list of card objects
    private List<Card> hand = new ArrayList<Card>(); 
    
    public static int gamesWon = 0;
    
    public int spadesHandValue = 0;
    public int diamondHandValue = 0;
    public int heartHandValue = 0;
    public int clubHandValue = 0;
    
    public Hand(){
    }
    
    public int getHandTotal(){
        return spadesHandValue+diamondHandValue+heartHandValue+clubHandValue;
    }
    public void calcSuitValues(){
        spadesHandValue = 0;
        diamondHandValue = 0;
        heartHandValue = 0;
        clubHandValue = 0;
        
        for(Card c : hand){
             switch (c.getSuit()) {
                 case 1:
                     spadesHandValue += c.getRank();
                     break;
                 case 2:
                     heartHandValue += c.getRank();
                     break;
                 case 3:
                     diamondHandValue += c.getRank();
                     break;
                 case 4:
                     clubHandValue += c.getRank();
                     break;
                 default:
                     break;
             }
        }
    }
    
    public int getCardSuitValue(int suit) {
    		calcSuitValues();
            switch (suit) {
                case 1:
                    return spadesHandValue;
                case 2:
                    return heartHandValue;
                case 3:
                    return diamondHandValue;
                case 4:
                    return clubHandValue;           
                default:
                    return -1;
            }
    }
    
    public int getHighestSuit() {
    	calcSuitValues();
    	int max = spadesHandValue;
    	int suit = 1;
    	
    	if(max < heartHandValue) {
    		max = heartHandValue;
    		suit = 2;
    	}
    	else if(max < diamondHandValue) {
    		max = diamondHandValue;
    		suit = 3;
    	}else if(max < clubHandValue) {
    		max = clubHandValue;
    		suit = 4;
    	}
    	return suit;
    }
    
    public int getHighestSuitValue() {
    	calcSuitValues();
    	int max = spadesHandValue;
    	
    	if(max < heartHandValue) {
    		max = heartHandValue;
    	}
    	else if(max < diamondHandValue) {
    		max = diamondHandValue;
    	}else if(max < clubHandValue) {
    		max = clubHandValue;
    	}
    	return max;
    }
    
    public int getLowestSuitValue() {
    	calcSuitValues();
    	int min = spadesHandValue;
    	
    	if(min > heartHandValue) {
    		min = heartHandValue;
    	}
    	else if(min > diamondHandValue) {
    		min = diamondHandValue;
    	}else if(min > clubHandValue) {
    		min = clubHandValue;
    	}
    	return min;
    }
    public int getLowestCardIndex() {
    	//needs to range from 0-2
    	int index = 2;
    	for(int i = 0; i < hand.size() ; i++) {
    		if(hand.get(i).getRank() < hand.get(index).getRank()) {
    			index = i;
    		}

    	
    	}
    	
    	return index + 1;
    }
    
    public void addCardToHand(Card card){
        hand.add(card);
    }
    
    public List<Card> cardsInHand(){
        return hand;
    }
    
    public Card getCardFromIndex(int i){
        return hand.get(i - 1);
    }
    
    public void changeCard(int i, Card c){
        hand.set(i - 1, c);
    }
    
    
}
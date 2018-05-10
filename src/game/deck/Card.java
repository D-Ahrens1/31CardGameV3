package game.deck;

public class Card {
    
    private final Suit suit;
    private final Rank rank;

    public Card(Suit cSuit, Rank cValue) {
        suit = cSuit;
        rank = cValue;
    }

    @Override
    public String toString() {
        return (rank.toString() + " of " + suit.toString());
    }
    
    public int getRank(){
        return rank.getValue();
    }
 
    public int getSuit(){
        return suit.getValue();
    }
    
    public String getImage(){
        switch(this.rank){
            case JACK:
                return "/game/images/"+11+(suit.toString().toLowerCase().charAt(0))+".jpg".trim();
            case QUEEN:
                return "/game/images/"+12+(suit.toString().toLowerCase().charAt(0))+".jpg".trim();
            case KING:
                return "/game/images/"+13+(suit.toString().toLowerCase().charAt(0))+".jpg".trim();
            case ACE:
                return "/game/images/"+14+(suit.toString().toLowerCase().charAt(0))+".jpg".trim();
		default:
			break;
           
        }
        	//System.out.println("/game/images/"+rank.getValue()+(suit.toString().toLowerCase().charAt(0))+".jpg".trim());
            return "/game/images/"+rank.getValue()+(suit.toString().toLowerCase().charAt(0))+".jpg".trim();
    }
}
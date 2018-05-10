package game.deck;

public enum Suit {
    Spades(1),
    Hearts(2),
    Diamonds(3),
    Clubs(4);
    
    private final int suit;
    
    Suit(int suit){
        this.suit = suit;
    }
    public int getValue(){
        return suit;
    }
}
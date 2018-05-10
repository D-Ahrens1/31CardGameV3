package player;
//we imported everything necessary as a player object
import game.deck.Card;
import game.deck.Hand;

public class Player {
	private Hand playerHand = new Hand();
	private int score = 0;
	private String name;
	private boolean isCpu;
	private int turn;

	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public Player(String name, boolean isPlayerCpu, int turn) {
		this.name = name;
		this.isCpu = isPlayerCpu;
		this.turn = turn;
	}
	public void addCardToHand(Card card){
		playerHand.addCardToHand(card);
	}
	public Card getCardFromHandByIndex(int i) {
		
		return playerHand.getCardFromIndex(i);
	}
	public void swapCard(int index, Card card) {
		playerHand.changeCard(index, card);
	}
	public int getPlayerScore() {
		return this.score;
	}
	public void setPlayerScore(int score) {
		this.score = score;
	}
	public String getPlayerName() {
		return name;
	}
	public boolean isCpu() {
		return isCpu;
	}
	public void setCpu(boolean isCpu) {
		this.isCpu = isCpu;
	}
	public void calcHandvalues() {
		playerHand.calcSuitValues();
	}
	public int getSuitValue(int suit) {
		return playerHand.getCardSuitValue(suit);
	}
	public int getHighestSuit() {
		return playerHand.getHighestSuit();
	}
	public int getHighestSuitValue() {
		return playerHand.getHighestSuitValue();
	}
	public int getLowestCardIndex() {
		return playerHand.getLowestCardIndex();
	}
}

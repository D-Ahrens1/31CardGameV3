package game.logic;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.deck.Deck;
import game.gui.GameFrame;
import game.gui.InstructionsFrame;
import game.gui.MainMenuFrame;
import game.gui.SettingMenuFrame;
import game.gui.GameOverFrame;
import player.Player;

public class GameLogic {
	private static boolean areBtnsEnabled = true;
	
	private static String currentFrame = "";
	private static String winnerName;
	private static Player currentPlayer;
	private static Player playerThatKnocked;
	private static boolean renderFrame = false;
	private static boolean runGame = false;
	private static boolean createPlayers = true;
	private static Deck gameDeck = new Deck(true);
	private static Deck discardDeck = new Deck(false);
	private static String gameState;

	private static boolean hasKnocked = false;
	//private static boolean aPlayerKnocked = false;
	private static boolean playerThinking = true;
	private static boolean hasPlayerFinishedTurn = false;
	private static boolean calculated = false;

	private static InstructionsFrame instructionFrame = new InstructionsFrame();
	private static MainMenuFrame mainMenuFrame = new MainMenuFrame();
	private static GameFrame gameFrame = new GameFrame();
	private static GameOverFrame gameOverFrame = new GameOverFrame();
	
	private static SettingMenuFrame settingMenuFrame = new SettingMenuFrame();
	
	private static int score = 0;
	private static int highScore = 0;
	private static int cardSelected = 0;
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	private static int numberOfHumanPlayers = 1;
	
	
	public static void setCalculated(boolean state) {
		GameLogic.calculated = state;
	}
	public static boolean hasCalculated() {
		return calculated;
	}
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}

	public static void setCurrentPlayer(Player currentPlayer) {
		GameLogic.currentPlayer = currentPlayer;
	}

	public static Player getPlayerThatKnocked() {
		return playerThatKnocked;
	}

	public static void setPlayerThatKnocked(Player playerThatKnocked) {
		GameLogic.playerThatKnocked = playerThatKnocked;
	}

	public static String getGameState() {
		return gameState;
	}

	public static void setGameState(String gameState) {
		GameLogic.gameState = gameState;
	}

	public static boolean isPlayerThinking() {
		return playerThinking;
	}

	public static void setPlayerThinking(boolean playerThinking) {
		GameLogic.playerThinking = playerThinking;
	}

	public static boolean isHasPlayerFinishedTurn() {
		return hasPlayerFinishedTurn;
	}

	public static void setHasPlayerFinishedTurn(boolean hasPlayerFinishedTurn) {
		GameLogic.hasPlayerFinishedTurn = hasPlayerFinishedTurn;
	}

	public static GameFrame getGameFrame() {
		return gameFrame;
	}
	
	public static GameOverFrame getGameOverFrame() {
		return gameOverFrame;
	}

	public static boolean isAreBtnsEnabled() {
		return areBtnsEnabled;
	}

	public static void setAreBtnsEnabled(boolean areBtnsEnabled) {
		GameLogic.areBtnsEnabled = areBtnsEnabled;
	}

	public static int getCardSelected() {
		return cardSelected;
	}
	
	public static boolean getRunGame() {
		return runGame;
	}

	public static void setRunGame(boolean runGame) {
		GameLogic.runGame = runGame;
	}

	public static boolean getHasKnocked() {
		return hasKnocked;
	}

	public static void setHasKnocked(boolean hasKnocked) {
		GameLogic.hasKnocked = hasKnocked;
	}

	public static ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public static void setPlayerList(ArrayList<Player> playerList) {
		GameLogic.playerList = playerList;
	}
	
	public static void renderLoop() {
		if (renderFrame == true) {
			System.out.println(currentFrame);
			switch (currentFrame) {
			case "MainMenu":
				instructionFrame.setVisible(false);
				gameFrame.setVisible(false);
				gameOverFrame.setVisible(false);
				mainMenuFrame.setVisible(true);
				renderFrame = false;
				break;
			case "InstructionFrame":
				gameFrame.setVisible(false);
				mainMenuFrame.setVisible(false);
				gameOverFrame.setVisible(false);
				instructionFrame.setVisible(true);
				renderFrame = false;
				break;
			case "GameFrame":
				mainMenuFrame.setVisible(false);
				instructionFrame.setVisible(false);
				settingMenuFrame.setVisible(false);
				gameOverFrame.setVisible(false);
				gameFrame.setVisible(true);
				renderFrame = false;
				break;
			case "SettingMenuFrame":
				mainMenuFrame.setVisible(false);
				instructionFrame.setVisible(false);
				gameFrame.setVisible(false);
				gameOverFrame.setVisible(false);
				settingMenuFrame.setVisible(true);
				renderFrame = false;
			case "GameOverFrame":
				gameFrame.setVisible(false);
				instructionFrame.setVisible(false);
				settingMenuFrame.setVisible(false);
				mainMenuFrame.setVisible(false);
				gameOverFrame.setVisible(true);
				renderFrame = false;
				break;
			default:
				break;
			}
		}
	}
	
	public static void setGameFrame(String frame) {
		System.out.println("Frame has been set to: " + frame);
		currentFrame = frame;
		renderFrame = true;
	}
	public static void setGameOverFrame(String frame) {
		System.out.println("Frame has been set to: " + frame);
		currentFrame = frame;
		renderFrame = true;
	}

	public static void setCardSelected(int cardSel) {
		cardSelected = cardSel;
		System.out.println("Card: " + cardSelected + " was selected");
	}
	
	public static void setDefualtCardBacks() {
		gameFrame.getBtnCardOne().setIcon(new ImageIcon(gameFrame.getClass().getResource("/game/images/cardback.jpg")));
		gameFrame.getBtnCardTwo().setIcon(new ImageIcon(gameFrame.getClass().getResource("/game/images/cardback.jpg")));
		gameFrame.getBtnCardThree().setIcon(new ImageIcon(gameFrame.getClass().getResource("/game/images/cardback.jpg")));
	}
	public static void showCards() {
		gameFrame.getBtnCardOne().setIcon(new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(1).getImage())));
		gameFrame.getBtnCardTwo().setIcon(new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(2).getImage())));
		gameFrame.getBtnCardThree().setIcon(new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(3).getImage())));
	}
	
	public static void setPlayerHasKnocked(boolean knock) {
		hasKnocked = knock;
		playerThatKnocked = currentPlayer;
		System.out.println("knocked");
	}

	public static void setNumberOfHumanPlayers(int numOfHumanPlayers) {
		numberOfHumanPlayers = numOfHumanPlayers;
	}
	
	public static void setBtnEnable(boolean enableButton) {
		gameFrame.getBtnCardOne().setEnabled(enableButton);
		gameFrame.getBtnCardTwo().setEnabled(enableButton);
		gameFrame.getBtnCardThree().setEnabled(enableButton);
		gameFrame.getBtnDeck().setEnabled(enableButton);
		gameFrame.getBtnStartTurn().setEnabled(enableButton);
		areBtnsEnabled = enableButton;
	}

	public static void startGame() {
		runGame = true;
		System.out.println("Game Has Been Started");
	}

	public static int getNumberOfHumanPlayers() {
		return numberOfHumanPlayers;
	}
	
	public static void endTurnBtnPressed() {
		setDefualtCardBacks();
		hasPlayerFinishedTurn = true;
		System.out.println(hasPlayerFinishedTurn);
	}

	public static void startTurnBtnPressed() {
		showCards();
		hasPlayerFinishedTurn = false;
	}
	
	public static void createPlayers() {
		if (createPlayers == true) {
			for (int i = 1; i <= 4; i++) {
				if (i <= numberOfHumanPlayers) {
					playerList.add(new Player(settingMenuFrame.getPlayerName(i), false, i));
				} else {
					playerList.add(new Player(settingMenuFrame.getPlayerName(i), true, i));
				}
			}

			for (Player player : playerList) {
				player.addCardToHand(gameDeck.draw());
				player.addCardToHand(gameDeck.draw());
				player.addCardToHand(gameDeck.draw());
			}
		}
		createPlayers = false;
	}
	
	public static void getCurrentPlayerCardImages() {
		gameFrame.getBtnCardOne().setIcon(
				new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(1).getImage())));
		gameFrame.getBtnCardTwo().setIcon(
				new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(2).getImage())));
		gameFrame.getBtnCardThree().setIcon(
				new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(3).getImage())));
	}

	public static void gameDeckPressed() {
		if (cardSelected != 0) {
			gameFrame.getBtnDiscard().setIcon(new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(cardSelected).getImage())));
			discardDeck.addCard(currentPlayer.getCardFromHandByIndex(cardSelected));
			System.out.println("Top discarded card: " + discardDeck.getCard(discardDeck.getSize() - 1));
			currentPlayer.swapCard(cardSelected, gameDeck.draw());
			if(currentPlayer.isCpu() == false)
			showCards();
		}
		cardSelected = 0;

	}
	
	public static void gameDiscardDeckPressed() {
		if (cardSelected != 0) {
			gameFrame.getBtnDiscard().setIcon(new ImageIcon(gameFrame.getClass().getResource(currentPlayer.getCardFromHandByIndex(cardSelected).getImage())));
			discardDeck.addCard(currentPlayer.getCardFromHandByIndex(cardSelected));
			currentPlayer.swapCard(cardSelected, discardDeck.pullCard());
			//discardDeck.removeCard(discardDeck.getSize() - 2);
			System.out.println("Top discarded card: " + discardDeck.getCard(discardDeck.getSize() - 1));
			if(currentPlayer.isCpu() == false)
			showCards();
		}
		cardSelected = 0;

	}
	
	public static Deck getGameDeck() {
		return gameDeck;
	}
	
	public static void calcHighScore(Player player) {
		if(calcScore(player) > GameLogic.highScore) {
			GameLogic.highScore = GameLogic.calcScore(player);
			GameLogic.winnerName = player.getPlayerName();
		}
	}
	
	public static String getWinnerName() {
		return GameLogic.winnerName;
	}
	
	public static int getWinnerScore() {
		return GameLogic.highScore;
	}
		
	//score calculator
	public static int calcScore(Player player) {
		//all cards are same suit
		if(player.getCardFromHandByIndex(1).getSuit() == 
				player.getCardFromHandByIndex(2).getSuit() &&
					player.getCardFromHandByIndex(2).getSuit() == 
							player.getCardFromHandByIndex(3).getSuit()) {
			
			GameLogic.score = player.getCardFromHandByIndex(1).getRank()
							  + player.getCardFromHandByIndex(2).getRank()
							  + player.getCardFromHandByIndex(3).getRank();
		}
		//card 1, 2 same suit
		else if(player.getCardFromHandByIndex(1).getSuit() == 
				player.getCardFromHandByIndex(2).getSuit() &&
					player.getCardFromHandByIndex(2).getSuit() != 
						player.getCardFromHandByIndex(3).getSuit()) {
			
			GameLogic.score = player.getCardFromHandByIndex(1).getRank()
					  		  + player.getCardFromHandByIndex(2).getRank();
		}
		//card 1, 3 same suit
		else if(player.getCardFromHandByIndex(1).getSuit() == 
				player.getCardFromHandByIndex(3).getSuit() &&
					player.getCardFromHandByIndex(1).getSuit() != 
						player.getCardFromHandByIndex(2).getSuit()) {
			
			GameLogic.score = player.getCardFromHandByIndex(1).getRank()
					  		  + player.getCardFromHandByIndex(3).getRank();
		}
		//card 2, 3 same suit
		else if(player.getCardFromHandByIndex(1).getSuit() != 
				player.getCardFromHandByIndex(2).getSuit() &&
					player.getCardFromHandByIndex(2).getSuit() == 
						player.getCardFromHandByIndex(3).getSuit()) {
			
			GameLogic.score = player.getCardFromHandByIndex(2).getRank()
					  		  + player.getCardFromHandByIndex(3).getRank();
		}
		//None are same suit (takes highest value as score)
		else {			
			int temp;
			if (player.getCardFromHandByIndex(1).getRank() > player.getCardFromHandByIndex(2).getRank()) {
				temp = player.getCardFromHandByIndex(1).getRank();
			}
			else if (player.getCardFromHandByIndex(1).getRank() < player.getCardFromHandByIndex(2).getRank()) {
				temp = player.getCardFromHandByIndex(2).getRank();
			}
			//if both cards are same value but different suit
			else {
				temp = player.getCardFromHandByIndex(1).getRank();
			}
			//check if the highest of card 1,2 are less than card 3
			if (temp < player.getCardFromHandByIndex(3).getRank()){
				temp = player.getCardFromHandByIndex(3).getRank();
			}
			//dont need to check if temp and card 3 are equal cuz temp is already the value
			GameLogic.score = temp;
		}	
		return score;
	}
	public static void peekCurrentPlayerHand() {
		System.out.println(GameLogic.getCurrentPlayer().getCardFromHandByIndex(1));
		System.out.println(GameLogic.getCurrentPlayer().getCardFromHandByIndex(2));
		System.out.println(GameLogic.getCurrentPlayer().getCardFromHandByIndex(3));
		System.out.println("Score count: " + GameLogic.calcScore(GameLogic.getCurrentPlayer()));
	}
		
}

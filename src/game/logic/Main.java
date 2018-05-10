package game.logic;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.deck.Card;
import game.deck.Deck;
import game.gui.GameFrame;
import game.gui.InstructionsFrame;
import game.gui.MainMenuFrame;
import game.gui.SettingMenuFrame;
import player.Player;

public class Main {

	public static void main(String[] args) {

		new Thread(() -> {
			while (true) {
				GameLogic.renderLoop();

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		GameLogic.setGameFrame("MainMenu");
		GameLogic.getGameDeck().shuffle();

		while (true) {
			if (GameLogic.getRunGame() == true) {
				GameLoop();
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void GameLoop() {
		GameLogic.createPlayers();

		/*****************
		 * CALC WHO WINS
		 * 
		 ****************/		
		if (GameLogic.getHasKnocked() == true
				&& GameLogic.getCurrentPlayer().equals(GameLogic.getPlayerThatKnocked()) && GameLogic.hasCalculated() == false) {
			
			for (Player player : GameLogic.getPlayerList()) {
				/*if (GameLogic.hasCalculated() == true) {
					//System.out.println("The winner is " + GameLogic.getWinnerName() + " with the score: " + GameLogic.getWinnerScore());
					//GameLogic.setGameState("gameOver");
					//set to after game frame
					break;
				}*/
				if(GameLogic.hasCalculated() == false) {
					GameLogic.setCurrentPlayer(player);
					//print statements used to see if game flows properly
					System.out.println("\n" + player.getPlayerName() + " final cards were: ");
					System.out.println(GameLogic.getCurrentPlayer().getCardFromHandByIndex(1));
					System.out.println(GameLogic.getCurrentPlayer().getCardFromHandByIndex(2));
					System.out.println(GameLogic.getCurrentPlayer().getCardFromHandByIndex(3));
					System.out.println("Score count: " + GameLogic.calcScore(GameLogic.getCurrentPlayer()));
					
					GameLogic.calcHighScore(GameLogic.getCurrentPlayer());
					
				}
				
			}
			GameLogic.setCalculated(true);
			System.out.println("The winner is " + GameLogic.getWinnerName() + " with the score: " + GameLogic.getWinnerScore());
			GameLogic.setGameOverFrame("GameOverFrame");
			GameLogic.getGameOverFrame().getLbWinner().setText("The winner is " + GameLogic.getWinnerName() + " with the score: " + GameLogic.getWinnerScore());
			
		} else {
			for (Player player : GameLogic.getPlayerList()) {
				GameLogic.setCurrentPlayer(player);
/////herererere
				if (GameLogic.getHasKnocked() == true && player.equals(GameLogic.getPlayerThatKnocked())) {
					break;
				}
				//GameLogic.setCurrentPlayer(player);
				GameLogic.getGameFrame().getLbPlayerTurn().setText(player.getPlayerName() + "'s Turn");

				if (player.isCpu() == true) {
					GameLogic.setGameState("cpuPlayerTurn");
					GameLogic.setBtnEnable(false);
				} else {
					GameLogic.setGameState("humanPlayerTurn");
					GameLogic.setHasPlayerFinishedTurn(false);
					if (GameLogic.isAreBtnsEnabled() == false)
						GameLogic.setBtnEnable(true);
				}

				System.out.println(GameLogic.getGameState());

				if (GameLogic.getGameState() == "cpuPlayerTurn") {
					GameLogic.getCurrentPlayer().calcHandvalues();
					GameLogic.setPlayerThinking(true);

					new Thread(() -> {
						while (GameLogic.isPlayerThinking() == true) {
							GameLogic.getGameFrame().getLbPlayerThinking()
									.setText(player.getPlayerName() + " is thinking.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							GameLogic.getGameFrame().getLbPlayerThinking()
									.setText(player.getPlayerName() + " is thinking..");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							GameLogic.getGameFrame().getLbPlayerThinking()
									.setText(player.getPlayerName() + " is thinking...");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							GameLogic.setPlayerThinking(false);
						}
					}).start();

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (GameLogic.getCurrentPlayer().getHighestSuitValue() < 10) {

						//these are for debugging purposes
						System.out.println("\n" + player.getPlayerName() + " had cards: ");
						GameLogic.peekCurrentPlayerHand();
						///////////////////////
						System.out.println(player.getPlayerName() + " < 10");
						GameLogic.setCardSelected(player.getLowestCardIndex());
						GameLogic.gameDeckPressed();
						System.out.println("\n" + player.getPlayerName() + "now has cards: ");
						GameLogic.peekCurrentPlayerHand();

					} else if (GameLogic.getCurrentPlayer().getHighestSuitValue() < 20) {

						//these are for debugging purposes
						System.out.println("\n" + player.getPlayerName() + " had cards: ");
						GameLogic.peekCurrentPlayerHand();
						///////////////////////
						System.out.println(player.getPlayerName() + " < 20");
						GameLogic.setCardSelected(player.getLowestCardIndex());
						GameLogic.gameDeckPressed();
						System.out.println("\n" + player.getPlayerName() + "now has cards: ");
						GameLogic.peekCurrentPlayerHand();
						//had to add getHasKnocked here so no other cpu can knock
						if (Math.random() < .3 && GameLogic.getHasKnocked() != true) {
							GameLogic.setPlayerHasKnocked(true);
						}
					} else if (GameLogic.getCurrentPlayer().getHighestSuitValue() < 25) {

						//these are for debugging purposes
						System.out.println("\n" + player.getPlayerName() + " had cards: ");
						GameLogic.peekCurrentPlayerHand();
						///////////////////////
						System.out.println(player.getPlayerName() + " < 25");
						GameLogic.setCardSelected(player.getLowestCardIndex());
						GameLogic.gameDeckPressed();
						System.out.println("\n" + player.getPlayerName() + "now has cards: ");
						GameLogic.peekCurrentPlayerHand();

						if (Math.random() < .4 && GameLogic.getHasKnocked() != true) {
							GameLogic.setPlayerHasKnocked(true);
						}
					} else if (GameLogic.getCurrentPlayer().getHighestSuitValue() < 31) {

						//these are for debugging purposes
						System.out.println("\n" + player.getPlayerName() + " has cards: ");
						GameLogic.peekCurrentPlayerHand();
						///////////////////////
						System.out.println(player.getPlayerName() + " < 31");
						GameLogic.setCardSelected(player.getLowestCardIndex());
						GameLogic.gameDeckPressed();
						System.out.println("\n" + player.getPlayerName() + "now has cards: ");
						GameLogic.peekCurrentPlayerHand();

						if (Math.random() < .7 && GameLogic.getHasKnocked() != true) {
							GameLogic.setPlayerHasKnocked(true);
						}
					} else if (GameLogic.getCurrentPlayer().getHighestSuitValue() == 31) {
						GameLogic.setPlayerHasKnocked(true);
					}

					GameLogic.getGameFrame().getLbPlayerThinking().setText("");

				} else if (GameLogic.getGameState() == "humanPlayerTurn") {

					while (GameLogic.isHasPlayerFinishedTurn() == false) {
						// System.out.println(hasPlayerFinishedTurn);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			//GameLogic.setGameFrame("GameOverFrame");
		}
	}

}

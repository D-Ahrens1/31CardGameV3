package game.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.logic.GameLogic;
import game.logic.Main;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnDeck;
	private JButton btnCardOne;
	private JButton btnCardTwo;
	private JButton btnCardThree;
	private JLabel lbPlayerTurn;
	private JButton btnDiscard;
	private JButton btnKnock;
	private JLabel lbPlayerThinking;
	private JButton btnStartTurn;
	private JLabel lbWinner;
	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCardOne = new JButton("");
		btnCardOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setCardSelected(1);
			}
		});
		btnCardOne.setIcon(new ImageIcon(GameFrame.class.getResource("/game/images/cardback.jpg")));
		btnCardOne.setBounds(267, 76, 113, 160);
		contentPane.add(btnCardOne);
		
		btnCardTwo = new JButton("");
		btnCardTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setCardSelected(2);
			}
		});
		btnCardTwo.setIcon(new ImageIcon(GameFrame.class.getResource("/game/images/cardback.jpg")));
		btnCardTwo.setBounds(419, 76, 113, 160);
		contentPane.add(btnCardTwo);
		
		btnCardThree = new JButton("");
		btnCardThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setCardSelected(3);
			}
		});
		btnCardThree.setIcon(new ImageIcon(GameFrame.class.getResource("/game/images/cardback.jpg")));
		btnCardThree.setBounds(571, 76, 113, 160);
		contentPane.add(btnCardThree);
		
		btnDeck = new JButton("");
		btnDeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.gameDeckPressed();
			}
		});
		btnDeck.setIcon(new ImageIcon(GameFrame.class.getResource("/game/images/cardback.jpg")));
		btnDeck.setBounds(344, 322, 113, 160);
		contentPane.add(btnDeck);
		
		btnDiscard = new JButton("");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.gameDiscardDeckPressed();
			}
		});
		btnDiscard.setIcon(new ImageIcon(GameFrame.class.getResource("/game/images/cardback.jpg")));
		btnDiscard.setBounds(504, 322, 113, 160);
		contentPane.add(btnDiscard);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.endTurnBtnPressed();
			}
		});
		btnEndTurn.setBounds(755, 459, 89, 23);
		contentPane.add(btnEndTurn);
		
		btnStartTurn = new JButton("Show Cards");
		btnStartTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.startTurnBtnPressed();
			}
		});
		
		btnStartTurn.setBounds(854, 459, 89, 23);
		contentPane.add(btnStartTurn);
		
		btnKnock = new JButton("Knock");
		btnKnock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setPlayerHasKnocked(true);
				GameLogic.endTurnBtnPressed();
			}
		});
		btnKnock.setBounds(656, 459, 89, 23);
		contentPane.add(btnKnock);
		
		lbPlayerThinking = new JLabel("");
		lbPlayerThinking.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlayerThinking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbPlayerThinking.setForeground(Color.WHITE);
		lbPlayerThinking.setBounds(267, 269, 417, 42);
		contentPane.add(lbPlayerThinking);
		
		lbPlayerTurn = new JLabel("Player Turn:");
		lbPlayerTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlayerTurn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbPlayerTurn.setForeground(Color.WHITE);
		lbPlayerTurn.setBounds(419, 11, 113, 20);
		contentPane.add(lbPlayerTurn);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameFrame.class.getResource("/game/images/GameBoard.jpg")));
		lblNewLabel.setBounds(0, 0, 960, 540);
		contentPane.add(lblNewLabel);
	
	}
	public JButton getBtnDeck() {
		return btnDeck;
	}
	public JButton getBtnCardOne() {
		return btnCardOne;
	}
	public JButton getBtnCardTwo() {
		return btnCardTwo;
	}
	public JButton getBtnCardThree() {
		return btnCardThree;
	}
	public JLabel getLbPlayerTurn() {
		return lbPlayerTurn;
	}
	public JButton getBtnDiscard() {
		return btnDiscard;
	}
	public JLabel getLbPlayerThinking() {
		return lbPlayerThinking;
	}
	public JButton getBtnStartTurn() {
		return btnStartTurn;
	}

}

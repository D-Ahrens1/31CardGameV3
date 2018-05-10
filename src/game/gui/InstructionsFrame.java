package game.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.logic.GameLogic;
import game.logic.Main;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstructionsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InstructionsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("GameFrame");
				GameLogic.startGame();
			}
		});
		btnStartGame.setBounds(860, 505, 89, 23);
		contentPane.add(btnStartGame);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("MainMenu");
			}
		});
		btnMainMenu.setBounds(761, 505, 89, 23);
		contentPane.add(btnMainMenu);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 960, 542);
		background.setIcon(new ImageIcon(InstructionsFrame.class.getResource("/game/images/Instructions.jpg")));
		contentPane.add(background);
	}

}

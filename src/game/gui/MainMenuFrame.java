package game.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.logic.GameLogic;
import game.logic.Main;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainMenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 570);
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
		btnStartGame.setBounds(363, 198, 124, 23);
		contentPane.add(btnStartGame);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setBounds(363, 300, 124, 23);
		contentPane.add(btnExitGame);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("InstructionFrame");
			}
		});
		btnInstructions.setBounds(363, 266, 124, 23);
		contentPane.add(btnInstructions);
		
		JButton btnSettings = new JButton("Game Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("SettingMenuFrame");
			}
		});
		btnSettings.setBounds(363, 232, 124, 23);
		contentPane.add(btnSettings);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1028, 540);
		label.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/game/images/background.jpg")));
		contentPane.add(label);
		
	}

}

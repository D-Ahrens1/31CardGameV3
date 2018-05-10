package game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import game.logic.GameLogic;
import game.logic.Main;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lbWinner;
	/**
	 * Create the frame.
	 */
	public GameOverFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("MainMenu");
			}
		});
		btnMainMenu.setBounds(761, 505, 89, 23);
		contentPane.add(btnMainMenu);
		
		
		lbWinner = new JLabel("");
		lbWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lbWinner.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbWinner.setForeground(Color.WHITE);
		lbWinner.setBounds(100, 269, 699, 42);
		contentPane.add(lbWinner);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 960, 542);
		background.setIcon(new ImageIcon(InstructionsFrame.class.getResource("/game/images/GameBoard.jpg")));
		contentPane.add(background);
	}
	public JLabel getLbWinner() {
		return lbWinner;
	}
}
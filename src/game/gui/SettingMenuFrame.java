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
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingMenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField playerOneNameTF;
	private JTextField playerTwoNameTF;
	private JTextField playerThreeNameTF;
	private JTextField playerFourNameTF;
	private JSpinner numberOfHumanPlayers;

	/**
	 * Create the frame.
	 */
	public SettingMenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("GameFrame");
				GameLogic.setNumberOfHumanPlayers((int)numberOfHumanPlayers.getValue());
				GameLogic.startGame();
			}
		});
		btnStartGame.setBounds(805, 499, 121, 23);
		contentPane.add(btnStartGame);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.setGameFrame("MainMenu");
			}
		});
		btnMainMenu.setBounds(10, 499, 121, 23);
		contentPane.add(btnMainMenu);
		
		JLabel lblNewLabel = new JLabel("Player 1 Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(308, 114, 120, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblPlayerName = new JLabel("Player 2 Name:");
		lblPlayerName.setForeground(Color.WHITE);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerName.setBounds(308, 147, 120, 22);
		contentPane.add(lblPlayerName);
		
		JLabel lblPlayerName_1 = new JLabel("Player 3 Name:");
		lblPlayerName_1.setForeground(Color.WHITE);
		lblPlayerName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerName_1.setBounds(308, 180, 120, 22);
		contentPane.add(lblPlayerName_1);
		
		JLabel lblPlayerName_2 = new JLabel("Player 4 Name:");
		lblPlayerName_2.setForeground(Color.WHITE);
		lblPlayerName_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerName_2.setBounds(308, 213, 120, 22);
		contentPane.add(lblPlayerName_2);
		
		playerOneNameTF = new JTextField();
		playerOneNameTF.setText("John");
		playerOneNameTF.setBounds(438, 118, 175, 20);
		contentPane.add(playerOneNameTF);
		playerOneNameTF.setColumns(10);
		
		playerTwoNameTF = new JTextField();
		playerTwoNameTF.setText("Tom");
		playerTwoNameTF.setColumns(10);
		playerTwoNameTF.setBounds(438, 151, 175, 20);
		contentPane.add(playerTwoNameTF);
		
		playerThreeNameTF = new JTextField();
		playerThreeNameTF.setText("Ron");
		playerThreeNameTF.setColumns(10);
		playerThreeNameTF.setBounds(438, 184, 175, 20);
		contentPane.add(playerThreeNameTF);
		
		playerFourNameTF = new JTextField();
		playerFourNameTF.setText("Patty");
		playerFourNameTF.setColumns(10);
		playerFourNameTF.setBounds(438, 217, 175, 20);
		contentPane.add(playerFourNameTF);
		
		JLabel lblNumberOfHuman = new JLabel("Number Of Human Players:");
		lblNumberOfHuman.setForeground(Color.WHITE);
		lblNumberOfHuman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberOfHuman.setBounds(308, 262, 216, 22);
		contentPane.add(lblNumberOfHuman);
		
		numberOfHumanPlayers = new JSpinner();
		numberOfHumanPlayers.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		numberOfHumanPlayers.setBounds(545, 266, 31, 20);
		contentPane.add(numberOfHumanPlayers);
		
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(SettingMenuFrame.class.getResource("/game/images/GameBoard.jpg")));
		BackGround.setBounds(0, 0, 960, 540);
		contentPane.add(BackGround);
	}
	public String getPlayerName(int playerNumber) {
	 	switch(playerNumber){
			case 1:
				return playerOneNameTF.getText();
			case 2:
				return playerTwoNameTF.getText();
			case 3:
				return playerThreeNameTF.getText();
			case 4:
				return playerFourNameTF.getText();
			default:
				break;
		}
		return "ERROR COULD NOT GET NAME";
	}

}

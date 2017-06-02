package Finalp;

import javax.swing.*;

import Finalp.World;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameOver extends JPanel {
	private Font titleFont;
	private Font gameOverFont;
	private Font winnerFont;
	private JLabel title;
	private JLabel subtitle;
	private JLabel winnerText;
	private BufferedImage info;
	private int buttonW;
	private int buttonH;
	private int spacing;
	private JButton TryAgainButton;
	private JButton MainMenuButton;
	private JButton quitButton;
	private String winner;
	
	World w;
	
	public GameOver(){
		GameScreen g = new GameScreen();
		setLayout(null);
		
		info = new BufferedImage(w.getX(), 200, BufferedImage.TYPE_INT_RGB);
		ClassLoader clder = this.getClass().getClassLoader();
		ImageIcon pic = new ImageIcon(info);
		
		titleFont = new Font("Bebas Neue Regular", Font.BOLD, 50);
		gameOverFont = new Font("Bebas Neue Regular", Font.PLAIN, 70);
		winnerFont = new Font("Bebas Neue Regular", Font.ITALIC, 22);

		buttonW = 150;
		buttonH = 60;
		spacing = 25;
				
		
		title = new JLabel("S.T.A.B.", SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setSize(g.returnWidth(), 100);
		title.setLocation(0, 0);
		
		subtitle = new JLabel("Game Over!", SwingConstants.CENTER);
		subtitle.setFont(gameOverFont);
		subtitle.setForeground(Color.red);
		subtitle.setSize(g.returnWidth(), 50);
		subtitle.setLocation(0, subtitle.getHeight() + 50);
		
		winnerText = new JLabel("The Winner is " + w.getWinner(), SwingConstants.CENTER);
		winnerText.setFont(winnerFont);
		winnerText.setSize(g.returnWidth(), 200);
		winnerText.setLocation(0,  150);
		
		
		MainMenuButton = new JButton("Main Menu");
		MainMenuButton.setBounds(25 , 500, buttonW, buttonH);
		
		TryAgainButton = new JButton("Try Again");
		TryAgainButton.setBounds(225, 500, buttonW, buttonH);
		
		quitButton = new JButton("Quit");
		quitButton.setBounds(425, 500, buttonW, buttonH);
		
		add(title);
		add(subtitle);
		add(winnerText);
		add(MainMenuButton);
		add(TryAgainButton);
		add(quitButton);
		
		MainMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameScreen ref=new GameScreen();
				MainMenu menu = new MainMenu();
				ref.addPanel(menu);
				try {
					ref.initJFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		TryAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameScreen ref=new GameScreen();
				World game = new World();
				ref.addPanel(game);
				try {
					ref.initJFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
package Finalp;

import javax.swing.*;

import Finalp.World;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JPanel {
	private Font titleFont;
	private Font subFont;
	private Font inFont;
	private JLabel title;
	private JLabel subtitle;
	private JLabel instructions;
	private int buttonW;
	private int buttonH;
	private int spacing;
	private JButton MainMenuButton;
	private JButton playButton;
	private JButton quitButton;
	World w;
	
	public Instructions(){
		GameScreen g = new GameScreen();
		setLayout(null);
		titleFont = new Font("Bebas Neue Regular", Font.BOLD, 100);
		subFont = new Font("Bebas Neue Regular", Font.PLAIN, 30);
		inFont = new Font("Bebas Neue Regular", Font.ITALIC, 22);

		buttonW = 150;
		buttonH = 60;
		spacing = 90;
		
		
		title = new JLabel("S.T.A.B.", SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setSize(g.returnWidth(), 100);
		title.setLocation(0, 0);
		
		subtitle = new JLabel("Instructions", SwingConstants.CENTER);
		subtitle.setFont(subFont);
		subtitle.setSize(g.returnWidth(), 50);
		subtitle.setLocation(0, subtitle.getHeight() + 50);
		
		instructions = new JLabel("", SwingConstants.CENTER);
		instructions.setFont(inFont);
		instructions.setSize(g.returnWidth(), 50);
		instructions.setLocation(0, instructions.getHeight() * 2 + 50);
		
		
		MainMenuButton = new JButton("Main Menu");
		MainMenuButton.setBounds(50 , 150, buttonW, buttonH);
		
		playButton = new JButton("Play");
		playButton.setBounds(300, 150, buttonW, buttonH);
		
		quitButton = new JButton("Quit");
		quitButton.setBounds(500, 150, buttonW, buttonH);
		
		add(title);
		add(subtitle);
		add(instructions);
		add(MainMenuButton);
		add(playButton);
		add(quitButton);
		
		MainMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameScreen ref=new GameScreen();
				MainMenu menu = new MainMenu();
				ref.addPanel(menu);
				ref.initJFrame();
			}
		});
		
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameScreen ref=new GameScreen();
				World game = new World();
				ref.addPanel(game);
				ref.initJFrame();
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
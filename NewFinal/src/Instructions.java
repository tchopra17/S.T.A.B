package Finalp;

import javax.swing.*;

import Finalp.World;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	private String  in, ins,inst,instr,instru,instruc,instruct;
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
		
		in = "- Move player one using the arrow keys.\n"
				+ "- Move player two using the WASD keys.\n"
				+ "- Use the left and right keys to change \nthe facing of the player then use the up \nkey to move the player forward."
				+ "- You may pause the game at any time and \nhealth is displayed in the top corners.";
				
		
		title = new JLabel("S.T.A.B.", SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setSize(g.returnWidth(), 100);
		title.setLocation(0, 0);
		
		subtitle = new JLabel("instructions", SwingConstants.CENTER);
		subtitle.setFont(subFont);
		subtitle.setSize(g.returnWidth(), 50);
		subtitle.setLocation(0, subtitle.getHeight() + 50);
		
		instructions = new JLabel("<html>- Move player one using the arrow keys.<BR>"
				+ "- Move player two using the WASD keys.<BR>- Use the left and right keys to change <BR>"
				+ "the facing of the player then use the up <BR>key to move the player forward.<BR>"
				+ "- You may pause the game at any time and <BR>health is displayed in the top corners.</html>"
, SwingConstants.CENTER);
		instructions.setFont(inFont);
		instructions.setSize(g.returnWidth(), 200);
		instructions.setLocation(0,  150);
		
		
		MainMenuButton = new JButton("Main Menu");
		MainMenuButton.setBounds(145 , 500, buttonW, buttonH);
		
		playButton = new JButton("Play");
		playButton.setBounds(395, 500, buttonW, buttonH);
		
		quitButton = new JButton("Quit");
		quitButton.setBounds(645, 500, buttonW, buttonH);
		
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
				try {
					ref.initJFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		playButton.addActionListener(new ActionListener() {
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
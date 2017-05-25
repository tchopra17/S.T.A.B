package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends GuiPanel{

	private Font titleFont = new Font("Bebas Neue Regular", Font.BOLD, 30);
	private Font subFont = new Font("Bebas Neue Regular", Font.PLAIN, 22);
	private String title = "S.T.A.B.";
	private String subtitle = "Instructions";
	private int buttonW = 220;
	private int buttonH = 60;
	private int spacing = 45;
	
	public Instructions() {
		super();

		GuiButton playButton = new GuiButton(GameScreen.SCREEN_WIDTH / 2 - buttonW - spacing, 500, buttonW, buttonH);
		GuiButton mainMenuButton = new GuiButton(GameScreen.SCREEN_WIDTH / 2 + buttonW + spacing,
				500, buttonW, buttonH);

		playButton.setText("Play");
		mainMenuButton.setText("Main Menu");
		
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getinstance().setCurrentPanel("Play");
				
			}
		});
		mainMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getinstance().setCurrentPanel("MainMenu");
			}
		});
		
		add(playButton);
		add(mainMenuButton);
		
	}
	
	
	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString(title, GameScreen.SCREEN_WIDTH / 2 -185 , 150);
		g.setFont(subFont);
		g.drawString(subtitle, GameScreen.SCREEN_WIDTH / 2 -140, 180);
	}

}

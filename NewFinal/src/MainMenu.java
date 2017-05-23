package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends GuiPanel {

	private Font titleFont = new Font("Bebas Neue Regular", Font.BOLD, 100);
	private Font subFont = new Font("Bebas Neue Regular", Font.PLAIN, 28);
	private Font authorFont = new Font("Bebas Neue Regular", Font.PLAIN, 22);
	private String title = "S.T.A.B.";
	private String subtitle = "Sharp Tips Action Battle";
	private String authors = "J. Bao, T. Chopra, R. Miller, K. Wang";
	private int buttonW = 220;
	private int buttonH = 60;
	private int spacing = 90;
	private int SCREEN_WIDTH = 600;
	
	public MainMenu() {
		super();

		GuiButton playButton = new GuiButton(GameScreen.SCREEN_WIDTH / 2 - buttonW / 2 , 220, buttonW, buttonH);
		GuiButton instructionsButton = new GuiButton(GameScreen.SCREEN_WIDTH / 2 - buttonW / 2 ,
				playButton.getY() + spacing, buttonW, buttonH);
		GuiButton quitButton = new GuiButton(GameScreen.SCREEN_WIDTH / 2 - buttonW / 2 ,
				instructionsButton.getY() + spacing, buttonW, buttonH);

		playButton.setText("Play");
		instructionsButton.setText("Instuctions");
		quitButton.setText("Quit");

		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getinstance().setCurrentPanel("Play");
			}
		});
		instructionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getinstance().setCurrentPanel("Instructions");
			}
		});
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(playButton);
		add(instructionsButton);
		add(quitButton);

	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString(title, GameScreen.SCREEN_WIDTH / 2 -185 , 150);
		g.setFont(subFont);
		g.drawString(subtitle, GameScreen.SCREEN_WIDTH / 2 -140, 180);
		g.setFont(authorFont);
		g.drawString(authors, GameScreen.SCREEN_WIDTH / 2 -180, 200);
	}
}
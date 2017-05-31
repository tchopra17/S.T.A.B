import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
	private Font titleFont;
	private Font subFont;
	private Font authorFont;
	private JLabel title;
	private JLabel subtitle;
	private JLabel authors;
	private int buttonW;
	private int buttonH;
	private int spacing;
	private JButton playButton;
	private JButton instructionButton;
	private JButton quitButton;
	World w;
	
	public MainMenu(){
		GameScreen g = new GameScreen();
		setLayout(null);
		titleFont = new Font("Bebas Neue Regular", Font.BOLD, 100);
		subFont = new Font("Bebas Neue Regular", Font.PLAIN, 28);
		authorFont = new Font("Bebas Neue Regular", Font.PLAIN, 22);

		buttonW = 220;
		buttonH = 60;
		spacing = 90;
		
		
		title = new JLabel("S.T.A.B", SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setSize(g.returnWidth(), 100);
		title.setLocation(0, 0);
		
		subtitle = new JLabel("Sharp Tips Action Battle", SwingConstants.CENTER);
		subtitle.setFont(subFont);
		subtitle.setSize(g.returnWidth(), 50);
		subtitle.setLocation(0, subtitle.getHeight() + 50);
		
		authors = new JLabel("J. Bao, T. Chopra, R. Miller, K. Wang", SwingConstants.CENTER);
		authors.setFont(authorFont);
		authors.setSize(g.returnWidth(), 50);
		authors.setLocation(0, authors.getHeight() * 2 + 50);
		
		
		playButton = new JButton("Play");
		playButton.setBounds(g.returnWidth() / 2 - buttonW / 2 , 220, buttonW, buttonH);
		
		instructionButton = new JButton("Instructions");
		instructionButton.setBounds(g.returnWidth() / 2 - buttonW / 2 ,
				playButton.getY() + spacing, buttonW, buttonH);
		
		quitButton = new JButton("Quit");
		quitButton.setBounds(g.returnWidth() / 2 - buttonW / 2,
				instructionButton.getY() + spacing, buttonW, buttonH);
		
		add(title);
		add(subtitle);
		add(authors);
		add(playButton);
		add(instructionButton);
		add(quitButton);
		
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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

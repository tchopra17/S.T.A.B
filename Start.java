package project;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args){
		
		GameScreen screen = new GameScreen();
		
		JFrame frame = new JFrame("S.T.A.B.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(screen);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		screen.start();
		
		screen.render();
		screen.update();
	}
}

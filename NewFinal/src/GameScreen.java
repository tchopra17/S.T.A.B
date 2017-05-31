

import javax.swing.*;

public class GameScreen extends JFrame {
	JPanel ref;
	final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 700;

	public GameScreen() {
		ref = null;
	}

	public void initJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREEN_HEIGHT, SCREEN_WIDTH);
		setVisible(true);
	}

	public void addPanel(JPanel temp) {
		ref = temp;
		add(ref);
		repaint();
		revalidate();
	}

	public void removePanel() {
		remove(ref);
		repaint();
		revalidate();
	}

	public int returnWidth() {
		return SCREEN_WIDTH;
	}

	public int returnHeight() {
		return SCREEN_HEIGHT;
	}

}
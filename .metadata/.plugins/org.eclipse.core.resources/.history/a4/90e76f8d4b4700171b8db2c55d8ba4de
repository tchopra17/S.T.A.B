

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class GameScreen extends JFrame {
	JPanel ref;
	final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 700;
	
	public GameScreen() {
		ref = null;
	}

	public void initJFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREEN_HEIGHT, SCREEN_WIDTH);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		setLayout(null);
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
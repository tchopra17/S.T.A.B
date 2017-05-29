import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameScreen extends JFrame{
	JPanel ref;
	final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
	
	public GameScreen(){
		ref=null;
	}
	public void initJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
	}
	
	public void addPanel(JPanel temp){
		ref=temp;
		add(ref);
		repaint();
	    revalidate();
	}
	public void removePanel(){
		remove(ref);
		repaint();
	    revalidate();
	}
	
	public int returnWidth(){
		return SCREEN_WIDTH;
	}
}
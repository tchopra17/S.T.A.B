import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class World extends JPanel implements KeyListener, ActionListener {
	Timer t = new Timer(5, this);
	private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
	static double x = 0;
	static double y = 0;
	double velx = 0;
	double vely = 0;
	static int randno = (int) (5 * Math.random() + 1);
	boolean didGameLoad;
	private GameScreen ref;

	Player p1 = new Player(x, y, 30, 30);
	Obstacle o1 = new Obstacle(x, y, (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
	Obstacle o2 = new Obstacle(x, y, (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
	Obstacle o3 = new Obstacle(x, y, (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
	Obstacle o4 = new Obstacle(x, y, (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));

	public World(GameScreen temp) {
		ref = temp;
		t.start();
		didGameLoad = true;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
	}

	
	public void setScreen(GameScreen temp){
		ref = temp;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		p1.setX(x);
		p1.setY(y);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(p1.returnPlayer());

		if (didGameLoad == true) {
			o1.setX((int) (500 * Math.random() + 50));
			o1.setY((int) (500 * Math.random() + 50));
			Graphics2D g3 = (Graphics2D) g;
			g3.fill(o1.returnPlayer());

			o2.setX((int) (500 * Math.random() + 50));
			o2.setY((int) (500 * Math.random() + 50));
			Graphics2D g4 = (Graphics2D) g;
			g4.fill(o2.returnPlayer());

			o3.setX((int) (500 * Math.random() + 50));
			o3.setY((int) (500 * Math.random() + 50));
			Graphics2D g5 = (Graphics2D) g;
			g5.fill(o3.returnPlayer());

			o4.setX((int) (500 * Math.random() + 50));
			o4.setY((int) (500 * Math.random() + 50));
			Graphics2D g6 = (Graphics2D) g;
			g6.fill(o4.returnPlayer());
			didGameLoad = false;
		}

	}
	
	public void upPressed() {
		vely = -0.5;
		velx = 0;
	}

	public void downPressed() {
		vely = 0.5;
		velx = 0;
	}

	public void rightPressed() {
		vely = 0;
		velx = 0.5;
	}

	public void leftPressed() {
		vely = 0;
		velx = -0.5;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			upPressed();
		}
		if (key == KeyEvent.VK_DOWN) {
			downPressed();
		}
		if (key == KeyEvent.VK_LEFT) {
			leftPressed();
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightPressed();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		x = p1.getX() + velx;
		y = p1.getY() + vely;
	}
}

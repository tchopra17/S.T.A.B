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
	static double x = 0;
	static double y = 0;
	double velx = 0;
	double vely = 0;

	Player p1 = new Player(x, y, 30, 30, 0);
	Obstacle o1 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
	Obstacle o2 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
	Obstacle o3 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
	Obstacle o4 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));

	public World(GameScreen temp) {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(p1.returnPlayer());
		
		g2.fill(o1.returnPlayer());
		g2.fill(o2.returnPlayer());
		g2.fill(o3.returnPlayer());
		g2.fill(o4.returnPlayer());
	}
	
	public void upPressed(){
		p1.accelerate();
	}
	public void downPressed(){
		p1.deaccelerate();
	}
	public void rightPressed(){
		p1.turnRight();
	}
	public void leftPressed(){
		p1.turnLeft();
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
		p1.setX(p1.getX() + p1.getVelocity()*Math.acos(p1.getDirection()*(Math.PI/180.)));
		p1.setY(p1.getY() + p1.getVelocity()*Math.asin(p1.getDirection()*(Math.PI/180.)));
	}
}
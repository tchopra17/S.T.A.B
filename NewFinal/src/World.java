import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;

public class World extends JPanel implements KeyListener, ActionListener {
	Timer t;
	Player p1;
	Player p2;
	Obstacle o1;
	Obstacle o2;
	Obstacle o3;
	Obstacle o4;
	Tip tip;
	Tip tip2;

	public World() {
		t = new Timer(1, this);
		t.start();
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		
		p1 = new Player(0, 0, 30, 30, 0);
		p2 = new Player(200, 200, 30, 30, 0);
		
		o1 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
		o2 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
		o3 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
		o4 = new Obstacle((int) (500 * Math.random() + 50), (int) (500 * Math.random() + 50), (int)(60 * Math.random() + 20), (int)(60 * Math.random() + 20));
		
		tip = new Tip(p1.getLeft() + p1.getWidth(), p1.getTop() + ((p1.getHeight() / 2)-10), 70, 10, 0);
		tip2 = new Tip(p2.getLeft() + p2.getWidth(), p2.getTop() + ((p2.getHeight() / 2)-10), 70, 10, 0);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		
		g2.rotate(p1.getDirection()*Math.PI/180,p1.getLeft()+p1.getWidth()/2,p1.getTop()+p1.getHeight()/2);
		g2.fill(p1.returnPlayer());
		g2.fill(tip.returnPlayer());
		g2.setTransform(old);
		
		g2.rotate(p2.getDirection()*Math.PI/180,p2.getLeft()+p2.getWidth()/2,p2.getTop()+p2.getHeight()/2);
		g2.fill(p2.returnPlayer());
		g2.fill(tip2.returnPlayer());
		g2.setTransform(old);
		
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
		System.out.println(p1.getDirection());
	}
	public void leftPressed(){
		p1.turnLeft();
		System.out.println(p1.getDirection());
	}
	public void wPressed(){
		p2.accelerate();
	}
	public void sPressed(){
		p2.deaccelerate();
	}
	public void dPressed(){
		p2.turnRight();
	}
	public void aPressed(){
		p2.turnLeft();
	}
	public void p1NotPressed(){
		p1.stop();
	}
	public void p2NotPressed(){
		p2.stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
			upPressed();
		if (key == KeyEvent.VK_DOWN)
			downPressed();
		if (key == KeyEvent.VK_LEFT)
			leftPressed();
		if (key == KeyEvent.VK_RIGHT)
			rightPressed();
		if (key == KeyEvent.VK_W)
			wPressed();
		if (key == KeyEvent.VK_S)
			sPressed();
		if (key == KeyEvent.VK_A)
			aPressed();
		if (key == KeyEvent.VK_D)
			dPressed();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key=e.getKeyCode();
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_DOWN||key == KeyEvent.VK_LEFT||key == KeyEvent.VK_RIGHT)
			p1NotPressed();
		else if(key == KeyEvent.VK_W||key == KeyEvent.VK_S||key == KeyEvent.VK_A||key == KeyEvent.VK_D)
			p2NotPressed();
	}
	public void detectCollision(Player p, Obstacle o) {
		if ((p.getLeft() >= o.getLeft() && p.getLeft() <= o.getRight()) || p.getRight() >= o.getLeft() && p.getRight() <= o.getRight()){
			if ((p.getTop() >= o.getTop() && p.getTop() <= o.getBottom()) || p.getBottom() >= o.getTop() && p.getBottom() <= o.getBottom()){
				double direction = p.getDirection();
				if (direction > 270 && direction < 360){
					System.out.println("4th quad");
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		detectCollision(p1, o1);
		detectCollision(p1, o2);
		detectCollision(p1, o3);
		detectCollision(p1, o4);
		detectCollision(p2, o1);
		detectCollision(p2, o2);
		detectCollision(p2, o3);
		detectCollision(p2, o4);
		
		repaint();
		
		p1.setX(p1.getLeft() + p1.getVelocity() * Math.cos(p1.getDirection() * (Math.PI/180.)));
		p1.setY(p1.getTop() + p1.getVelocity() * Math.sin(p1.getDirection() * (Math.PI/180.)));
		p2.setX(p2.getLeft() + p2.getVelocity() * Math.cos(p2.getDirection() * (Math.PI/180.)));
		p2.setY(p2.getTop() + p2.getVelocity() * Math.sin(p2.getDirection() * (Math.PI/180.)));
		
		tip.setX(p1.getLeft());
		tip.setY(p1.getTop());
		tip2.setX(p2.getLeft());
		tip2.setY(p2.getTop());
	}
}
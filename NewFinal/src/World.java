import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import java.util.ArrayList;

import javax.swing.*;

public class World extends JPanel implements KeyListener, ActionListener {
	Timer t;

	Player p1;
	Player p2;

	Obstacle o1;
	Obstacle o2;

	// borders
	Obstacle b1;
	Obstacle b2;
	Obstacle b3;
	Obstacle b4;

	GameScreen g;

	JLabel lives;
	JLabel lives2;

	ArrayList<Obstacle> oList; // Obstacle List
	ArrayList<Obstacle> bList; // Border List

	boolean forward1=false, left1=false, right1=false, back1=false, forward2, left2, right2, back2, didhit = false;

	Tip tip;
	Tip tip2;

	double w;
	double h;
	int health;
	int health2;
	int count;

	public World() {

		g = new GameScreen();

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);

		w = g.returnWidth();
		h = g.returnHeight();

		p1 = new Player(50, 50, 30, 30, 0, 5, Color.BLUE);
		p2 = new Player(w - 150, h - 150, 30, 30, 180, 5, Color.RED);

		b1 = new Obstacle(0, 0, 20, w);
		b2 = new Obstacle(0, h - 100, 20, w + 20);
		b3 = new Obstacle(0, 0, h - 100, 20);
		b4 = new Obstacle(w, 0, h - 100, 20);

		oList = new ArrayList<Obstacle>();
		bList = new ArrayList<Obstacle>();

		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		bList.add(b4);
		
		count = 0;

		while (oList.size() < 4) {
			o1 = new Obstacle((int) ((w - 260) * Math.random() + 70), (int) ((h - 360) * Math.random() + 70),
					(int) (60 * Math.random() + 60), (int) (60 * Math.random() + 60));
			oList.add(o1);
		}

		tip = new Tip(p1.getLeft() + p1.getWidth(), p1.getTop() + ((p1.getHeight() / 2) - 10), 3, 70, 0);
		tip2 = new Tip(p2.getLeft() + p2.getWidth(), p2.getTop() + ((p2.getHeight() / 2) - 10), 3, 70, 0);

		setLayout(null);

		health = 5;
		health2 = 5;
		
		lives = new JLabel("Player 1 Lives: " + health);
		lives.setSize(200, 100);
		lives.setLocation(0, 700);
		lives2 = new JLabel("Player 2 Lives: " + health);
		lives2.setSize(200, 100);
		lives2.setLocation(1000, 700);
		
		add(lives);
		add(lives2);

		t = new Timer(5, this);
		t.start();
		
	}

	// Draws World
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		
		g2.setColor(p1.getColor());
		// Draws Player 1
		g2.rotate(p1.getDirection() * Math.PI / 180, p1.getLeft() + p1.getWidth() / 2,
				p1.getTop() + p1.getHeight() / 2);
		g2.fill(p1.returnPlayer());
		g2.fill(tip.returnPlayer());
		g2.setTransform(old);
		
		g2.setColor(p2.getColor());
		// Draws Player 2
		g2.rotate(p2.getDirection() * Math.PI / 180, p2.getLeft() + p2.getWidth() / 2,
				p2.getTop() + p2.getHeight() / 2);
		g2.fill(p2.returnPlayer());
		g2.fill(tip2.returnPlayer());
		g2.setTransform(old);
		g2.setColor(Color.BLACK);
		// Draws Obstacles
		for (Obstacle o : oList) {
			g2.fill(o.returnPlayer());
		}

		g2.fill(b1.returnPlayer());
		g2.fill(b2.returnPlayer());
		g2.fill(b3.returnPlayer());
		g2.fill(b4.returnPlayer());

	}

	// Button methods
	public void upPressed() {
		p1.accelerate();
	}

	public void downPressed() {
		p1.deaccelerate();
	}

	public void rightPressed() {
		p1.turnRight();
	}

	public void leftPressed() {
		p1.turnLeft();
	}

	public void wPressed() {
		p2.accelerate();
	}

	public void sPressed() {
		p2.deaccelerate();
	}

	public void dPressed() {
		p2.turnRight();
	}

	public void aPressed() {
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
			int key=e.getKeyCode();
			if (key == KeyEvent.VK_UP)
				forward1=true;
			if (key == KeyEvent.VK_DOWN)
				back1=true;
			if (key == KeyEvent.VK_LEFT)
				left1=true;
			if (key == KeyEvent.VK_RIGHT)
				right1=true;
			if (key == KeyEvent.VK_W)
				forward2=true;
			if (key == KeyEvent.VK_S)
				back2=true;
			if (key == KeyEvent.VK_A)
				left2=true;
			if (key == KeyEvent.VK_D)
				right2=true;
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key=e.getKeyCode();
		if (key == KeyEvent.VK_UP)
			forward1=false;
		if (key == KeyEvent.VK_DOWN)
			back1=false;
		if (key == KeyEvent.VK_LEFT)
			left1=false;
		if (key == KeyEvent.VK_RIGHT)
			right1=false;
		if (key == KeyEvent.VK_W)
			forward2=false;
		if (key == KeyEvent.VK_S)
			back2=false;
		if (key == KeyEvent.VK_A)
			left2=false;
		if (key == KeyEvent.VK_D)
			right2=false;
	}
	
	public void move(){
		if (!forward1&&!back1&&!left1&&!right1)
			p1NotPressed();
		if (!forward2&&!back2&&!left2&&!right2)
			p2NotPressed();
		if (forward1)
			upPressed();
		if (back1)
			downPressed();
		if (left1)
			leftPressed();
		if (right1)
			rightPressed();
		if (forward2)
			wPressed();
		if (forward2&&p2.getVelocity()>1)
			wPressed();
		if (back2)
			sPressed();
		if (left2)
			aPressed();
		if (right2)
			dPressed();
		
		p1.setX(p1.getLeft() + p1.getVelocity() * Math.cos(p1.getDirection() * (Math.PI / 180.)));
		p1.setY(p1.getTop() + p1.getVelocity() * Math.sin(p1.getDirection() * (Math.PI / 180.)));
		p2.setX(p2.getLeft() + p2.getVelocity() * Math.cos(p2.getDirection() * (Math.PI / 180.)));
		p2.setY(p2.getTop() + p2.getVelocity() * Math.sin(p2.getDirection() * (Math.PI / 180.)));

		tip.setPosition(p1.getLeft(), p1.getTop() + p1.getHeight()/2 - tip.getWidth()/2);
		tip2.setPosition(p2.getLeft(), p2.getTop() + p2.getHeight()/2 - tip.getWidth()/2);
	}

	// Collision Detection
	public void detectCollision(Player p, Obstacle o) {
		double direction = p.getDirection();

		if (p.returnPlayer().intersects(o.returnPlayer())) {
			if (p.getTop() >= (o.getTop() - (o.getHeight() / 2))) {
				p.setDirection(270 + (90 - direction));
			}
			if (p.getLeft() < o.getLeft()) {
				p.setDirection(0 + (180 - direction));
			}
			if (p.getRight() > o.getRight()) {
				p.setDirection(180 + (0 - direction));
			}
			if (p.getTop() <= (o.getTop() + (o.getHeight() / 2))) {
				p.setDirection(90 + (270 - direction));
			}
		}
	}

	public void detectHit1(Player p, Tip t) {
		if (p.returnPlayer().intersects(t.returnPlayer())) {
			if (health > 0) {
				health--;
				p.setDirection(p.getDirection() + 180);
				lives.setText("Player 1 Lives: " + health);
				didhit = true;
			}
		}
	}
	public void detectHit2(Player p, Tip t) {
		if (p.returnPlayer().intersects(t.returnPlayer())) {
			if (health2 > 0) {
				health2--;
				p.setDirection(p.getDirection() + 180);
				lives2.setText("Player 2 Lives: " + health2);
				didhit = true;
			}
		}
	}

	// Called every time timer fires
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for (Obstacle o : oList)
			detectCollision(p1, o);
		for (Obstacle o : oList)
			detectCollision(p2, o);
		for (Obstacle b : bList)
			detectCollision(p2, b);
		for (Obstacle b : bList)
			detectCollision(p1, b);
		
		if (didhit == false){
			detectHit1(p1, tip2);
			detectHit2(p2, tip);
		} else {
			count++;
		}
		
		if (count == 30){
			count = 0;
			didhit = false;
		}
		repaint();
		
		move();
	}
}
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class World extends JFrame implements KeyListener, ActionListener{
	Timer t;
	Player p1;
	private GameScreen ref;
	private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
	
	public World(GameScreen temp){
		ref=temp;
		t = new Timer(1, this);
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		p1 = new Player(0, 0, 50, 50, 0);
	}
	public void initJFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(p1.returnPlayer());
	}

	public void setScreen(GameScreen temp){
		ref=temp;
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
		
		if (key == KeyEvent.VK_UP){
			upPressed();
		}
		if (key == KeyEvent.VK_DOWN){
			downPressed();
		}
		if (key == KeyEvent.VK_LEFT){
			leftPressed();
		}
		if (key == KeyEvent.VK_RIGHT){
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
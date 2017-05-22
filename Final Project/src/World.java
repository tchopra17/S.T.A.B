import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class World extends JFrame implements KeyListener, ActionListener{
	Timer t = new Timer(5, this);
	private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
	double x = 0, y = 0 ,velx = 0, vely = 0;
	Player p1 = new Player(x, y, 50, 50, 0);
	private GameScreen ref;
	
	public World(GameScreen temp){
		ref=temp;
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
	}
	public void initJFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		p1.setX(x);
		p1.setY(y);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(p1.returnPlayer());
	}

	public void setScreen(GameScreen temp){
		ref=temp;
	}
	
	public void upPressed(){
		vely = -0.5;
		velx = 0;
	}
	public void downPressed(){
		vely = 0.5;
		velx = 0;
	}
	public void rightPressed(){
		vely = 0;
		velx = 0.5;
	}
	public void leftPressed(){
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
		x = p1.getX() + velx;
		y = p1.getY() + vely;
	}
}
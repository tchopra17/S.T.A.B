package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class GameScreen extends JPanel implements MouseListener, MouseMotionListener{
	private World ref;
	private boolean running;
	private Thread game;
	private GuiScreen screen;
	public static final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 600;
	private BufferedImage image = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
			
	public GameScreen(){
		ref = null;
		setFocusable(true);
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		addMouseListener(this);
		addMouseMotionListener(this);
		
		screen = GuiScreen.getinstance();
		screen.add("Menu",new MainMenu());
		screen.setCurrentPanel("Menu");
	}
	
	public void update(){
		screen.update();
	}
	

	public void render(){
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, SCREEN_WIDTH,  SCREEN_HEIGHT);
		screen.render(g);
		g.dispose();
		
		Graphics2D g2d = (Graphics2D)getGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
	}

	void setWorld(World temp){
		ref=temp;
		add(ref);
	}
	
	public void start(){
		if(running){
			return;
		}
		running = true;
		game = new Thread("game");
		game.start();
	}
	
	public void stop(){
		if(!running){
			return;
		}
		running = false;
		System.exit(0);
	}
	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		screen.mouseDragged(e);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		screen.mouseMoved(e);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		screen.mousePressed(e);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		screen.mouseReleased(e);
		
	}
}
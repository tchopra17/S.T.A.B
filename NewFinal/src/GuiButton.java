package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;
import java.util.ArrayList;

public class GuiButton {

	private State currentState = State.RELEASED;
	private Rectangle clickBox;
	private ArrayList<ActionListener> actionListeners;
	private String text = "";
			
	private Color r;
	private Color h;
	private Color p;
	private Font font = new Font("Bebas Neue Regular", Font.BOLD, 22);
	
	
	public GuiButton(int x, int y, int width, int height){
		clickBox = new Rectangle (x, y, width, height);
		actionListeners = new ArrayList<ActionListener>();
		r = new Color(173,177, 179);
		h = new Color(150, 156, 158);
		p = new Color(111, 116,117);
	}
	
	public void update(){}
	
	public void render (Graphics2D g){
		if(currentState == State.RELEASED){
			g.setColor(r);
			g.fill(clickBox);
		}
		else if(currentState == State.HOVER){
			g.setColor(h);
			g.fill(clickBox);
		}
		else{
			g.setColor(p);
			g.fill(clickBox);
		}
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString(text, clickBox.x + clickBox.width / 2 - 50, clickBox.y + clickBox.height / 2);
	}
	
	public void addActionListener(ActionListener listener){
		actionListeners.add(listener);
	}
	
	public void mousePressed(MouseEvent e){
		if (clickBox.contains(e.getPoint())){
			currentState = State.PRESSED;
		}
	}

public void mouseReleased(MouseEvent e){
	if (clickBox.contains(e.getPoint())){
		for(ActionListener al : actionListeners){
			al.actionPerformed(null);
		}
	}
		currentState = State.RELEASED;
}
	
public void mouseDragged(MouseEvent e){
	if (clickBox.contains(e.getPoint())){
		currentState = State.PRESSED;
	}
	else{
		currentState = State.RELEASED;
	}
}

public void mouseMoved(MouseEvent e){
	if (clickBox.contains(e.getPoint())){
		currentState = State.HOVER;
	}
	else{
		currentState = State.RELEASED;
	}

}

public int getX(){
	return clickBox.x;
}

public int getY(){
	return clickBox.y;
}

public int getWidth(){
	return clickBox.width;
}

public int getHeight(){
	return clickBox.height;
}

public void setText(String text){
	this.text = text;
}
private enum State{
		RELEASED,
		HOVER,
		PRESSED
	}
	
	
}
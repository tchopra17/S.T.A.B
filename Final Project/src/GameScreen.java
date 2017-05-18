import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameScreen {
	World ref;
	
	public GameScreen(){
		ref=null;
	}
	
	public void setWorld(World temp){
		ref=temp;
	}
}
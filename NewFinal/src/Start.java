package Finalp;

import javax.swing.JFrame;

import Finalp.World;
import Finalp.GameScreen;

public class Start {

	public static void main(String[] args){
		GameScreen ref=new GameScreen();
		World screen = new World();
		MainMenu mm = new MainMenu();
		ref.addPanel(mm);
		ref.initJFrame();
	}
}

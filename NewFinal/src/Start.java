import javax.swing.JPanel;

public class Start {
	
	public static void main(String[] args){
		GameScreen ref=new GameScreen();
		World screen = new World();
		MainMenu mm = new MainMenu();
		ref.addPanel(screen);
		ref.initJFrame();
	}
	
}

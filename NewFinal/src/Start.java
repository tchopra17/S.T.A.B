import java.io.IOException;

public class Start {
	
	public static void main(String[] args) throws IOException{
		GameScreen ref = new GameScreen();
		World screen = new World();
		MainMenu mm = new MainMenu();
		ref.add(mm);
		ref.initJFrame();
	}
}

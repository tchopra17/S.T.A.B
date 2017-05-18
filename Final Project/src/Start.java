
public class Start {
	public static void main(String[] args){
		GameScreen ref=new GameScreen();
		World screen = new World(ref);
		ref.setWorld(screen);
		screen.initJFrame();
	}
}

import java.awt.Rectangle;

public class Tip extends Thing{
double direction;
	
	public Tip(double x, double y, double height, double width, double direction) {
		super(x, y, width, height);
		this.direction = direction;

	}
}
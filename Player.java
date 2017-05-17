import java.awt.Rectangle;
public class Player {
	private double x, y, height, width;

	public Player(double x, double y, double height, double width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public Rectangle returnPlayer() {
		Rectangle rect = new Rectangle((int) x,(int) y,(int) height, (int) width);
		return rect;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	
}

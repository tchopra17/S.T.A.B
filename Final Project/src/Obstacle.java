import java.awt.Rectangle;

public class Obstacle {
	private double x, y, height, width;

	public Obstacle(double x, double y, double height, double width) {
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

	public double getLeft() {
		return x;
	}

	public double getRight() {
		return x + width;
	}
	
	public double getTop() {
		return y;
	}
	
	public double getBottom(){
		return y + height;
	}
	
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
}
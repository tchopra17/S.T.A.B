import java.awt.Rectangle;
import javax.swing.Timer;
public class Player {
	private double x, y, height, width, velocity, deaccel, direction;

	public Player(double x, double y, double height, double width, double direction) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.direction=direction;
		deaccel=1;
		velocity=0;
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
	
	public void accelerate(){
		velocity=velocity+1;
	}
	
	public void deaccelerate(){
		velocity=velocity-deaccel;
	}
	
	public double getVelocity(){
		return velocity;
	}
	
	public void turnLeft(){
		direction=(direction-5)%360.;
	}
	
	public void turnRight(){
		direction=(direction+5)%360.;
	}
	
	public double getDirection(){
		return direction;
	}

}

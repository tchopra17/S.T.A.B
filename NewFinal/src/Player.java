import java.awt.Rectangle;
import javax.swing.Timer;
public class Player {
	private double x, y, height, width, velocity, deaccel, direction;
	private int health;

	public Player(double x, double y, double height, double width, double direction) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.direction=direction;
		deaccel=1;
		velocity=0;
		health=0;
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
		if(velocity!=5)
			velocity=velocity+1;
		else
			velocity=5;
	}
	
	public void deaccelerate(){
		if(velocity!=0)
			velocity=velocity-deaccel;
		else
			velocity=0;
	}
	
	public double getVelocity(){
		return velocity;
	}
	
	public void turnLeft(){
		direction=(direction-5);
	}
	
	public void turnRight(){
		direction=(direction+5);
	}
	
	public double getDirection(){
		return direction%360.;
	}
	public double getWidth(){
		return width;
	} 
	public double getHeight(){
		return height;
	}
	public void setVelocity(double v){
		velocity = v;
	}

}

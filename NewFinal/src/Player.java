
import java.awt.Color;
import java.awt.Rectangle;

public class Player extends Thing {
	private double velocity, deaccel, direction;
	private Color color;
	private int health;

	public Player(double x, double y, double height, double width, double direction, int health, Color color) {
		super(x, y, width, height);
		this.direction = direction;
		velocity = 0;
		this.health = health;
		this.color = color;
	}
	public void accelerate() {
		if (velocity < 3)
			velocity = velocity + 1;
		else
			velocity = 3;
	}

	public void deaccelerate() {
		if (velocity > 0)
			velocity = velocity - 1;
		else
			velocity = 0;
	}
  
	public void stop(){
		long a=System.currentTimeMillis();
		long b;
		while(velocity>0){
			b=System.currentTimeMillis();
			if((b-a)%10000.==0){
				deaccelerate();
			}
		}
	}
	

	public double getVelocity() {
		return velocity;
	}

	public void turnLeft() {
		direction = (direction +358.);
	}

	public void turnRight() {
		direction = (direction + 2.);
	}

	public double getDirection() {
		return direction % 360.;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public void setVelocity(double v) {
		velocity = v;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int h){
		health=h;
	}

	public Color getColor(){
		return color;
	}

}
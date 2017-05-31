
import java.awt.Rectangle;

public class Player extends Object {
	private double velocity, deaccel, direction;
	private int health;

	public Player(double x, double y, double height, double width, double direction, int health) {
		super(x, y, width, height);
		this.direction = direction;
		velocity = 0;
		this.health = health;
	}

	public void accelerate() {
		if (velocity <= 5)
			velocity = velocity + 1;
		else
			velocity = 5;
	}

	public void deaccelerate() {
		if (velocity >= 0)
			velocity = velocity - 1;
		else
			velocity = 0;
	}
  
	public void stop(){
		long time1=System.currentTimeMillis();
		long time2;
		while(velocity>0){
			time2=System.currentTimeMillis();
			if(time2-time1==5)
				deaccelerate();
		}
	}

	public double getVelocity() {
		return velocity;
	}

	public void turnLeft() {
		direction = (direction +350.);
	}

	public void turnRight() {
		direction = (direction + 10.);
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

}
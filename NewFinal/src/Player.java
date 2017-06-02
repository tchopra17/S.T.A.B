import java.awt.Color;
public class Player extends Object {
	private double velocity, direction;
	private int health;
	private Color c;

	public Player(double x, double y, double height, double width, double direction, int health, Color t) {
		super(x, y, width, height);
		this.direction = direction;
		velocity = 0;
		this.health = health;
		c=t;
	}

	public void accelerate() {
		if (velocity < 5)
			velocity = velocity + 1;
		else
			velocity = 5;
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
	
	public void setColor(Color t){
		c=t;
	}
	
	public Color getColor(){
		return c;
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
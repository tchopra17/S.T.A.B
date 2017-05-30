package Finalp;

import java.awt.Rectangle;

public class Player extends Object {
	private double velocity, deaccel, direction;
	private int health;

	public Player(double x, double y, double height, double width, double direction) {
		super(x, y, width, height);
		this.direction = direction;
		deaccel = 1;
		velocity = 0;
		health = 0;
	}

	public void accelerate() {
		if (velocity != 5)
			velocity = velocity + 1;
		else
			velocity = 5;
	}

	public void deaccelerate() {
		if (velocity != 0)
			velocity = velocity - deaccel;
		else
			velocity = 0;
	}

	public double getVelocity() {
		return velocity;
	}

	public void turnLeft() {
		direction = (direction - 10);
	}

	public void turnRight() {
		direction = (direction + 10);
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

}
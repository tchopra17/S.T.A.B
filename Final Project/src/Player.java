import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class Player{
	private double x, y, height, width, velx, vely;
	
	
	public Player(double x, double y, double height, double width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
	}
	
	public Ellipse2D returnPlayer(){
		Ellipse2D circle = new Ellipse2D.Double(x, y, width, height);
		return circle;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	
}

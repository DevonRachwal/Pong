import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Ball extends Rectangle{
	private Random rand;
	private double xVelocity;
	private double yVelocity;
	private int initialSpeed =2;

	Ball(int x, int y, int ballDiameter){
		super(x, y, ballDiameter, ballDiameter);
		rand = new Random();
		int randomXDirection = rand.nextInt(2);
		if(randomXDirection ==0) {
			randomXDirection --;
			setxVelocity(randomXDirection*initialSpeed);
		}
		if(randomXDirection ==1) {
			randomXDirection ++;
			setxVelocity(randomXDirection*initialSpeed);
		}
		int randomYDirection = rand.nextInt(2);
		if(randomYDirection ==0) {
			randomYDirection --;
			setyVelocity(randomYDirection*initialSpeed);
		}
		if(randomYDirection == 1) {
			randomYDirection ++;
			setyVelocity(randomYDirection*initialSpeed);
		}
		
	}
		
	public void move() {
		x+=getxVelocity();
		y+=getyVelocity();
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, height, width);
		
	}
	public double getyVelocity() {
		return yVelocity;
	}
	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
	public double getxVelocity() {
		return xVelocity;
	}
	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}
}

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class PongPanel extends JPanel implements Runnable{
	
	private static final int GAME_WIDTH = 1000;
	private static final int GAME_HEIGHT = (int) (GAME_WIDTH *(0.55555));
	private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	private static final int BALL_DIAMETER = 20;
	private static final int PADDLE_WIDTH = 25;
	private static final int PADDLE_HEIGHT = 100;
	private Thread gameThread;
	private Image image;
	private Graphics graphics;
	private Random rand;
	private Paddle paddle1;
	private Paddle paddle2;
	private Ball ball;
	private Score score;
	
	
	
	
	
	
	PongPanel(){
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
		
		
	}
	
	public void newBall() {
		rand = new Random();
		ball = new Ball((GAME_WIDTH-BALL_DIAMETER)/2, rand.nextInt(GAME_HEIGHT-BALL_DIAMETER/2), BALL_DIAMETER);
		
	}
	public void newPaddles() {
		paddle1 = new Paddle(0, (GAME_HEIGHT- PADDLE_HEIGHT)/2, PADDLE_WIDTH, PADDLE_HEIGHT,1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT- PADDLE_HEIGHT)/2, PADDLE_WIDTH, PADDLE_HEIGHT,2);
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		
		
	}
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
		
	}
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
		
	}
	public void checkCollision() {
		if(ball.y <= 0) {
			ball.setyVelocity(ball.getyVelocity());
		}
		if (ball.y+BALL_DIAMETER/2 >= GAME_HEIGHT) {
			ball.setyVelocity(ball.getyVelocity());	
		}
		if(ball.intersects(paddle1) || ball.intersects(paddle2)) {
			ball.setxVelocity(ball.getxVelocity()*-1);
			ball.setxVelocity(ball.getxVelocity()*1.1);
			ball.setyVelocity(ball.getyVelocity()*1.1);
		}
		if(ball.y <= 0) {
			ball.setyVelocity(ball.getyVelocity()*-1);
		}
		if (ball.y+BALL_DIAMETER/2 >= GAME_HEIGHT) {
			ball.setyVelocity(ball.getyVelocity()*-1);	
		}
		if(paddle1.y >= GAME_HEIGHT-PADDLE_HEIGHT){
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		if(paddle1.y<=0) {
			paddle1.y=0;
		}
		if(paddle2.y >= GAME_HEIGHT-PADDLE_HEIGHT){
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		if(paddle2.y<=0) {
			paddle2.y=0;
		}
		if(ball.x <= 0) {
			score.setPlayer1(score.getPlayer1()+1);
			newPaddles();
			newBall();
			System.out.println("Player 2 Scored! \n" +score.getPlayer1() + "  |  " + score.getPlayer2());		
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.setPlayer2(score.getPlayer2()+1);
			newPaddles();
			newBall();
			System.out.println("Player 1 Scored! \n" +score.getPlayer1() + "  |  " + score.getPlayer2());		
		}
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 /amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
		
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
	
			
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);		
			
		} 
	}
}

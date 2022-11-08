import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Score extends Rectangle{
	private static int GAME_WIDTH;
	private static int GAME_HEIGHT;
	private int player1;
	private int player2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.GAME_HEIGHT = GAME_HEIGHT;
		Score.GAME_WIDTH = GAME_WIDTH;
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		g.drawString(Integer.toString(player2), GAME_WIDTH/2-70, 50);
		g.drawString(Integer.toString(player1), GAME_WIDTH/2+50, 50);
	}
	public static int getGAME_WIDTH() {
		return GAME_WIDTH;
	}
	public static void setGAME_WIDTH(int gAME_WIDTH) {
		GAME_WIDTH = gAME_WIDTH;
	}
	public static int getGAME_HEIGHT() {
		return GAME_HEIGHT;
	}
	public static void setGAME_HEIGHT(int gAME_HEIGHT) {
		GAME_HEIGHT = gAME_HEIGHT;
	}
	public int getPlayer1() {
		return player1;
	}
	public void setPlayer1(int player1) {
		this.player1 = player1;
	}
	public int getPlayer2() {
		return player2;
	}
	public void setPlayer2(int player2) {
		this.player2 = player2;
	}

}

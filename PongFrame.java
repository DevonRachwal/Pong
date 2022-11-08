import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class PongFrame extends JFrame{
	private PongPanel panel;
	
	
	PongFrame(){
		panel = new PongPanel();
		this.add(panel);
		this.setTitle("Pong");
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

}

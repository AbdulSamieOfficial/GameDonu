package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Apple;
import entity.Map;
import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	
	//Screen settigs
	final int originalTileSize = 16;
	final int scale = 3;
	
	public	final int tileSize = originalTileSize * scale; // 48
	public final int maxScreenCol = 12;
	public final int maxScreenRow = 6;
	public final int screenWidth = tileSize * maxScreenCol; 
	public final int screenHeight = tileSize * maxScreenRow; 
	
	// FPS
	int FPS = 60;   //FPS can be chnaged from here
	int score = 0;
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Map map = new Map(this);
	Apple apple = new Apple(this);
	Player player = new Player(this, keyH);
	
	public GamePanel() {            // This is to add the basic functionality of window size
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {     //Creating game thread here to give it an infinite loop
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;        //Updating changes after every single time
		double nextDrawTime = System.nanoTime() + drawInterval;
		while(gameThread != null) {
			long currentTime = System.nanoTime();
			update();
			
			repaint();
			//System.out.println("This game loop is running!\n");
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void update() {
		player.update();
	}
	
	public boolean gamecheck(int x, int y) {          //Checking either the player has reached the golden point or not
		boolean temp = false;
		if(x > 505 && y > 170) {
			temp = true;
		}
		return temp;
	}
	
	public void updateCollision(int [][]details, int x, int y) {    //Checking the collision between Apple and Player
		int temp1 = 0, temp2 = 0;
		for(int i = 0; i < 5; i++) {
			temp1 = details[i][0] - x;
			if(temp1 < 0) {
				temp1 = temp1 * -1;
			}
			temp2 = details[i][1] - y;
			if(temp2 < 0) {
				temp2 = temp2 * -1;
			}
			if(temp1 < 25 && temp2 < 20 && details[i][2] == 0) {
				details[i][2] = 1;
				score++;
			}
		}
	}
	
	public void paintComponent(Graphics g) {     //Repainting/Redrawing the whole game after every fps
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		map.draw(g2);
		apple.draw(g2);
		player.draw(g2);
		updateCollision(apple.details, player.x, player.y);
		g2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g2.drawString("Score: ", 240, 40);
		g2.drawString(String.valueOf(score), 300, 40);
		boolean chk = gamecheck(player.x,player.y);
		if(chk == true) {
			g2.setFont(new Font("Times New Roman", Font.BOLD, 60));
			g2.drawString("GAME OVER!", 100, 160);
		}
		g2.dispose();
	}
}

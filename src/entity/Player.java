package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel g, KeyHandler k) {
		this.gp = g;
		this.keyH = k;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		x = 12;
		y = 230;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/pic 5.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/pic 10.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/pic 1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/pic 2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/pic 1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/pic 2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {               //Player Movement + Player AI
		if(keyH.leftPressed == true || keyH.rightPressed == true || keyH.upPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";  //This will assist in jumping of a player
				y -= speed;
				//x += speed;
				//System.out.println(y + " " + x);
				if(x > 119 && y  > 204 && y < 230) {
					
					y = 208;
				}else if(x > 122 && x < 136 && y > 180 && y < 205) {
					y = 172;
				}else if(x < 60 && y > 166 && y < 180 ) {
					y = 138;
				}else if(x > 38 && y > 128 && y < 140) {
					y = 104;
				}else if(x > 75 && y < 110 && y > 98) {
					y = 82;
				}else if(x > 180 && x < 210 && y < 88 && y > 74) {
					x = 222;
					y = 68;
				}else if(x > 278 && x < 290 && y > 62 && y < 70) {
					x = 348;
				}else if(x == 160 && y == 204) {
					y = 190;
				}else if(x >= 170 && x <= 188 && y >= 186 && y <= 194) {
					x = 190;
					y = 154;
				}else if(x >= 440 && x < 460 && y >= 200) {
					y = 190;
				}else if(x >= 456 && x <= 472 && y >= 182 && y <= 202) {
					y = 172;
				}
				else {
					y += speed;
				}
				//y += speed * 4;
				
			}else if(keyH.leftPressed == true) {    //for player left movement
				direction = "left";
				x -= speed;
			}else if(keyH.rightPressed == true) {  //for player right movement
				direction = "right";
				x += speed;
			}
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2) {       //Redrawing player after every 1 FPS

		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
		switch(direction) {
		case "up": 
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		//System.out.println(y + " " + x);
		if(x < 12) {
			x = 12;
		}
		if(x > 520) {
			x = 520;
		}
		if(x > 120 && y == 230) {
			
			x = 120;
		}if(x > 160 && x < 172 && y > 190 && y < 210) {
			
			y = 208;
			x = 160;
		}if(x < 118 && y > 202 && y < 210) {
			x = 120;
			y = 230;
		}if(x > 128 && x < 133 && y > 166 && y < 180) {
			
			y = 208;
			x = 120;
		}if(x > 50 && x < 60 && y > 128 && y < 140) {
			y = 172;
		}if(x < 38 && y > 98 && y < 110) {
			y = 138;
		}if(y > 98 && y < 110 && x >= 72 && x <= 84) {
			x = 76;
		}if(x < 72 && y < 88 && y > 78) {
			y = 104;
		}if(x > 210 && y < 88 && y > 78) {
			
			y = 154;
			x = 210;
		}if(x < 220 && y < 76 && y > 66) {
			y = 154;
			x = 210;
		}
		if(x > 290 && x < 340 && y < 66 && y > 58) {
			y = 154;
		}if(x > 436 && x < 460 && y > 50 && y < 80) {
			x = 456;
			y = 190;
		}
		if(y > 186) {
			//System.out.println("Yess");
		}
		if(x == 184 && y >= 186 && y <= 194) {
			//System.out.println("yes");
			x = 180;
		}if(x > 140 && x < 164 && y >= 146 && y <= 156) {
			y = 190;
		}if(x >= 152 && x <= 156 && y >= 186 && y <= 194) {
			y = 208;
		}if(x >= 366 && x <= 378 && y >= 146 && y <= 156) {
			y = 190;
		}if(x > 340 && x <= 362 && y == 190) {
			x = 366;
		}if(x > 402 && x < 410 && y == 190) {
			y = 208;
		}if(x <= 404 && x >= 398 && y == 208) {
			x = 404;
		}if(x >= 452 && x <=558 && y == 208) {
			x = 452;
		}if(x > 440 && x < 448 & y == 190) {
			y = 208;
		}if(y == 190 && x == 476) {
			x = 472;
		}if(y == 172 && x < 468) {
			y = 190;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}

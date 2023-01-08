package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {        //This class holds the data for PLAYER, MAPS and APPLE
	public int x, y;    //for player x-axis and y-axis respectively
	public int speed;   //for player speed
	
	public BufferedImage left1, left2, right1, right2, up1, up2, map1;
	
	public BufferedImage apple1, apple2, apple3, apple4, apple5, apple6, apple7, apple8, apple9, apple10, apple11, apple12, apple13, apple14, apple15, apple16, apple17;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public boolean collisionOn = false;
}

package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Apple extends Entity{
	
	GamePanel gp;
	int index;
	public int [][]details = new int[5][3];
	
	public Apple(GamePanel g){        //Assigning all apples their status
		this.gp = g;
		index = 1;
		getApple();
		details[0][0] = 60;
		details[0][1] = 230;
		details[0][2] = 0;
		details[1][0] = 210;
		details[1][1] = 154;
		details[1][2] = 0;
		details[2][0] = 310;
		details[2][1] = 154;
		details[2][2] = 0;
		details[3][0] = 390;
		details[3][1] = 190;
		details[3][2] = 0;
		details[4][0] = 435;
		details[4][1] = 208;
		details[4][2] = 0;
	}
	
	public void getApple() {
		try {
			apple1 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple1.png"));
			apple2 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple2.png"));
			apple3 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple3.png"));
			apple4 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple4.png"));
			apple5 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple5.png"));
			apple6 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple6.png"));
			apple7 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple7.png"));
			apple8 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple8.png"));
			apple9 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple9.png"));
			apple10 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple10.png"));
			apple11 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple11.png"));
			apple12 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple12.png"));
			apple13 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple13.png"));
			apple14 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple14.png"));
			apple15 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple15.png"));
			apple16 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple16.png"));
			apple17 = ImageIO.read(getClass().getResourceAsStream("/apple/Apple17.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		if(index == 1) {
			image = apple1;
		}else if(index == 2){
			image = apple2;
		}else if(index == 3){
			image = apple3;
		}else if(index == 4){
			image = apple4;
		}else if(index == 5){
			image = apple5;
		}else if(index == 6){
			image = apple6;
		}else if(index == 7){
			image = apple7;
		}else if(index == 8){
			image = apple8;
		}else if(index == 9){
			image = apple9;
		}else if(index == 10){
			image = apple10;
		}else if(index == 11){
			image = apple11;
		}else if(index == 12){
			image = apple12;
		}else if(index == 13){
			image = apple13;
		}else if(index == 14){
			image = apple14;
		}else if(index == 15){
			image = apple15;
		}else if(index == 16){
			image = apple16;
		}else if(index == 17){
			image = apple17;
		}
		if(index == 17) {
			index = 1;
		}else {
			index++;
		}
		for(int i =0; i < 5;i++) {
			if(details[i][2] == 0) {
				g2.drawImage(image, details[i][0], details[i][1], gp.tileSize, gp.tileSize, null);
			}
		}
	}
}

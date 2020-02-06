package Constructors;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Libraries.Pokedex;

public class Pokemon {
	private String name;
	private Integer attack;
	private Integer defense;
	private Integer hp;
	private Integer dex;
	private String move1;
	private String move2;
	private String move3;
	private String move4;
	private Integer type1;
	private Integer type2;


	
public Pokemon(String s) {
	this.name = s;
	String[] stats = Pokedex.Identify(s);
	this.hp =  Integer.parseInt(stats[0]);
	this.attack = Integer.parseInt(stats[1]);
	this.defense = Integer.parseInt(stats[2]);
	this.dex = Integer.parseInt(stats[7]);
	this.type1 = Integer.parseInt(stats[8]);
	this.type2 = Integer.parseInt(stats[9]);
	this.move1 = stats[11];
	this.move2 = stats[12];
	this.move3 = stats[13];
	this.move4 = stats[14];
	
}

public Sprite getSprite() throws IOException {
	return new Sprite();
}
public String getName() {
	return name;
}
public int getHP() {
	return ((((this.hp + 16) * 2 + 37) * 50) / 100) + 10 + 50;
}
public int getAttack() {
	return ((((this.attack + 16) * 2 + 37) * 50) / 100) + 5;
}
public int getDefense() {
	return ((((this.defense + 16) * 2 + 37) * 50) / 100) + 5;
}

public int getType1() {
	return type1;
}

public int getType2() {
	return type2;
}

public String getMove1() {
	return move1;
}

public String getMove2() {
	return move2;
}

public String getMove3() {
	return move3;
}

public String getMove4() {
	return move4;
}

public class Sprite extends JPanel {
	// size of the jpanel/card
	private int sizeH = 256;
	private int sizeW = 256;
	private String Name;
	final BufferedImage image;

	// sets size and throws exception
	Sprite() throws IOException {
		setSize(sizeW, sizeH);
	}

	private static final long serialVersionUID = 5545952195000855231L;

	// declares the beginning of the jpeg name for the naming scheme of the jpegs to
	// make reading them easier

	Random x = new Random();
	int shiny = x.nextInt(2);
	{
		if (shiny == 0) {
			image = ImageIO.read(new File("H:\\Computer Programming\\src\\Shiny\\shiny\\" + dex + ".png"));
		} else {
			image = ImageIO.read(new File("H:\\Computer Programming\\src\\base\\"+dex+".png"));
		}

		// renders picture of card into class and resizes it

		final BufferedImage resized = resize(image, sizeH, sizeW);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// draws the picture onto the Sprite JPanel
		g2.drawImage(resize(image, sizeH, sizeW), 0, 0, null);
	}

	// resizes the BufferedImage
	private BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}
}


}


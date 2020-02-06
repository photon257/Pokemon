package Constructors;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Libraries.Attackdex;

public class BattleFrame {
	 public static JFrame frame = new JFrame();
	 public static JPanel sprite;
	 public static JPanel esprite;
	 public static JButton attack1 = new JButton();
	 public static JButton attack2 = new JButton();
	 public static JButton attack3 = new JButton();
	 public static JButton attack4 = new JButton();
	 public static int ehp;
	 public static int hp;
	 public JLabel text = new JLabel();
	 public JLabel eText = new JLabel();
	 public JLabel attackText = new JLabel();
	 public static Pokemon player;
	 public static Pokemon opponent;
	 public static JPanel background;
	 public static double damage;
	 public static int[]move = new int[24];
	 public static int[]eMove = new int[24];
	 public static Team pTeam = new Team();
	 public static Team eTeam = new Team();
	 static int ko = 0;
	 static int eko = 0;



	
public BattleFrame(String p, String e) {
		this.player = pTeam.get(ko);
		this.opponent = eTeam.get(ko);
		frame.setSize(1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		
		ehp = opponent.getHP();
		
		
		
		hp = player.getHP();
		
		
		
		attack1.setBounds(700, 700, 100, 100);
		attack2.setBounds(800, 800, 100, 100);
		attack3.setBounds(700, 800, 100, 100);
		attack4.setBounds(800, 700, 100, 100);
		
		
		
		text.setText("HP:" + hp);
		text.setBounds(150, 860, 100, 100);
		
		
		
		eText.setText("HP:" + ehp);
		eText.setBounds(1200, 710, 100, 100);
		
		
		
		try {
			background = new Background();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		background.setBounds(0,0,1920,1080);
		
		
		
		try {
			sprite = player.getSprite();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sprite.setBounds(150, 600, 1000, 256);

		
		
		try {
			esprite = opponent.getSprite();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		esprite.setBounds(1200, 450, 1000, 256);
		

		
		attackText.setBounds(750, 525, 500, 200);
		
		
		
		frame.add(sprite);
		frame.add(attackText);
		frame.add(esprite);
		frame.add(attack1);
		frame.add(attack2);
		frame.add(attack3);
		frame.add(attack4);
		frame.add(text);
		frame.add(eText);
		frame.add(background);
		frame.setVisible(true);
	}

public int getPlayerAttack() {
	return player.getAttack();
}

public int getPlayerDefense() {
	return player.getDefense();
}

public int getOpponentAttack() {
	return opponent.getAttack();
}

public int getOpponentDefense() {
	return opponent.getDefense();
}

public JButton getAttack1() {
	return attack1;
}
public JButton getAttack2() {
	return attack2;
}
public JButton getAttack3() {
	return attack3;
}
public JButton getAttack4() {
	return attack4;
}

public JLabel getText() {
	return text;
}

public JLabel getEText() {
	return eText;
}

public void repaint() {
	frame.repaint();
}

public JLabel getAttackText(){
	return attackText;
}


public static void battle(BattleFrame b) {
	attack1.setText(player.getMove1());
	attack2.setText(player.getMove2());
	attack3.setText(player.getMove3());
	attack4.setText(player.getMove4());
	Random x = new Random(); //opponent uses a random move of its 4
	int rand = x.nextInt(4)+1;
	if(rand == 1) {
		eMove = Attackdex.Identify(opponent.getMove1()); //sets the stats for the selected move
	}else if(rand == 2) {
		eMove = Attackdex.Identify(opponent.getMove2()); //sets the stats for the selected move
	}else if(rand == 3) {
		eMove = Attackdex.Identify(opponent.getMove3()); //sets the stats for the selected move
	}else {
		eMove = Attackdex.Identify(opponent.getMove4()); //sets the stats for the selected move
	}
	
	
b.getAttack1().addActionListener(new ActionListener() { // move 1
		public void actionPerformed(ActionEvent arg0) {
			move = Attackdex.Identify(player.getMove1()); //sets the stats for the selected move
			damage  = ((((((2*50)/5)+2)*(move[3] * player.getAttack()/opponent.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
			ehp -= damage; //deals the damage
			
			b.getAttackText().setText(player.getName() + " used " + player.getMove1()); //displays text saying what move was used
			b.getEText().setText("HP:" + ehp); //updates opponents hp
			
			
			damage  = ((((((2*50)/5)+2)*(eMove[3] * opponent.getAttack()/player.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
			hp -= damage; //deals the damage
			
			b.getText().setText("HP:" + hp);
			checkKO();
			b.repaint();

	}});



b.getAttack2().addActionListener(new ActionListener() { // move 1
	public void actionPerformed(ActionEvent arg0) {
		move = Attackdex.Identify(player.getMove2());
		damage  = ((((((2*50)/5)+2)*(move[3] * player.getAttack()/opponent.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
		ehp -= damage; //deals the damage
		
		b.getAttackText().setText(player.getName() + " used " + player.getMove2()); //displays text saying what move was used
		b.getEText().setText("HP:" + ehp); //updates opponents hp
		
		
		damage  = ((((((2*50)/5)+2)*(eMove[3] * opponent.getAttack()/player.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
		hp -= damage; //deals the damage
		
		b.getText().setText("HP:" + hp);
		checkKO();
		b.repaint();

}});



b.getAttack3().addActionListener(new ActionListener() { // move 1
	
	public void actionPerformed(ActionEvent arg0) {
		move = Attackdex.Identify(player.getMove3());
		damage  = ((((((2*50)/5)+2)*(move[3] * player.getAttack()/opponent.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
		ehp -= damage; //deals the damage
		
		b.getAttackText().setText(player.getName() + " used " + player.getMove3()); //displays text saying what move was used
		b.getEText().setText("HP:" + ehp); //updates opponents hp
		
		
		damage  = ((((((2*50)/5)+2)*(eMove[3] * opponent.getAttack()/player.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
		hp -= damage; //deals the damage
		
		b.getText().setText("HP:" + hp);
		checkKO();
		b.repaint();


}});



b.getAttack4().addActionListener(new ActionListener() { // move 1

	public void actionPerformed(ActionEvent arg0) {
		move = Attackdex.Identify(player.getMove4());
		damage  = ((((((2*50)/5)+2)*(move[3] * player.getAttack()/opponent.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
		ehp -= damage; //deals the damage
		
		b.getAttackText().setText(player.getName() + " used " + player.getMove4()); //displays text saying what move was used
		b.getEText().setText("HP:" + ehp); //updates opponents hp
		
		damage  = ((((((2*50)/5)+2)*(eMove[3] * opponent.getAttack()/player.getDefense())/50)+2))*Attackdex.getMod(move); //calculates damage for said move
		hp -= damage; //deals the damage
		
		b.getText().setText("HP:" + hp);
		checkKO();
		b.repaint();


}});
}

public static void checkKO() {
	if(hp <= 0) {
		ko++;
		player = pTeam.get(ko);
		frame.remove(sprite);
		try {
			sprite = player.getSprite();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frame.add(sprite);
		sprite.setBounds(150, 600, 1000, 256);
		hp = player.getHP();
		attack1.setText(player.getMove1());
		attack2.setText(player.getMove2());
		attack3.setText(player.getMove3());
		attack4.setText(player.getMove4());
	}
	if(ehp <= 0) {
		eko++;
		opponent = eTeam.get(ko);
		frame.remove(esprite);
		try {
			esprite = opponent.getSprite();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frame.add(esprite);
		esprite.setBounds(1200, 450, 1000, 256);
		ehp = opponent.getHP();
		
	}
	frame.remove(background);
	frame.add(background);
	frame.repaint();

		
}

public class Background extends JPanel {
	// size of the jpanel/card
	private int sizeH = 1080;
	private int sizeW = 1920;
	private String Name;
	final BufferedImage image;

	// sets size and throws exception
	Background() throws IOException {
		setSize(sizeW, sizeH);
	}

	private static final long serialVersionUID = 5545952195000855231L;

	// declares the beginning of the jpeg name for the naming scheme of the jpegs to
	// make reading them easier

	Random x = new Random();
	int shiny = x.nextInt(2);
	{
		
			image = ImageIO.read(new File("H:\\Battle.png"));
	
		

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


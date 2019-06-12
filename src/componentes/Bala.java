package componentes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.*;

public class Bala extends JPanel {
	Image bullet = Toolkit.getDefaultToolkit().getImage("src/images/bullet.png");
	
	int xpos = 350;
	int ypos = 500;
	Rectangle rect;
	
	public Bala() {
		setBounds(xpos,ypos,30,60);
		setOpaque(false);
		rect = new Rectangle();
		rect.setBounds(xpos,ypos,30,60);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bullet,-20,-20,70,100,this);
	}
	public int getXpos() {
		return xpos;
	}
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	public int getYpos() {
		return ypos;
	}
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	
	public void move() {

			this.ypos = ypos-1;
			setBounds(xpos,ypos,30,60);
			rect.setBounds(xpos,ypos,30,60);
	}
	
	public Rectangle getRect() {
		return rect;
	}
}

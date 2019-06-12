package componentes;

import java.awt.*;
import javax.swing.*;

public class Avion extends JPanel {
	Image airplane = Toolkit.getDefaultToolkit().getImage("src/images/airplane.png");
	
	int xpos = 700;
	int ypos = 100;
	Rectangle rect;
	
	public Avion() {
		setBounds(xpos,ypos,150,35);
		setOpaque(false);
		rect = new Rectangle();
		rect.setBounds(xpos, ypos, 150, 35);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(airplane,-7,-55,150,150,this);
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
		
	public void move(){
		if(xpos==-160) {
			xpos=1000;
		}
		xpos = xpos-1;
		setBounds(xpos,ypos,150,35);
		rect.setBounds(xpos, ypos, 150, 35);
	}

	public Rectangle getRect() {
		return rect;
	}
	
}
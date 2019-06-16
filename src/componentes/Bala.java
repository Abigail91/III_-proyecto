package componentes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.*;

import estructurasDeDatos.ListaEnlazadaSimple;
import estructurasDeDatos.Nodo;
import interfaz.Mapa;

public class Bala extends JPanel {
	Image bullet = Toolkit.getDefaultToolkit().getImage("src/images/bullet.png");
	
	int xpos = 350;
	int ypos = 500;
	Rectangle rect;
	Avion airplaneRemove;
	Thread move;
	
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
		this.move = new BulletMove(this);
		move.start();
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public boolean verify() {
		Nodo<Avion> airplane = Mapa.airplaneList.getFirst();
		while(airplane.getNext()!=null) {
			if(airplane.getData().getRect().intersects(this.rect)) {
				this.airplaneRemove = airplane.getData();
				return true;
			}
			airplane = airplane.getNext();
		}
		return false;
	}
	
	public Avion getAirplane() {
		return this.airplaneRemove;
	}
}

class BulletMove extends Thread{
	Bala bullet;
	public BulletMove(Bala bullet) {
		this.bullet = bullet;
	}
	public void run(){
		while(true) {
			if(bullet==null) {
				break;
			}
			else {
				bullet.setYpos(bullet.getYpos()-1);
				bullet.setBounds(bullet.getXpos(),bullet.getYpos(),30,60);
				bullet.getRect().setBounds(bullet.getXpos(),bullet.getYpos(),30,60);
			}
			try {
				BulletMove.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
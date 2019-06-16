
package componentes;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import estructurasDeDatos.ListaEnlazadaSimple;
import grafos.Vertex;
import interfaz.Mapa;

public class Avion extends JPanel {
	Image airplane = Toolkit.getDefaultToolkit().getImage("src/images/avion.png");

	Thread move;
	int index =(int) (Math.random() * 10);
	int xpos = (int) Mapa.grafo.getVertexes().get(9).getX();
	int ypos = (int) Mapa.grafo.getVertexes().get(9).getY();
	Rectangle rect;
	public ArrayList<Vertex> ruta = new ArrayList<Vertex>();
	
	
	public Avion() {
		setBounds(xpos,ypos,35,35);
		setOpaque(false);
		rect = new Rectangle();
		rect.setBounds(xpos, ypos,35, 35);
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
		
	public void move(int x, int y){
		this.move = new AirplaneMove(this,x,y);
		move.start();
	}

	public Rectangle getRect() {
		return rect;
	}
	
}

class AirplaneMove extends Thread{
	Avion airplane;
	int x;
	int y;
	public AirplaneMove(Avion airplane, int x, int y) {
		this.airplane = airplane;
		this.x = x;
		this.y = y;
	}
	public void run(){
		while(true) {
			if(airplane.getXpos()==x & airplane.getYpos()==y ) {
				break;	
			}
			if(airplane.getXpos()<x) {
				airplane.setXpos(airplane.getXpos()+1);
			}
			if(airplane.getXpos()>x) {
				airplane.setXpos(airplane.getXpos()-1);
			}
			if(airplane.getYpos()<y) {
				airplane.setYpos(airplane.getYpos()+1);
			}
			if(airplane.getYpos()>y) {
				airplane.setYpos(airplane.getYpos()-1);
			}
			airplane.setBounds(airplane.getXpos(),airplane.getYpos(),35,35);
			airplane.getRect().setBounds(airplane.getXpos(), airplane.getYpos(), 35, 35);
			try {
				AirplaneMove.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}





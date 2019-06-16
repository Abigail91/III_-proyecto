package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.Avion;
import componentes.Bala;
import componentes.PortaAvion;
import componentes.Tablero;
import estructurasDeDatos.ListaEnlazadaSimple;
import grafos.Graph;

public class Mapa extends JFrame{
	public static JLabel vent;
	JLabel nodo;
	public static ArrayList<PortaAvion> nodos = new ArrayList<PortaAvion>();
	public static ListaEnlazadaSimple <Avion> airplaneList = new ListaEnlazadaSimple <Avion>();
	ListaEnlazadaSimple <String> rutaList;

	public Mapa()  {
		this.getContentPane().setBackground(Color.DARK_GRAY);
		setSize(1000,800);
		setTitle("Air War");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		Thread draw = new ThreadDraw(this);
		draw.start();
		ImageIcon foto = new ImageIcon("src/images/mapa.jpg");
		JLabel vent = new JLabel(foto);
		vent.setSize(1000,800);
		vent.setName("Air War");
		vent.setBounds(0, 0, 1000, 650);
		vent.setLayout(null);
		ImageIcon icono = new ImageIcon("src/images/icono.jpg");
		setIconImage(icono.getImage());
		add(vent);
		for(int i = 0; i<10;i++) {
			int fila = (int) (Math.random() * 12);
			int columna = (int) (Math.random() *28 );
			System.out.println(fila);
			System.out.println(columna);
			
			int value = Tablero.matriz[fila][columna];
			
			if(value==0) {
				nodo = new JLabel(new ImageIcon("src/images/portaAviones.png"));
				
			}else {
				nodo = new JLabel(new ImageIcon("src/images/aeropuerto.png"));
				
			}
			int pos_X = (columna*32)+10;
			int pos_y = (fila*32)+72;
			nodo.setBounds(pos_X, pos_y, 32, 32);
			
			
			vent.add(nodo);
			nodos.add(new PortaAvion(pos_X,pos_y,value,nodo));
			
		}
		Graph grafo = new Graph();
		grafo.generateRandomPlaces();
		System.out.println(grafo);
		Thread airplaneThread = new AirplaneThread(this);
		airplaneThread.start();
		Thread bulletThread = new ThreadDraw(this);
		bulletThread.start();
		setVisible(true);
		
	}
	public void moveAirplane(int x, int y,Avion airplane) {
		airplane.move(x,y);
	}
		
}

class ThreadDraw extends Thread implements ActionListener{
	Mapa frame;
	Bala bullet;
	JButton fire = new JButton();
	int cont=0;
	
	public ThreadDraw(Mapa frame) {
		this.frame = frame;
		fire = new JButton();
		fire.setIcon(new ImageIcon("src/images/button.png"));
		fire.setBounds(320,530, 100, 50);
		fire.addActionListener(this);
		frame.add(fire,0);
	}
	

	public synchronized void run() {
		while(true) {
			if(bullet!=null) {
				if(cont==0) {
					frame.add(bullet,0);
					cont+=1;
					bullet.move();
				}
				if(bullet.verify()==true) {
					Mapa.airplaneList.delete(bullet.getAirplane());
					frame.remove(bullet.getAirplane());
					frame.remove(bullet);
					this.bullet = null;
					frame.repaint();
					cont=0;
					}
				else if(bullet.getYpos()<-40) {
					frame.remove(bullet);
					this.bullet = null;
					frame.repaint();
					cont=0;
				}
			}
			try {
				ThreadDraw.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fire & cont==0) {
			Bala bull = new Bala();
			this.bullet = bull;
		}
	}
	
}

class AirplaneThread extends Thread{
	Mapa frame;
		
	public AirplaneThread(Mapa frame) {
		this.frame = frame;
	}
	
	public synchronized void run() {
		int x;
		int y;
		while(true) {
			x = (int) (Math.random() * 900);
			y = (int) (Math.random() * 700);
			Avion airplane = new Avion();
			Mapa.airplaneList.addLast(airplane);
			frame.add(airplane,0);
			airplane.move(x,y);
			try {
				AirplaneThread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}                                                                                                                                 



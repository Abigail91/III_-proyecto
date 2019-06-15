package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.Avion;
import componentes.Bala;
import componentes.Tablero;
import estructurasDeDatos.ListaEnlazadaSimple;

public class Mapa extends JFrame{
	public static JLabel vent;
	JLabel nodo;
	ListaEnlazadaSimple nodos = new ListaEnlazadaSimple();
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
		add(vent,2);
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
			System.out.println(pos_X);
			System.out.println(pos_y);
			nodo.setBounds(pos_X, pos_y, 32, 32);
			System.out.println();
			vent.add(nodo);
			nodos.addLast( pos_X,pos_y,value);
			
		}
		setVisible(true);
		Tablero.matriz();
		nodos.print();
	}
		
}
	
	
	
		


class ThreadDraw extends Thread implements ActionListener{
	Mapa frame;
	Avion airplane;
	Bala bullet = null;
	JButton fire = new JButton();
	int cont=0;

	
	public ThreadDraw(Mapa frame) {
		this.frame = frame;
		this.airplane = new Avion();
		fire = new JButton();
		fire.setIcon(new ImageIcon("src/images/button.png"));
		fire.setBounds(320,530, 100, 50);
		fire.addActionListener(this);
		frame.add(fire);
	}
	

	public synchronized void run() {
		frame.add(airplane);
		while(true) {
			airplane.move();
			if(bullet!=null) {
				if(cont==0) {
					frame.add(bullet,1);
					cont+=1;
				}
				bullet.move();
				if(airplane.getRect().intersects(bullet.getRect()) || bullet.getYpos()<-40) {
					frame.remove(bullet);
					this.bullet = null;
					//frame.remove(airplane);
					cont=0;
					//break;
					}
			}
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
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
package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mapa extends JFrame{
	JLabel vent;
	public Mapa()  {
	this.getContentPane().setBackground(Color.DARK_GRAY);
	setSize(1000,800);
	setTitle("Air War");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLayout(null);
	ImageIcon foto = new ImageIcon("src/images/mapa.jpg");
	JLabel vent = new JLabel(foto);
	vent.setSize(1000,800);
	vent.setName("Air War");
	vent.setBounds(0, 0, 1000, 650);
	vent.setLayout(null);
	ImageIcon icono = new ImageIcon("src/images/icono.jpg");
	setIconImage(icono.getImage());
	add(vent);
	setVisible(true);
	
	}
	}

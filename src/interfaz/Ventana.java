package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Ventana extends JFrame implements ActionListener{
	JLabel vent;
	public Ventana()  {
	setSize(700,700);
	setTitle("Air War");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLayout(null);
	ImageIcon foto = new ImageIcon("src/images/fondo.jpg");
	JLabel vent = new JLabel(foto);
	vent.setSize(700,700);
	vent.setName("Air War");
	vent.setBounds(0, 0, 700, 700);
	vent.setLayout(null);
	ImageIcon icono = new ImageIcon("src/images/icono.jpg");
	setIconImage(icono.getImage());
	JButton button = new JButton();
	button.setText("Jugar");
	button.setBounds(250,250,200, 60);
	button.addActionListener(this);
	add(button);
	JButton bot = new JButton();
	bot.setText("Salir");
	bot.setBounds(250,350, 200, 60);
	
	
	bot.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			CloseFrame();
			
			
		}
	});
	add(bot);
	add(vent);
	setVisible(true);}
	
	
	public void CloseFrame(){
	    super.dispose();
	}

	 
	 
 		
public static void main(String[] args) {
	new Ventana();
}




@Override
public void actionPerformed(ActionEvent arg0) {
	this.setVisible(false);
	new Mapa();
	
	
		
	
}

}

package componentes;

import javax.swing.JLabel;

public class PortaAvion {
	public int pos_x;
	public int pos_y;
	public int peso;
	public JLabel label;
	
	public PortaAvion(int x, int y, int peso,JLabel label) {
		this.pos_x = x;
		this.pos_y = y;
		this.peso = peso;
		this.label = label;
		
	}

}

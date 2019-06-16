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

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}

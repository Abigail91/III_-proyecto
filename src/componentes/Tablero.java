package componentes;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class Tablero extends Frame{
	private static int matriz[][] = new int[20][20];
	private static int FILAS = 20;
	private static int COLUMNAS = 20;
	
	
	public static void matriz() {
		for(int i= 0; i<FILAS;i++) {
			for(int j= 0; j<COLUMNAS;j++) {
				matriz[i][j] = 0;
				
		}
			}
	

}
	public  void  dibujarMatriz() {
		for(int i= 0; i<FILAS;i++) {
			for(int j= 0; j<COLUMNAS;j++) {
				getGraphics().setColor(Color.RED);
					getGraphics().drawLine(50, 50, 500, 500);
					
			}
		}
	}
}

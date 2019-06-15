package estructurasDeDatos;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ListaEnlazadaSimple<T> implements java.io.Serializable{
	

		private int len;
		public Nodo <T> first;
		public String nombre;
		JFrame ventana = new JFrame();  
		int fila = 0;
		
		
		public ListaEnlazadaSimple() {
			len = 0;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setLen(int len) {
			this.len = len;
		}

		public int getLen() {
			return this.len;}

		public void addLast(T data) {
			Nodo <T> newNodo = new Nodo <T>();
			newNodo.setData(data);
			if(this.first ==null) {
				this.setFirst(newNodo);
				len += 1;}
			else {
				Nodo <T> aux = this.getFirst();
				while (aux.getNext()!= null) {
					aux = aux.getNext();}
				aux.setNext(newNodo);
				len+=1;

			}
		}

			public void addLast(int x,int y,int peso) {
				Nodo <T> newNodo = new Nodo <T>(x,y,peso);
				
				if(this.first ==null) {
					this.setFirst(newNodo);
					len += 1;}
				else {
					Nodo <T> aux = this.getFirst();
					while (aux.getNext()!= null) {
						aux = aux.getNext();}
					aux.setNext(newNodo);
					len+=1;

				}
		

			

			if(this.getFirst() == null) {

				this.setFirst(newNodo);
				len += 1;}
			else {
				Nodo <T> aux = this.getFirst();
				while (aux.getNext()!= null) {
					aux = aux.getNext();}
				aux.setNext(newNodo);
				len+=1;

			}

		}
		
		
		public void deleteLast() {
			Nodo<T> aux = new Nodo<T>();
			aux = getFirst();

			if(this.getFirst()==null || len == 1 ) {

				setFirst(null);
			}
			else {
				while(aux.getNext().getNext()!=null){
					aux = aux.getNext();
				}
			aux.setNext(null);
			}
			len--;
		}
		
		public void print() {
			Nodo aux = (Nodo) this.getFirst();
			while (aux != null) {
				if(aux.getNext()!=null) {
					System.out.print(aux.getData()+",");
				}
				else {
					System.out.println(aux.getData());
				}
				aux = aux.getNext();
			}
				
			
		}

		public Nodo <T> getFirst() {
			return first;
		}

		public void setFirst(Nodo <T> first) {
			this.first = first;
		}
		public void delete(String letra) {
			Nodo aux =  this.first;
			while(aux.getNext() != null) {
				if(aux.getNext().getData() == letra ) {
					Nodo next = aux.getNext().getNext();
					aux.setNext(next);
					break;
					
				}else {
					aux = aux.getNext();
				}
				
			}
		}


}

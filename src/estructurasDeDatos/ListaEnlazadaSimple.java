package estructurasDeDatos;

import componentes.Avion;

public class ListaEnlazadaSimple <T> implements java.io.Serializable{
	private int len;
	private Nodo <T> first;

	public ListaEnlazadaSimple() {
		len = 0;
		setFirst(null);}

	public boolean isEmpty() {
		return this.getFirst() == null; }

	public int getLen() {
		return this.len;}

	public void addLast(T data) {
		Nodo <T> newNodo = new Nodo <T>();
		newNodo.setData(data);
		if(isEmpty()) {
			this.first = newNodo;
			len += 1;}
		else {
			Nodo <T> aux = this.first;
			while (aux.getNext()!= null) {
				aux = aux.getNext();
				}
			aux.setNext(newNodo);
			len+=1;
		}
	}
	
	public Nodo <T> getFirst() {
		return first;
	}

	public void setFirst(Nodo <T> first) {
		this.first = first;
	}
	
	public void delete(Avion airplane) {
		Nodo<Avion> aux = (Nodo<Avion>) this.first;
		while(aux.getNext() != null) {
			if(aux.getNext().getData() == airplane) {
				Nodo next = aux.getNext().getNext();
				aux.setNext(next);
				len--;
				break;
				
			}else {
				aux = aux.getNext();
			}
			
		}
	}
}


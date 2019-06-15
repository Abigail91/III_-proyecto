package estructurasDeDatos;

public class Nodo <T> implements java.io.Serializable{
	/**
	 * Atributos de la clase Nodo
	 */
	private T data;
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

	private Nodo<T> next;
	private int pos_x;
	private int pos_y;
	private int peso;
	
	/**
	 * Constructor de la clase Nodo que 
	 * inicializa los atributos en nulo
	 */
	public Nodo() {
		this.data = null;
		this.next = null;
		
	}
	public Nodo(int x,int y,int peso) {
		this.data = null;
		this.next = null;
		this.pos_x = x;
		this.pos_y = y;
		this.peso =peso;
	}
	
	/**
	 * Getter del atributo data
	 * @return el elemento dentro del nodo.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter del atributo data
	 * @param el elemento que se desea ingresar en el nodo
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Getter del atributo next
	 * @return el nodo que se encuentra contiguo al actual
	 */
	public Nodo<T> getNext() {
		return next;
	}

	/**
	 * Setter del atributo next
	 * @param el nodo que estará contiguo al actual
	 */
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}

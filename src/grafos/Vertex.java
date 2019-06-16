package grafos;

public class Vertex {
	final private String id;
	final private String name;
	final private int x;
	final private int y;
	final private int peso;

	/**
	 * Constructor de la clase vertice
	 * @param id
	 * @param name
	 * @param lat
	 * @param lon
	 */
	public Vertex(String id, String name, int x, int y,int peso) {
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.peso = peso;
	}
	public int getPeso() {
		return peso;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
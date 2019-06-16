package grafos;

import java.util.ArrayList;
import java.util.List;

import interfaz.Mapa;

public class Graph {
    private ArrayList<Vertex> vertexes;
    private ArrayList<Edge> edges;


    public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public Graph() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Obtiene los vértices del grafo
     * @return
     */
    public ArrayList<Vertex> getVertexes() {
        return vertexes;
    }
    
    /**
     * Obtiene las aristas del grafo
     * @return
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
    
    /**
     * Genera lugar aleatorios a lo largo de Cartago con peso en aristas
     */
    public void generateRandomPlaces() {
    	vertexes = new ArrayList<Vertex>();
    	edges = new ArrayList<Edge>();
    	
    	for(int i = 1; i<10;i++) {
			Vertex location = new Vertex("Node_"+i, "Node_"+i, Mapa.nodos.get(i).getPos_x(), Mapa.nodos.get(i).getPos_y(),Mapa.nodos.get(i).getPeso());
			vertexes.add(location);
		}
    	Vertex Salida = new Vertex("Salida", "Node_Salida: " ,10, 72,1);
    	vertexes.add(Salida);
    	
    	for(int i=0; i<20; i++) {
    		int random = (int) (Math.random() *9);
			int random2 = (int) (Math.random() *9 );
    		addLane("Edge_"+ i, random, random2, vertexes,edges);
    	}
    	
    }
    
    /**
     * Facilita la creación de aristas
     * @param laneId
     * @param sourceLocNo
     * @param destLocNo
     * @param duration
     * @param nodes
     * @param edges
     */
    public static void addLane(String laneId, int sourceLocNo, int destLocNo, List<Vertex> vertex , List<Edge> edges) {
    	int cambio_y=Math.abs((int) (vertex.get(sourceLocNo).getY()-vertex.get(destLocNo).getY()));
    	int cambio_x=Math.abs((int) (vertex.get(sourceLocNo).getX()-vertex.get(destLocNo).getX()));
    	double suma_cuadrados = Math.pow(cambio_y, 2)+Math.pow(cambio_x, 2);
    	int peso =  (int) Math.sqrt(suma_cuadrados);
    	if (vertex.get(destLocNo).getPeso() == 0) {
    		peso+= 500;
    	}else {
    		if(vertex.get(destLocNo).getPeso() == vertex.get(sourceLocNo).getPeso()) {
        		peso+= 100;
        	}else {
        		peso+= 300;
        	}
    	}
		Edge lane = new Edge(laneId,vertex.get(sourceLocNo), vertex.get(destLocNo), peso/2 );
		edges.add(lane);
	}
    
    @Override
	public String toString() {
		return vertexes.toString() + edges.toString();
	}
    
    
    

}
 
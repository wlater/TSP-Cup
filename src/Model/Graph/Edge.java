package Model.Graph;

public class Edge {

    public int id;
    public int value;  //Peso da aresta
    public Vertex backVertex;
    public Vertex nextVertex;

    public Edge(Vertex backVertex, Vertex nextVertex, int value) {
        this.backVertex = backVertex;   //anterior
        this.nextVertex = nextVertex;   //proximo
        this.value = value;
        this.backVertex.add(nextVertex);
        this.nextVertex.add(backVertex);
    }

}

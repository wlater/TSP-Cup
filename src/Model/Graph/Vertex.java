package Model.Graph;
import java.util.LinkedList;

public class Vertex {

    public int id;
    public String getLabel;
    protected LinkedList<Vertex> listVertex;

    public Vertex(int id) {
        this.id = id;
        this.getLabel = "Vertice nao rotulado";
    }

    //Construtor vertice com rotulo
    public Vertex(int id, String label) {
        this(id);
        this.getLabel = label;
        this.listVertex = new LinkedList<>();
    }

    public void add(Vertex vertex) {
        if (!listVertex.contains(vertex)) {
            listVertex.add(vertex);
        }
    }

}

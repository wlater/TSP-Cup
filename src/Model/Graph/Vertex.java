
package Model.Graph;

public class Vertex {
    public int id;
    public String getLabel;

    public Vertex(int id) {
        this.id = id;
        this.getLabel = "Vertice nao rotulado";
    }

    //Construtor vertice com rotulo
    public Vertex(int id, String label) {
        this(id);
        this.getLabel = label;
    }
    
}

package Model.Graph;

import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> listVertex;
    ArrayList<Edge> listEdge;

    public Graph() {
        listVertex = new ArrayList<>();
        listEdge = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {

        //Se vertice nao estiver na lista, add
        if (!listVertex.contains(vertex)) {
            listVertex.add(vertex);
        }

    }

    public void addEdge(Edge edge) {

        //Se vertice nao estiver na lista, add
        if (!listEdge.isEmpty()) {
            if (!listVertex.contains(edge)) {
                int i = 0;
                while (edge.value > listEdge.get(i).value) { i++; }
                listEdge.add(i, edge);
            }
        }
    }

    public void showMatrix() {
    }

}

package Model.Graph;

import Model.node.City_node;

public class Edge {

    public int id;
    public int value;  //Peso da aresta
    public City_node nodeA;
    public City_node nodeB;

    public Edge(City_node nodeA, City_node nodeB, int value) {
        this.nodeA = nodeA;   //anterior
        this.nodeA = nodeB;   //proximo
        this.value = value;

    }

}

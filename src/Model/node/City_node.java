package Model.node;

import Model.Graph.Adjacencia;
import java.util.ArrayList;

public class City_node {

    public int nodeID, nodeX, nodeY;
    public ArrayList<Adjacencia> listaAdjacencia;

    public City_node(int nodeID, int nodeX, int nodeY) {
        this.nodeX = nodeX;
        this.nodeY = nodeY;
        this.nodeID = nodeID;
        listaAdjacencia = new ArrayList<>();
    }

    public double distancia(City_node nodeB) {

        int x0 = this.nodeX;
        int y0 = this.nodeY;

        int x1 = nodeB.nodeX;
        int y1 = nodeB.nodeY;

        double p = (float) Math.pow(x1 - x0, 2);    //(x1 - x )²
        double q = (float) Math.pow(y1 - y0, 2);    //(y1 - y )²

        double dist = (float) Math.pow(p + q, 0.5);

        return dist;

    }

    public void addAdjacencia(City_node node, double valor){
        
        if(!listaAdjacencia.contains(node)){
            this.listaAdjacencia.add(new Adjacencia(node, valor));
            
        }
    }
    
}


package Model.Graph;

import Model.node.City_node;

public class Adjacencia {
    City_node node;
    double disttance;
    
    public Adjacencia(City_node node, double distance){
        this.node = node;
        this.disttance = distance;
    }
}

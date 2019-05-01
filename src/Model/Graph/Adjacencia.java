
package Model.Graph;

import Model.node.City_node;

public class Adjacencia {
    public City_node node;
    public double distance;
    
    public Adjacencia(City_node node, double distance){
        this.node = node;
        this.distance = distance;
    }
}

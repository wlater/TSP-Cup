package Model.node;

public class City_node {

    public int nodeID, nodeX, nodeY;

    public City_node(int nodeID, int nodeX, int nodeY) {
        //super();
        this.nodeX = nodeX;
        this.nodeY = nodeY;
        this.nodeID = nodeID;
    }
    
        public double distancia(City_node nodeB){
        
        int x0 = this.nodeX;
        int y0 = this.nodeY;
        
        int x1 = nodeB.nodeX;
        int y1 = nodeB.nodeY;
        
        double p = (float) Math.pow(x1 - x0, 0.5);
        double q = (float) Math.pow(y1 - y0, 0.5);
        
        double dist = (float) Math.pow(p + q, 0.5);
        
        return dist;
        
    }
    
}

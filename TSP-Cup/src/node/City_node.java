package node;

public class City_node {
	
	protected int nodeID, nodeX, nodeY;

	public City_node(int nodeX, int nodeY, int nodeID) {
		super();
		this.nodeX = nodeX;
		this.nodeY = nodeY;
		this.nodeID = nodeID;
		   
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	public int getNodeX() {
		return nodeX;
	}

	public void setNodeX(int nodeX) {
		this.nodeX = nodeX;
	}

	public int getNodeY() {
		return nodeY;
	}

	public void setNodeY(int nodeY) {
		this.nodeY = nodeY;
	}


}

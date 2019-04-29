package Model.Graph;

import java.util.ArrayList;

public class Graph {

    public int edgeSum;
    ArrayList<Vertex> listVertex;
    ArrayList<Edge> listEdge;
    protected int aux = 0;
	ArrayList<Edge> bestEdges;

    public Graph() {
        listVertex = new ArrayList<>();
        listEdge = new ArrayList<>();
        bestEdges = new ArrayList<>();
        
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
    
    public ArrayList<City_node> BestRoute(ArrayList<City_node> nodesList) {  						  
		for (int i=0, j=aux  ; i < nodesList.size()-1; i++) { 			   //pega a lista de edges ou caminhos que foi inflada na classe
		   for (int k = i; k < nodesList.size(); k++){ 				       //e para cada nó compara o caminho do mesmo com todos os outros 
			  if(listEdge.get(j).value == nodesList.get(k).value) {}
			  else if(listEdge.get(j).value < nodesList.get(k).value) {	   //caminhos que ele faz do array ate achar a menor distancia enntre ele e os outros nós, 
		    	  bestEdges.add(i, nodesList.get(i));					   //ele então começa a fazer o mesmo para o no que foi achado no primeiro laço da 
		      }else {													   //busca até buscar em todos
		    	  bestEdges.add(i, nodesList.get(k));
		      }
	    	aux=k;  
		   }
    	}
    	return bestEdges;
    }
    
    public boolean Validate(ArrayList<City_node> edgeList, int bestSol) {  //recebe uma lista de edges e a solução otima
    	boolean decSol = false;
    	
    	for(Edge aux : edgeList) {					 				  //percorre todas as edges da lista
    		edgeSum += aux.value;				 				  	  //faz o somatorio dos values de todas as edges
    		
    	}
    	
    	if(edgeSum==bestSol) {return decSol = true;} 				  //testa se o valor final bate com a solução otima e retona true caso seja.
    	else {return decSol;}
    }

}

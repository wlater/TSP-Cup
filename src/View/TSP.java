package View;

import Heuristicas.*;
import Infra.Loader;
import Model.Graph.Adjacencia;
import Model.node.City_node;
import Ordenation_Algorithms.MergeSortNodes;

public class TSP {

    public static void main(String args[]) {

        Loader loader = new Loader();

        City_node[] nodes = loader.loaderCoord("tsp2");     //Lista de nodes
        //showNodes(nodes);

        System.out.println("nodes " + nodes.length);

        //Insere as adjacencias em cada node
        for (int i = 0; i < nodes.length - 1; i++) {
            for (int j = i + 1; j < nodes.length; j++) {
                double distance = nodes[i].distancia(nodes[j]);
                nodes[i].listaAdjacencia.add(new Adjacencia(nodes[j], distance));
                nodes[j].listaAdjacencia.add(new Adjacencia(nodes[i], distance));
            }
        }

        //VND VND = new VND();
        Heuristica heuristica = new VND();

        City_node[] s = heuristica.solucao(nodes);
        showNodes(s);
       // verificaRepetidos(s);

    }

    public static void showNodes(City_node[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            System.err.println(nodes[i].nodeID + "\t" + nodes[i].nodeX + "\t" + nodes[i].nodeY);
        }
    }
    
    
    //Verifica a solucao em busca de nodes repetidos
    public static void verificaRepetidos(City_node[] nodes){
        
        //ordena os nodes
        MergeSortNodes sort = new MergeSortNodes();
        sort.sort(nodes);
        
        for (int i = 1; i < nodes.length ; i++){
            if(nodes[i] == nodes[i-1])
                System.err.println("Nodes Repetidos: " + nodes[i].nodeID + "\t" +  nodes[i- 1].nodeID);
        }
    }

    
    
    /*
    public ArrayList<City_node> BestRouteRandom(ArrayList<City_node> nodesList, int iterMax) {
        int iter = 0;
        Random rand = new Random();

        for (int i=0; i < nodesList.size()-1; i++) { 
            Adjacencia aux = nodesList.get(i).listaAdjacencia.get(rand.nextInt(nodesList.size()-1));

            while(iter < iterMax) {
                iter++;
                City_node auxRand = nodesList.get(rand.nextInt(nodesList.size()-1));

                if(nodesList.get(i).distancia(auxRand) < aux.distance) {
                      nodesList.add(i, auxRand);
                }

              }
        }
        return nodesList;

    }
    */
}

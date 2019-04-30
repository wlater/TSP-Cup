package View;

import Heuristicas.*;
import Infra.Loader;
import Model.Graph.Adjacencia;
import Model.node.City_node;

public class TSP {

    public static void main(String args[]) {

        Loader loader = new Loader();
        
        City_node[] nodes = loader.loaderCoord("tsp2");     //Lista de nodes
        //showNodes(nodes);

        //Insere as adjacencias em cada node
        for (int i = 0; i < nodes.length - 1; i++) {
            for (int j = i + 1; j < nodes.length; j++) {
                double distance = nodes[i].distancia(nodes[j]);
                nodes[i].listaAdjacencia.add(new Adjacencia(nodes[j], distance));
                nodes[j].listaAdjacencia.add(new Adjacencia(nodes[i], distance));
            }
        }

        
        Heuristica heuristica = new Construtiva();
        heuristica.solucao(nodes);

        
    }

    public static void showNodes(City_node[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            System.err.println(nodes[i].nodeID + "\t" + nodes[i].nodeX + "\t" + nodes[i].nodeY);
        }
    }

}

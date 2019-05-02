package View;

import Heuristicas.*;
import Infra.Loader;
import Model.Graph.Adjacencia;
import Model.node.City_node;
import Ordenation_Algorithms.MergeSortNodes;

public class TSP {

    public static void main(String args[]) {

        try {

            Loader loader = new Loader();

            City_node[] nodes = loader.loaderCoord("tsp2");     //Lista de nodes
            City_node[] copyNodes = new City_node[6];

//------------- copia as 10 primeira posicoes do vetor de nodes ----------------
            copyNodes(copyNodes, nodes);
            //nodes = copyNodes;

            System.err.println("solucao Original: " + new VND().calcSolucao(nodes));

            insereAdjacencia(nodes);

            Heuristica heuristica;// = new Construtiva();
            City_node[] solucao;// = heuristica.solucao(nodes);

            long tInicial = System.currentTimeMillis();

            heuristica = new VND();
            solucao = heuristica.solucao(nodes);

            System.out.println("Custo de tempo: \t" + ((System.currentTimeMillis() - tInicial) / 1000 / 60) + "min");
            System.err.println("A solucao é: \t" + new VND().calcSolucao(solucao));
            showNodes(solucao);

        } catch (Exception e) {
        }

    }

    public static void showAdjacencia(City_node[] copyNodes) {
        try {
            for (int i = 0; i < copyNodes.length; i++) {
                Thread.sleep(1000);
                System.out.print(copyNodes[i].nodeID + " -> \t");
                for (int j = 0; j < copyNodes[i].listaAdjacencia.size(); j++) {
                    System.out.printf("%.1f \t", copyNodes[i].listaAdjacencia.get(j).distance);
                    //System.out.printf("%.1f \t", copyNodes[i].listaAdjacencia.get(j).node.nodeID);
                }
                System.err.println("\n");
            }
        } catch (Exception e) {
        }
    }

    public static void showNodes(City_node[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            System.err.println(nodes[i].nodeID + "\t" + nodes[i].nodeX + "\t" + nodes[i].nodeY);
        }
    }

    //Verifica a solucao em busca de nodes repetidos
    public static void verificaRepetidos(City_node[] nodes) {

        //ordena os nodes
        MergeSortNodes sort = new MergeSortNodes();
        sort.sort(nodes);

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] == nodes[i - 1]) {
                System.err.println("Nodes Repetidos: " + nodes[i].nodeID + "\t" + nodes[i - 1].nodeID);
            }
        }
    }

//--------------    Insere as adjacencias em cada node  -------------------------------------
    public static void insereAdjacencia(City_node[] nodes) {
        for (int i = 0; i < nodes.length - 1; i++) {
            for (int j = i + 1; j < nodes.length; j++) {
                double distance = nodes[i].distancia(nodes[j]);
                nodes[i].listaAdjacencia.add(new Adjacencia(nodes[j], distance));
                nodes[j].listaAdjacencia.add(new Adjacencia(nodes[i], distance));
            }
        }
    }

    public static void copyNodes(City_node[] copyNodes, City_node[] nodes) {
        for (int i = 0; i < copyNodes.length; i++) {
            copyNodes[i] = nodes[i];
        }
    }

}

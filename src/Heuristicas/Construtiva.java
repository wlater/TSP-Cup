package Heuristicas;

import Model.Graph.Adjacencia;
import Model.node.City_node;
import Ordenation_Algorithms.MergeSort;
import Ordenation_Algorithms.Sort;

public class Construtiva implements Heuristica {

    @Override
    public City_node[] solucao(City_node[] nodes) {

        try {

            //Vetor com a solucao
            City_node[] solucao = new City_node[nodes.length + 1];

            //ordena lista de adjacencia de todos os nodes
            ordena(nodes);

            //showAdjacencias(nodes, 450);
            City_node proxNode;
            proxNode = nodes[0];
            proxNode.visitado = true;
            solucao[0] = proxNode;

            int i;

            for (i = 1; i < nodes.length ; i++) {

                int j = 0;

                try {

                    while (proxNode.visitado) {
                        proxNode = nodes[proxNode.nodeID].listaAdjacencia.get(j).node;
                        j++;
                    }

                } catch (Exception er) {
                    System.err.println("falha ao atribuir proximo node");

                }
                //System.out.println("j = " + j);
                proxNode.visitado = true;
                solucao[i] = proxNode;

            }
            solucao[i] = nodes[0];

            return solucao;
        } catch (Exception e) {
            System.out.println("falha na Heuristica construtiva");
        }
        return null;
    }

    //passa em cada node e ordena sua lista de adjacencia
    private void ordena(City_node[] nodes) {

        Sort sort = new MergeSort();

        for (int k = 0; k < nodes.length; k++) {
            //Obeter a lista de adjacencia dos nodes
            Adjacencia[] lista = new Adjacencia[nodes[k].listaAdjacencia.size()];

            //passa os valores do arraylist para o array de adjacencias
            for (int i = 0; i < lista.length; i++) {
                lista[i] = nodes[k].listaAdjacencia.get(i);
            }

            //Ordena a lista de adjacencias
            sort.sort(lista);

            //Insere os valores ordenados no arrayList do node
            nodes[k].listaAdjacencia.clear();   //Limpa a lista antiga
            for (int i = 0; i < lista.length; i++) {
                nodes[k].listaAdjacencia.add(lista[i]);
            }
        }
    }

    private void showAdjacencias(City_node[] nodes, int id) {
        //Exibe a lista de adjacencia de um determinado node
        for (int i = 0; i < nodes[id].listaAdjacencia.size(); i++) {
            System.out.print(nodes[id].listaAdjacencia.get(i).node.nodeID + "\t");
            System.out.println(nodes[id].listaAdjacencia.get(i).distance);
        }
    }

}

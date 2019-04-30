package Heuristicas;

import Model.Graph.Adjacencia;
import Model.node.City_node;
import Ordenation_Algorithms.MergeSort;
import Ordenation_Algorithms.Sort;

public class Construtiva implements Heuristica {

    @Override
    public City_node[] solucao(City_node[] nodes) {

        //Vetor com a solucao
        City_node[] solucao = new City_node[nodes.length + 1];
        
        ordena(nodes);
        
        int i;
        for(i = 0; i < 10; i++){
            //Insere o node com a menor distancia
            solucao[i] = nodes[i].listaAdjacencia.get(0).node;
            System.err.println(solucao[i].nodeID + "\t" + solucao[i].nodeX + "\t" + solucao[i].nodeY );
        }
        
       
        
        return solucao;
        
    }

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
}

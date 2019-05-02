package Heuristicas;

import Model.node.City_node;

public class VND implements Heuristica {

    @Override
    public City_node[] solucao(City_node[] nodes) {
        City_node[] solucao;

        solucao = DoisOpt(nodes);

        return solucao;
    }

    
    
    public City_node[] Swap(City_node[] nodesList) {

        //Inicialmente a melhor solucao que temos eh a do vetor original
        double melhorSolucao = calcSolucao(nodesList);
        double tmpSolucao;
        City_node[] tmp;
        //Criado o vetor solucao para que o nodesList nao seja alterado
        City_node[] solucao = nodesList;

        for (int i = 0; i < solucao.length; i++) {
            for (int j = i + 1; j < solucao.length; j++) {
                tmp = trocaPosicao(i, j, solucao);
                tmpSolucao = calcSolucao(tmp);
                if (tmpSolucao < melhorSolucao) {
                    melhorSolucao = tmpSolucao;
                    solucao = tmp;
                }
            }
        }

        return solucao;
    }

    public City_node[] DoisOpt(City_node[] nodesList) {

        //Inicialmente a melhor solucao que temos eh a do vetor original
        double melhorSolucao = calcSolucao(nodesList);
        double tmpSolucao;
        City_node[] tmp;
        //Criado o vetor solucao para que o nodesList nao seja alterado
        City_node[] solucao = nodesList;
        
        
        for(int inicio = 0; inicio < solucao.length; inicio++){
            
            for (int fim = inicio + 1; fim < solucao.length; fim++){
                
                tmp = invertaVetor(inicio, fim, solucao);
                tmpSolucao = calcSolucao(nodesList);
                
                if (tmpSolucao < melhorSolucao) {
                    melhorSolucao = tmpSolucao;
                    solucao = tmp;
                }    
            }
        }
        
        return solucao;
    }

    //Calcula todas as distancias e retorna distancia total
    public double calcSolucao(City_node[] nodesList) {

        double totalPath = 0;

        try {

            int i;
            for (i = 1; i < nodesList.length; i++) {
                totalPath += nodesList[i].distancia(nodesList[i - 1]);
            }
            totalPath += nodesList[i - 1].distancia(nodesList[0]);
            return totalPath;

        } catch (Exception e) {
            System.err.println("Problema na funcao Distance do VND");
        }

        return 0.0;
    }

    private City_node[] trocaPosicao(int a, int b, City_node[] nodesList) {

        City_node[] tmp = nodesList.clone();        //Array temporario para o retorno

        City_node aux = tmp[a];                     //**********************
        tmp[a] = tmp[b];                            //Troca posicao dos nodes
        tmp[b] = aux;                               //**********************

        return tmp;
    }

    private City_node[] invertaVetor(int inicio, int fim, City_node[] solucao){

        City_node[] tmp = solucao.clone();
        int cont = inicio;

        for(int i = fim ; i >= inicio; i--){
            tmp[cont] = solucao[i];
            cont++;
        }

        return tmp;
    }

}

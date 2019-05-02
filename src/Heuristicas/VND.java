package Heuristicas;
import Model.node.City_node;

public class VND implements Heuristica {

    @Override
    public City_node[] solucao(City_node[] nodes) {
        City_node[] solucao;

        solucao = Swap(nodes);

        return solucao;
    }

    public City_node[] Swap(City_node[] nodesList) {
        
        //Inicialmente a melhor solucao que temos eh a do vetor original
        double melhorSolucao = calcSolucao(nodesList);
        double tmpSolucao;
        City_node[] tmp;
        //Criado o vetor solucao para que o nodesList nao seja alterado
        City_node[] solucao = nodesList;
        
        for(int i = 0; i < solucao.length; i++){
            //System.out.println("i");
            for(int j = i + 1; j < solucao.length; j++){
                tmp = trocaPosicao(i, j, solucao);
                tmpSolucao = calcSolucao(tmp);
                if(tmpSolucao < melhorSolucao){
                    //System.out.println("Achei melhor solucao hahaha");
                    melhorSolucao = tmpSolucao;
                    solucao = tmp;
                }
            }
        }
        
        return solucao;
    }

    public City_node[] DoisOpt(City_node[] nodesList) {
        boolean sair = false;
        City_node[] iniSol = nodesList, bestSol = nodesList;
        double iniDist = calcSolucao(iniSol);
        City_node aux;
        int a = 0, b = nodesList.length - 1;

        while (!sair) {
            for (int i = a, j = b; i <= nodesList.length / 2; i++, j--) {
                aux = nodesList[i + 1];
                nodesList[i + 1] = nodesList[j - 1];
                nodesList[j - 1] = aux;

            }
            if (calcSolucao(nodesList) < iniDist) {
                iniDist = calcSolucao(nodesList);
                bestSol = nodesList.clone();
                nodesList = iniSol.clone();
                a++;
                b--;

            } else {
                //bestSol = Swap(nodesList);
                sair = true;

            }
        }

        return bestSol;
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
            
            
        } catch (Exception e) { System.err.println("Problema na funcao Distance do VND"); }
        
        return 0.0;
    }

    private City_node[] trocaPosicao(int a, int b, City_node[] nodesList) {
        
        City_node[] tmp = nodesList.clone();        //Array temporario para o retorno
        
        City_node aux = tmp[a];                     //**********************
        tmp[a] = tmp[b];                            //Troca posicao dos nodes
        tmp[b] = aux;                               //**********************
        
        return tmp;
    }

}

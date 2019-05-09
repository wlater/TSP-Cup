package Heuristicas;

public class Construtiva {

    public int[] solucao(int[][] matriz, int node) {

        /*
        *   Definido um node, a solucao construida
        *   sera todas as adjacencias a ele
        */
        
        int solucao[] = new int[matriz.length + 1];
        int i = 1, cont;
        
        //O inicio da solucao eh o node de partida
        solucao[0] = node;
        
        for (cont = 0; cont < solucao.length - 1; cont++) {
            solucao[i] = cont;
            if( cont != node ) i++;
        }

        solucao[i] = node;
        
        
        return solucao;
    }

}

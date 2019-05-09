/*Classe destinada a realizar operacoes com nodes*/
package Heuristicas;

public class Operacoes {

    public static double calcSolucao(int[] solucao, int[][] matriz) {

        double totalPath = 0;

        /**
        *********************************
        * solucao = [ 2 | 4 | 1 | 3 | 2 ]
        *
        * Matriz:
        *
        *      1   2   3   4
        * 1    0   5   6   7
        * 2    5   0   4   2
        * 3    6   4   0   9
        * 4    7   2   9   0
        *
        * totalPath = 2 + 7 + 6 + 4
        ********************************* */
        for (int i = 1; i < solucao.length; i++) {
            
            int node = solucao[i - 1];      //o node de partida (A)
            int adjacente = solucao[i];     //O node adjacente (B)
            
            totalPath += matriz[node][adjacente];   //Distancia de A até B
        }
        return totalPath;
    }

    public static void exibeSolucao(int[] solucao) {
        for (int i = 0; i < solucao.length; i++) {
            System.out.print(solucao[i] + "\t");
        }
        System.out.println("");
    }

}

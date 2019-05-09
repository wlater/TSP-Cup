package Heuristicas;

public class VND extends Operacoes {

    public int[] solucao(int[] nodes, int[][] matriz) {

        int[] solucao = nodes.clone();
        int[] tmp;


        double melhorSolucao = calcSolucao(solucao, matriz);    //melhor solucao inicialmente

        int k = 1;
        int r = 2;

        int cont = 0;

        /*
        *   Inicialmente realiza o Swap()
        *     Se a solucao encontrada for melhor: execute Swap() novamente
        *     Senão: execute DoisOpt()
        *     Se a solucao de DoisOpt() for melhor: execute Swap() novamente
        *   realize o processo ate que nao haja solucao melhor
        */

        while (k <= r) {
            cont++;

            if (k == 1) tmp = Swap(solucao, matriz);
            else tmp = DoisOpt(solucao, matriz);

            if (calcSolucao(tmp, matriz) < melhorSolucao) {
                solucao = tmp;
                melhorSolucao = calcSolucao(solucao, matriz);
                k = 1;            //executa o Swap() novamente
            } else {
                k++;              //  executa o DoisOpt()
            }
        }

        return solucao;
    }

    public int[] Swap(int[] nodesList, int[][] matriz) {

        //solucao eh um vetor que contem o "id" dos nodes
        double melhorSolucao = calcSolucao(nodesList, matriz);
        double tmpSolucao;

        int[] tmp;
        int[] solucao = nodesList.clone();

        for (int i = 0; i < solucao.length; i++) {
            for (int j = i + 1; j < solucao.length; j++) {
                tmp = trocaPosicao(i, j, solucao);
                tmpSolucao = calcSolucao(tmp, matriz);
                if (tmpSolucao < melhorSolucao) {
                    melhorSolucao = tmpSolucao;
                    solucao = tmp;
                }
            }
        }
        return solucao;
    }

    public int[] DoisOpt(int[] nodesList, int[][] matriz) {

        //Inicialmente a melhor solucao que temos eh a do vetor original
        double melhorSolucao = calcSolucao(nodesList, matriz);
        double tmpSolucao;
        int[] tmp;
        //Criado o vetor solucao para que o nodesList nao seja alterado
        int[] solucao = nodesList;

        for (int inicio = 0; inicio < solucao.length; inicio++) {

            for (int fim = inicio + 1; fim < solucao.length; fim++) {

                tmp = invertaVetor(inicio, fim, solucao);
                tmpSolucao = calcSolucao(nodesList, matriz);

                if (tmpSolucao < melhorSolucao) {
                    melhorSolucao = tmpSolucao;
                    solucao = tmp;
                }
            }
        }

        return solucao;
    }

    private int[] trocaPosicao(int a, int b, int[] nodesList) {

        int[] tmp = nodesList.clone();        //Array temporario para o retorno

        int aux = tmp[a];                     //**********************
        tmp[a] = tmp[b];                            //Troca posicao dos nodes
        tmp[b] = aux;                               //**********************

        return tmp;
    }

    private int[] invertaVetor(int inicio, int fim, int[] solucao) {

        int[] tmp = solucao.clone();
        int cont = inicio;

        for (int i = fim; i >= inicio; i--) {
            tmp[cont] = solucao[i];
            cont++;
        }

        return tmp;
    }
}

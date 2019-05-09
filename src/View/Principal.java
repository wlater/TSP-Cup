package View;

import Heuristicas.GRASP;
import Heuristicas.Operacoes;
import Infra.Loader;
import Model.Grafo;

public class Principal {

    public static void main(String args[]) {
        Loader loader = new Loader();
        String nomeArquivo = "bayg29";
        Grafo G = new Grafo(loader.loaderMatrix(nomeArquivo));

        int[] solucao;
        int[][] matrizAdjacencia = G.matriz;

        GRASP grasp = new GRASP();

        solucao = grasp.solucao(matrizAdjacencia, 0.5, 100);
        double valorHeuristicaAux = Operacoes.calcSolucao(solucao, matrizAdjacencia);
        System.out.println(valorHeuristicaAux);
/*
        double mediaSolucao = 0;
        double melhorValor = Integer.MAX_VALUE;
        double valorEncontrado;
        double mediaTempo = 0;
        double gap;
        double valorHeuristicaAux;
        double valorHeuristica = 0;

        long tInicial;
        long tFinal;

        Construtiva construtiva = new Construtiva();
        VND vnd = new VND();

        //***************   Construindo tabela de resultados
        int limite = 28;

        for (int i = 0; i < limite; i++) {

//***********************   CALCULA SOLUCAO   **********************************
            tInicial = System.currentTimeMillis();

            //Construindo a solucao
            solucao = construtiva.solucao(matrizAdjacencia, i);
            //valor da Heuristica Construtiva
            valorHeuristicaAux = Operacoes.calcSolucao(solucao, matrizAdjacencia);

            //melhorando a solucao
            solucao = vnd.solucao(solucao, G.matriz);

            tFinal = (System.currentTimeMillis() - tInicial) / 1000;

//------------------------------------------------------------------------------

            //Calculando a melhor solucao
            valorEncontrado = Operacoes.calcSolucao(solucao, matrizAdjacencia);

            //somatorio da melhor solucao
            mediaSolucao += valorEncontrado;

            //verificar o melhor valor
            if (valorEncontrado < melhorValor) {
                melhorValor = valorEncontrado;
                valorHeuristica = valorHeuristicaAux;
            }

            //somatorio dos tempos
            mediaTempo += tFinal;

        }

        mediaSolucao /= limite;   //calcula a media das solucoes encontradas
        mediaTempo /= limite;     //calcula a media do tempo de execucao
        gap = ((valorHeuristica - melhorValor) / melhorValor) * 100;

        System.out.print(nomeArquivo + "\t"
                + mediaSolucao + "\t"
                + melhorValor + "\t"
                + mediaTempo + "s\t");
        System.out.printf("%.2f \t\n" + limite, gap);
*/
    }

}

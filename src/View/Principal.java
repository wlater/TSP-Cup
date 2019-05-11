package View;

import Heuristicas.Construtiva;
import Heuristicas.GRASP;
import Heuristicas.Operacoes;
import Heuristicas.VND;
import Infra.Loader;
import Model.Grafo;

public class Principal {

    public static void main(String args[]) {

        /*
        testaHeuristica("bayg29");
        testaHeuristica("bays29");
        testaHeuristica("berlin52");
        testaHeuristica("bier127");
        testaHeuristica("brazil58");
        testaHeuristica("ch130");
        testaHeuristica("ch150");
        testaHeuristica("swiss42");
         */
        testeMetaHeuristica("bayg29");
        testeMetaHeuristica("bays29");
        testeMetaHeuristica("berlin52");
        testeMetaHeuristica("bier127");
        testeMetaHeuristica("brazil58");
        testeMetaHeuristica("ch130");
        testeMetaHeuristica("ch150");
        testeMetaHeuristica("swiss42");
    }

    public static void testaHeuristica(String nomeArquivo) {

        Loader load = new Loader();
        Grafo G = new Grafo(load.loaderMatrix(nomeArquivo));

        int[] solucao;
        int[][] matriz = G.matriz;

        double mediaSolucao = 0, melhorSolucao = Double.MAX_VALUE, mediaTempo = 0, gap;
        double solucaoAtual, valorHeuristica, melhorHC = 0;
        long tInicial, tFinal;

        Construtiva construtiva = new Construtiva();
        VND vnd = new VND();

        //***************   Construindo tabela de resultados
        int limite = matriz.length;   //numero de vezes q o algoritmo sera executado

        for (int i = 0; i < limite; i++) {

            /**
             * ********************************************************
             *
             * Constrói uma solução Verifica o valor desta solucao melhora esta
             * solucao ao final temos o tempo destas 03 operacoes
             *
             ******************************************************
             */
            tInicial = System.currentTimeMillis();

            //Construindo a solucao iniciando com o node i
            solucao = construtiva.solucao(matriz, i);

            //valor da Heuristica Construtiva
            valorHeuristica = Operacoes.calcSolucao(solucao, matriz);

            //melhorando a solucao
            solucao = vnd.solucao(solucao, G.matriz);

            tFinal = (System.currentTimeMillis() - tInicial);

            //Calculando a melhor solucao apos o vnd
            solucaoAtual = Operacoes.calcSolucao(solucao, matriz);

            //somatorio da melhor solucao
            mediaSolucao += solucaoAtual;

            //verificar o melhor valor
            if (solucaoAtual < melhorSolucao) {
                melhorSolucao = solucaoAtual;
                melhorHC = valorHeuristica;
            }

            //somatorio dos tempos
            mediaTempo += tFinal;

        }

        mediaSolucao /= limite;   //calcula a media das solucoes encontradas
        mediaTempo /= limite;     //calcula a media do tempo de execucao
        gap = ((melhorHC - melhorSolucao) / melhorSolucao) * 100;

        System.out.print(nomeArquivo + "\t");
        System.out.printf("%.2f \t", mediaSolucao);
        System.out.print(melhorSolucao + "\t");
        System.out.printf("%.2f ms\t", mediaTempo);
        System.out.printf("%.2f ", gap);
        System.out.print("%\t");
        System.out.println(limite);

    }

    public static void testeMetaHeuristica(String nomeArquivo) {

        Loader load = new Loader();
        Grafo G = new Grafo(load.loaderMatrix(nomeArquivo));

        int[] solucao;
        int[][] matriz = G.matriz;

        GRASP grasp = new GRASP();

        double mediaSolucao = 0, melhorSolucao = Double.MAX_VALUE, mediaTempo = 0, gap;
        double solucaoAtual, valorHeuristica, melhorHC = 0;
        long tInicial, tFinal;

        int limite = matriz.length ;
        int criterioParada = 100;
        double alpha = 0.8;

        for (int i = 1; i <= limite; i++) {

            solucao = grasp.solucao(matriz, 1/i, criterioParada);

            tInicial = System.currentTimeMillis();

            solucaoAtual = Operacoes.calcSolucao(solucao, matriz);
          
            tFinal = (long) System.currentTimeMillis() - tInicial;
            
            if (solucaoAtual < melhorSolucao) {
                melhorSolucao = solucaoAtual;
                alpha = 1/i;
            }

            mediaSolucao += solucaoAtual;
            mediaTempo += tFinal;

        }

        mediaSolucao /= limite;   //calcula a media das solucoes encontradas
        //mediaTempo /= limite;     //calcula a media do tempo de execucao
        gap = ((melhorHC - melhorSolucao) / melhorSolucao) * 100;

        System.out.print(nomeArquivo + "\t");
        System.out.printf("%.2f \t", mediaSolucao);
        System.out.print(melhorSolucao + "\t");
        System.out.printf("%.2f ms\t", mediaTempo);
        System.out.printf("%.2f ", gap);
        System.out.print("%\t");
        System.out.print(alpha + "%\t");
        System.out.println(limite);

    }

}

package Heuristicas;

import Ordenacao.MergeSort;
import java.util.Random;

public class GRASP extends Operacoes {

    public int[] solucao(int[][] matrizAdj, double alpha, int parada) {

        //alphaAtual = new Random().nextInt(listAlpha[Object]);
        //.
        //.
        //.
        //.
        //if(soluAtual < solucao){solucao = soluAtual; listAlpha.get(i).getWeight() += 1 //1 -> 10}
        //else{listAlpha.get(i).getWeight() -= 1}

        /*
         * ************************************************************
         *
         * alpha = variavel de aleatoriedade -> variacao = [0 - 1] onde 0
         * significa que eh completamente guloso e 1 significa que eh
         * completamente aleatorio
         *
         * parada eh o numero de iteracoes da metaHeuristica
         *
         * ************************************************************
         */
        double melhorSolucao = Double.MAX_VALUE;
        int[] solucao = null;
        int[] tmp;
        int[][] matriz = matrizAdj.clone();
        double valueTmp;

        for (int i = 0; i < parada; i++) {

            solucao = construcao_solucao(alpha, matriz);
            tmp = new VND().solucao(solucao, matriz);   // buscaLocal(solucao);
            valueTmp = calcSolucao(tmp, matriz);

            if (valueTmp < melhorSolucao) {
                solucao = tmp;
                melhorSolucao = valueTmp;
            }

        }

        return solucao;
    }

    private int[] construcao_solucao(double alpha, int[][] matrizAdj) {

        int[][] matriz = matrizAdj.clone();

        //Tamanho das listas
        int nCandidatos = matriz.length, lenSolucao = 0;
        int node, intervalo, n;

        int[] candidatos = new int[nCandidatos];      //Lista de nodes candidatos
        int[] solucao = new int[nCandidatos + 1];         //Solucao construida
        int[] vetorAux = new int[nCandidatos];

        iniciaVetor(candidatos);                      //inicia a LC
        try {

            /************************
            * LC  = [0  1  2  3  4  5]               // LC inicialmente
            * Sol = [2  0  0  0  0  0]               // add node inicial na solucao
            * LC  = [0  1 -1  3  4  5]               // Removendo node da LC
            ************************/

            node = new Random().nextInt(nCandidatos);  // nodeInicial = aleatorio
            node = candidatos[node];                // node = candidato 0
            solucao[lenSolucao] = node;             // node inicial
            lenSolucao++;                           // aumenta o tamanho do vetor solucao
            candidatos[node] = -1;                  // remove o node da LC
            nCandidatos--;                          // decrementa o tamanho da LC

            while (nCandidatos > 0) {

                //Recebe os nodes adjacentes ao node atual, e ordena pela distancia
                //vetor auxiliar guarda a referencia para o node a ser escolhido
                iniciaVetor(vetorAux);
                MergeSort.sort(vetorAux, matriz[node]);

                //intervalo entre 0 e (nCandidatos * alpha)
                intervalo = (int) ((nCandidatos - 1) * alpha);

                //n assume um valor aleatorio dentro do intervalo
                n = new Random().nextInt(intervalo + 1);

                //novo node sera escolhido aleatoriamente pelo "n"
                node = vetorAux[n];

                try {

                    //Se o node ja saiu da lista de candidatos
                    //Procure o proximo de forma gulosa
                    if (candidatos[node] == -1) {

                        // Percorrendo toda o vetor auxilar
                        // este vetor contem os nodes ordenados pela menor distancia
                        for (int k = 1; k < vetorAux.length; k++) {

                            int proxNode = vetorAux[k];

                            //Se proximo node estiver disponivel, coloque-o na solucao
                            if (candidatos[proxNode] != -1) {
                                node = proxNode;        // Atribui o proximo node
                                break;                  // sai do loop_for
                            }
                        }

                    }

                } catch (Exception err) {
                    System.err.println("Problemas ao encontrar node na LC");
                }

                node = candidatos[node];                    // node = candidato 0
                solucao[lenSolucao] = node;                 // node inicial
                lenSolucao++;                               // aumenta o tamanho do vetor solucao
                candidatos[node] = -1;                      // remove o node da LC
                nCandidatos--;                              // decrementa o tamanho da LC

            }

            //insere o primeiro node na  ultima posicao
            solucao[lenSolucao] = solucao[0];

        } catch (Exception err) {
            System.err.println("Erro na construcao do GRASP");
        }
        return solucao;
    }

    private void iniciaVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }
    }
}

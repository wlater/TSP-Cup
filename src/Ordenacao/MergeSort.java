package Ordenacao;

import java.util.ArrayList;

public class MergeSort {

    public  static void sort(int[] vetor, int[] distancia) {
        int inicio = 0;
        int fim = vetor.length - 1;
        mergeSort(inicio, fim, vetor, distancia);
    }

    private static void mergeSort(int inicio, int fim, int[]vetor, int[] distancia) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio, vetor, distancia);
            mergeSort(meio + 1, fim, vetor, distancia);
            merge(inicio, meio, fim, vetor, distancia);
        }

    }

    private  static void merge(int inicio, int meio, int fim, int[] vetor, int[] distancia) {

        int[] L = new int[meio - inicio + 1];
        int[] Laux = new int[meio - inicio + 1];
        //ArrayList<Integer> Laux = new ArrayList<>();//[meio - inicio + 1];
        int[] R = new int[fim - meio];
        int[] Raux = new int[fim - meio];
        //ArrayList<Integer> Raux = new ArrayList<>();

        int i, j;
        for (i = 0; i < L.length; i++) {
            L[i] = distancia[i + inicio];
            Laux[i] = vetor[i + inicio];
            //Laux.add(vetor.get(i + inicio));
        }

        for (i = 0; i < R.length; i++) {
            R[i] = distancia[i + meio + 1];
            Raux[i] = vetor[i + meio + 1];
            //Raux.add(vetor.get(i + meio + 1));
        }

        i = j = 0;

        for (int k = inicio; k <= fim; k++) {

            if (i >= L.length) {
                //vetor.add(k, Raux.get(j));
                //vetor.remove(k+1);
                vetor[k] = Raux[j];
                distancia[k] = R[j];
                j++;
            } else if (j >= R.length) {
                //vetor.add(k,Laux.get(i) );
                //vetor.remove(k+1);
                vetor[k] = Laux[i];
                distancia[k] = L[i];
                i++;
            } else {
                if (L[i] <= R[j]) {
                    //vetor.add(k,Laux.get(i) );
                    //vetor.remove(k+1);
                    vetor[k] = Laux[i];
                    distancia[k] = L[i];
                    i++;
                } else {
                    //vetor.add(k,Raux.get(j) );
                    //vetor.remove(k+1);
                    vetor[k] = Raux[j];
                    distancia[k] = R[j];
                    j++;
                }
            }

        }

    }

}

package Ordenation_Algorithms;

import Model.node.City_node;

public class MergeSortNodes {

    public void sort(City_node[] vetor) {
        int inicio = 0;
        int fim = vetor.length - 1;

        mergeSort(inicio, fim, vetor);
    }

    public void mergeSort(int inicio, int fim, City_node[] vetor) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio, vetor);
            mergeSort(meio + 1, fim, vetor);
            merge(inicio, meio, fim, vetor);
        }

    }

    public void merge(int inicio, int meio, int fim, City_node[] vetor) {

        City_node[] L = new City_node[meio - inicio + 1];
        City_node[] R = new City_node[fim - meio];

        int i, j;
        for (i = 0; i < L.length; i++) {
            L[i] = vetor[i + inicio];
        }

        for (i = 0; i < R.length; i++) {
            R[i] = vetor[i + meio + 1];
        }

        i = j = 0;

        for (int k = inicio; k <= fim; k++) {

            if (i >= L.length) {
                vetor[k] = R[j];
                j++;
            } else if (j >= R.length) {
                vetor[k] = L[i];
                i++;
            } else {
                if (L[i].nodeID <= R[j].nodeID) {
                    vetor[k] = L[i];
                    i++;
                } else {
                    vetor[k] = R[j];
                    j++;
                }
            }

        }

    }

}

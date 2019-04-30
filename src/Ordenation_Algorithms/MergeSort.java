package Ordenation_Algorithms;

import Model.Graph.Adjacencia;

public class MergeSort implements Sort {

    @Override
    public void sort(Adjacencia[] vetor) {
        int inicio = 0;
        int fim = vetor.length - 1;

        mergeSort(inicio, fim, vetor);
    }

    public void mergeSort(int inicio, int fim, Adjacencia[] vetor) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio, vetor);
            mergeSort(meio + 1, fim, vetor);
            merge(inicio, meio, fim, vetor);
        }

    }

    public void merge(int inicio, int meio, int fim, Adjacencia[] vetor) {

        Adjacencia[] L = new Adjacencia[meio - inicio + 1];
        Adjacencia[] R = new Adjacencia[fim - meio];

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
                if (L[i].disttance <= R[j].disttance) {
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

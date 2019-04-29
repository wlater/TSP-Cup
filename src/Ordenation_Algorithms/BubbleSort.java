

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class BubbleSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        bubbleSort(array);
        return array;
    }

    private void bubbleSort(int vetor[]) {

        int aux, inicio = 0, fim = vetor.length;

        for (int i = 0; i < fim; i++) {

            for (int j = 0; j < vetor.length - 1; j++) {

                if (vetor[j] > vetor[j + 1]) {

                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }
}

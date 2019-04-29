

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class ShakerSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        shakerSort(array);
        return array;
    }

    private void shakerSort(int vetor[]) {

        int aux, inicio = 0, fim = vetor.length - 1;
        boolean houveAlteracao = true;

        while (houveAlteracao == true && fim > inicio) {

            houveAlteracao = false;

            for (int j = inicio; j < fim; j++) {

                if (vetor[j] > vetor[j + 1]) {

                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    houveAlteracao = true;
                }
            }

            fim -= 1;

            for (int j = fim; j > inicio; j--) {

                if (vetor[j] < vetor[j - 1]) {

                    aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                    houveAlteracao = true;
                }
            }

            inicio += 1;
        }

    }

}




public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        mergeSort(array, 0, array.length);
        return array;
    }

    private void mergeSort(int[] vetor, int inicio, int fim) {

        fim -= (fim >= vetor.length) ? 1 : 0;

        if (inicio < fim) {
            int meio = (int) (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private void merge(int[] vetor, int inicio, int meio, int fim) {

        if ((vetor[inicio] > vetor[meio + 1]) && (fim - inicio) % 2 != 0) 
            troca(vetor, inicio, meio + 1);
        
        int i = fim - 1;
        int j = fim;

        for (int k = fim; k > 0; k--) {

            if (vetor[i] < vetor[k - 1]) {
                troca(vetor, i, k - 1);
                i--;
            }

            if (vetor[j] < vetor[j - 1]) {
                troca(vetor, j, j - 1);
                j--;
            }
        }
    }

    private void troca(int[] vetor, int i, int j) {

        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

}

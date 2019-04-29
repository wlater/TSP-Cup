package Ordenation_Algorithms;


import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSort implements Sort{

    @Override
    public double[] sort(double[] array) {
        try {
            quickSort(array);
        } catch (InterruptedException ex) {
            Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
    private void quickSort(double[] array) throws InterruptedException {
        partition(array, 0, array.length);
    }
//**************************    QuickSort  **************************
    
    private void partition(double[] array, int inicio, int tamanho) {

        int posPivot = inicio + tamanho - 1;

        if (!valido(array, posPivot)) 
            return;
        
        double pivot = array[posPivot];
        int fim = inicio + tamanho - 2;

        if (tamanho <= 2) {
            if (array[inicio] > pivot) 
                troca(array, inicio, posPivot);
            return;
        }

        while (inicio < fim) {
            inicio = dir(array, inicio, pivot);
            fim = esq(array, fim, pivot);

            if (inicio < fim)
                troca(array, inicio, fim);
        }
        troca(array, inicio, posPivot);

        partition(array, 0, inicio);
        partition(array, inicio + 1, tamanho - inicio - 1);
    }

    private int dir(double[] array, int i, int pivot) {
        while (array[i] < pivot && i < array.length) {
            i++;
        }
        return i;
    }

    private int esq(double[] array, int i, int pivot) {
        while (array[i] >= pivot && i > 0) {
            i--;
        }
        return i;
    }

    private void troca(double[] array, int i, int j) {
        double aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public boolean valido(double[] array, int posPivot){
        return posPivot < 0 || posPivot > array.length;
    }
    
//**************************    Fim QuickSort   **************************
}




public class CoutingSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        countingSort(array);
        return array;
    }

    private void countingSort(int[] array) {

        int[] temp = new int[maiorNumero(array) + 1];
        int aux = array.length - 1;

        //contagem
        for (int i = 0; i < array.length; i++) {
            temp[array[i]]++;
        }

        //ordena
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] > 0) {
                array[aux] = i;
                temp[i]--;
                i++;
                aux--;
            }
        }
    }

    private int maiorNumero(int[] array) {

        int k = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > k) {
                k = array[i];
            }
        }
        return k;
    }

}

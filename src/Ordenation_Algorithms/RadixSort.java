


public class RadixSort implements Sort {

    @Override
    public int[] sort(int[] array) {

        //int[] v = {1995, 741, 258, 635};
        //int[] v = {9 ,8 ,7 ,6, 5,4,3,2,1,0};

        radixSort(array);

        return array;
    }

    private void radixSort(int[] array) {

        //A contagem nao passara de 9
        //Colunas de acordo com o nuumero de valores do vetor desordenado
        
        int[][] temp = new int[10][array.length + 1];
        int max = max(array);       //obtem o maior numero do array
        int aux, digit;

        for (int expoente = 1; max != 0; expoente++) {

            aux = array.length - 1;

            //Contagem
            for (int i = 0; i < array.length; i++) {

                //Obter o digito
                digit = getDigit(array[i], expoente);

                //Acessa posicao no array temporario
                temp[digit][0]++;

                //adiciona o valor na lista temporaria
                temp[digit][temp[digit][0]] = array[i];
            }

            //ordena
            for (int i = temp.length - 1; i >= 0; i--) {
                if (temp[i][0] > 0) {
                    array[aux] = temp[i][temp[i][0]];
                    temp[i][0]--;
                    i++;
                    aux--;
                }
            }
            max = keep(max);
        }

        //view(array);
    }

    //obtem unidades, dezenas, centenas ...
    private int getDigit(int number, int pow) {
        // retorna number % 10² ou number % 10³ / 10
        return (int) (number % Math.pow(10, pow) / Math.pow(10, pow - 1));
    }

    //remove o ultimo digito do maior numero
    private int keep(int max) {
        return max / 10;
    }

    //maior numero
    private int max(int[] array) {

        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }
    
    private void view(int[] array){
        
        for (int i = 0; i < array.length; i++) {
            System.err.print(array[i] + " ");
        }

    }

}

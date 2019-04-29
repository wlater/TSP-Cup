
import java.util.Random;

public class AlgoritmosOrdenacao {

    public static void main(String args[]) {

        int[] vetor = new int[5];

        vetor = numAleatorio(vetor);

        System.out.println("Vetor Desordenado");

        exibiVetor(vetor);

        System.out.println("\n\nVetor Ordenado");

        vetor = insertionSort(vetor);

        exibiVetor(vetor);
    }

    public static int[] numAleatorio(int vetor[]) {

        Random gerador = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = gerador.nextInt(99);
        }

        return vetor;
    }

    public static void exibiVetor(int vetor[]) {

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + "\t");
        }

    }

    public static int[] bubbleSort(int vetor[]) {

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

        return vetor;
    }

    public static int[] bubbleSortBooleano(int vetor[]) {

        int aux;
        boolean houveAlteracao = true;

        while (houveAlteracao == true) {

            houveAlteracao = false;

            for (int j = 0; j < vetor.length - 1; j++) {

                if (vetor[j] > vetor[j + 1]) {

                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    houveAlteracao = true;
                }
            }
        }

        return vetor;
    }

    public static int[] shakerSort(int vetor[]) {

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

        return vetor;
    }

    public static int[] selectionSort(int vetor[]) {

        int aux, x;
        String info;

        for (int i = 0; i < vetor.length - 1; i++) {

            aux = i;

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[j] < vetor[aux]) {
                    aux = j;
                }

                info = "\t MENOR NUMERO ENCONTRADO = " + vetor[aux];
            }

            x = vetor[aux];
            vetor[aux] = vetor[i];
            vetor[i] = x;

        }

        return vetor;
    }

    public static int[] insertionSort(int vetor[]) {

        int x, j;

        for (int i = 1; i < vetor.length; i++) {

            x = vetor[i];

            for (j = i - 1; j >= 0 && vetor[j] > x; j--) {
                vetor[j + 1] = vetor[j];
            }

            vetor[j + 1] = x;
        }

        return vetor;
    }

    public static int[] shellSort(int vetor[]) {

        int h = 4;

        while (h < vetor.length) {
            h = h * 3 + 1;
        }

        h /= 3;

        int elemento, posicaoAtual;

        while (h > 0) {

            for (int i = h; i < vetor.length; i++) {

                elemento = vetor[i];
                posicaoAtual = i;

                while (posicaoAtual >= h && vetor[posicaoAtual - h] > elemento) {
                    vetor[posicaoAtual] = vetor[posicaoAtual - h];
                    posicaoAtual -= h;
                }

                vetor[posicaoAtual] = elemento;
            }

            h /= 3;

        }

        return vetor;

    }

}

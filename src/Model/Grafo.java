package Model;

public class Grafo {

    public int[][] matriz;

    public Grafo(int matrix[][]) {
        this.matriz = matrix;
    }

    public void exibeMatriz() {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) 
                System.err.print(matriz[i][j] + "\t");
            System.err.println();
        }
    }

}

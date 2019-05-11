package Infra;

public class Loader {

    private final TXT loader;

    public Loader() {
        this.loader = TXT.getInstance();
        
    }

    public int[][] loaderMatrix(String arquivo) {

        int matrix[][];

        String diretorio = "instancias_teste/";
        String dados[] = loader.ler(diretorio + arquivo).split("\n");
        String aux[];

        int cont, len = 0;

        //********* Obtem o numero de nodes do arquivo
        for (cont = 0; !dados[cont].contains("EDGE_WEIGHT_SECTION"); cont++) {
            if (dados[cont].contains("DIMENSION:")) {
                String data[] = dados[cont].split(" ");
                len = Integer.parseInt(data[1]);
            }
        }

        cont++;
        matrix = new int[len][len];

        int i = 0, j;

        for (; cont < dados.length; cont++){

            dados[cont] = dados[cont].replaceAll("[\\s]+", " ");        //Troca todos os espacos vazios por apenas 1
            aux = dados[cont].split(" ");                               //quebra a string por espaco vazio

            j = 0;
            try {

                for (int k = 0; k < aux.length; k++) {

                    if (isNumber(aux[k])) {
                        matrix[i][j] = Integer.parseInt(aux[k]);
                        j++;
                    }
                }

            } catch (NumberFormatException er) { System.err.println("erro numerico na matrix"); }
              catch (Exception er) { System.err.println("erro na matrix"); }
            i++;

        }

        return matrix;
    }

    private boolean isNumber(String data) {
        try {
            Double.parseDouble(data);
        } catch (NumberFormatException err) {
            return false;
        }

        return true;    //Nao gerou excessao -> eh numero
    }
}

package Infra;

import Model.node.City_node;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.ArrayList;

public class Loader{

    private final TXT loader;

    public Loader() {
        this.loader = TXT.getInstance();
    }

    public ArrayList loaderCoord(String arquivo) {

        ArrayList<City_node> cn = new ArrayList<>();
        int nodeID = 0;
        float nodeX = 0, nodeY = 0;

        String dados[] = loader.ler(arquivo).split("\n");
        String aux[];

        int i;
        for (i = 0; i < dados.length; i++) {
            if (dados[i].contains("DISPLAY_DATA_SECTION")) {
                break;
            }
        }

        while (!dados[i + 1].contains("EOF")) {

            int j = 0;
            i++;
            //Troca todos os espacos vazios por apenas 1
            dados[i] = dados[i].replaceAll("[\\s]+", " ");
            //quebra a string por espaco vazio
            aux = dados[i].split(" ");

            try {

                if (aux[0].length() > 0) {
                    j = -1;                 //partes do arquivo contem espaço vazio no inicio e em outras nao
                }

                nodeID = Integer.parseInt(aux[1 + j]);
                nodeX = Float.parseFloat(aux[2 + j]);
                nodeY = Float.parseFloat(aux[3 + j]);

            } catch (Exception e) {
                System.err.println("Erro ao converter String -> Float");
            }

            cn.add(new City_node(nodeID, Math.round(nodeX), Math.round(nodeY)));
        }

        return cn;
    }
}

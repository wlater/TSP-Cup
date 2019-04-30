package Infra;

import Model.node.City_node;
import java.util.ArrayList;

public class Loader {

    private final TXT loader;

    public Loader() {
        this.loader = TXT.getInstance();
    }

    public City_node[] loaderCoord(String arquivo) {

        ArrayList<City_node> cn = new ArrayList<>();
        City_node[] listCityNode;
        int nodeID = 0;
        float nodeX = 0, nodeY = 0;

        String dados[] = loader.ler(arquivo).split("\n");
        String aux[];

        int i, len = 0, cont = 0;
        
        for (i = 0; i < dados.length; i++) {
            if(dados[i].contains("DIMENSION:")){
                String data[] = dados[i].split(" ");
                len = Integer.parseInt(data[1]);
            }

            if (dados[i].contains("DISPLAY_DATA_SECTION")) {
                break;
            }
        }
        
        listCityNode = new City_node[len];

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

            listCityNode[cont] = new City_node(nodeID, Math.round(nodeX), Math.round(nodeY));
            cont++;
            //cn.add(new City_node(nodeID, Math.round(nodeX), Math.round(nodeY)));
        }

        return listCityNode;
    }
}

package View;

import Infra.Loader;
import Model.node.City_node;
import static Principal.show;
import static Principal.show;
import static Principal.show;
import RadixSort;
import java.security.Principal;
import java.util.ArrayList;
import static java.util.Collections.sort;

public class TSP {

    public static void main(String args[]) {

        Loader loader = new Loader();
        
        
        
        
        

        ArrayList<City_node> cn = loader.loaderCoord("tsp2");

        
        for (int i = 0; i < cn.size() - 1; i++ ){
            for (int j = i + 1; j < cn.size(); j++){
                cn.get(i).addAdjacencia(cn.get(j),cn.get(i).distancia(cn.get(j)) );
                cn.get(j).addAdjacencia(cn.get(i),cn.get(j).distancia(cn.get(j)) );
            }
        }
        
        Sort sort = new RadixSort();
        sort.sort(vetor);
        System.out.println("\nRadixSort");
        show(vetor);      

        
        cn.get(0).listaAdjacencia.get(0);
        System.out.println(cn.get(5).distancia(cn.get(0)));
        System.out.println(cn.get(5).nodeX);
        System.out.println(cn.get(0).distancia(cn.get(5)));
        System.out.println(cn.get(0).nodeX);
        
    }
}

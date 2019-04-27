package View;

import Infra.Loader;
import Model.node.City_node;
import java.util.ArrayList;

public class TSP {

    public static void main(String args[]) {

        Loader loader = new Loader();

        ArrayList<City_node> cn = loader.loaderCoord("tsp2");

        System.out.println(cn.get(5).distancia(cn.get(0)));
        System.out.println(cn.get(5).nodeX);
        System.out.println(cn.get(0).distancia(cn.get(5)));
        System.out.println(cn.get(0).nodeX);
        
    }
}

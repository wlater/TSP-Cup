package Heuristicas;

import Model.Graph.Adjacencia;
import Model.node.City_node;

public class VND implements Heuristica {

    @Override
    public City_node[] solucao(City_node[] nodes) {
        City_node[] minimumList;

        System.err.println("len nodelist" + nodes.length);

        minimumList = Swap(nodes);

        return minimumList;
    }

    public City_node[] Swap(City_node[] nodesList) {
        boolean sair = false;
        City_node[] iniSol = nodesList, bestSol = nodesList;
        City_node aux;
        double iniDist = distance(iniSol), newDist = distance(iniSol);
        int a = 0, b = nodesList.length-1;

//      while(a < (nodesList.length-1)/2) {
        while (!sair) {
            aux = nodesList[a];
            nodesList[a] = nodesList[b];
            nodesList[b] = aux;

            if (distance(nodesList) < iniDist) {
                iniDist = distance(nodesList);
                bestSol = nodesList.clone();
                nodesList = iniSol.clone();
                a++;
                b--;

            }else {
                bestSol = DoisOpt(nodesList);
                sair = true;

            }
        }

        return bestSol;
    }

    public City_node[] DoisOpt(City_node[] nodesList) {
    	boolean sair = false;
    	City_node[] iniSol = nodesList, bestSol = nodesList;
    	double iniDist = distance(iniSol);
    	City_node aux;
    	int a = 0, b = nodesList.length-1;

    	while(a < (nodesList.length-1)/2) {
    		for(int i = a, j = b; i < (nodesList.length-1)/2; i++, j--) {
    			aux = nodesList[i+1];
    			nodesList[i+1] = nodesList[j-1];
    			nodesList[j-1] = aux;

    		}
    		if(distance(nodesList) < iniDist){
            bestSol = Swap(nodesList);

    		}else {
            a++;
            b--;
    		}
    	}

    	return bestSol;
    }

    //Calcula todas as distancias e retorna distancia total
    public double distance(City_node[] nodesList) {

        double totalPath = 0;

        try {

            for (int i = 1; i < nodesList.length ; i++) {
                totalPath += nodesList[i].distancia(nodesList[i - 1]);
            }
            return totalPath;
        } catch (Exception e) {
            System.err.println("Problema na funcao Distance do VND");
        }
+
        return 0.0;
    }

}

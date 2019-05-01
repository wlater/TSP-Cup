package Heuristicas;

import Model.Graph.Adjacencia;
import Model.node.City_node;

public class VND implements Heuristica {

    @Override
    public City_node[] solucao(City_node[] nodes) {
        City_node[] minimumList;

        System.err.println("len nodelist" + nodes.length);
        //reincertion
        minimumList = DoisOpt(nodes);

        return minimumList;
    }

    public City_node[] Swap(City_node[] nodesList) {
        boolean sair = false;
        City_node[] iniSol = nodesList, bestSol = nodesList;
        double iniDist = distance(nodesList), newDist = distance(nodesList);
        int a = 0, b = nodesList.length;

        while (!sair || a <= nodesList.length / 2) {
            newDist -= nodesList[a].distancia(nodesList[a + 1]) + nodesList[b].distancia(nodesList[b - 1]);
            newDist += nodesList[a].distancia(nodesList[b - 1]) + nodesList[b].distancia(nodesList[a + 1]);

            if (newDist < iniDist) {
                //bestSol = DoisOpt(nodesList);
                //iniDist = distance(bestSol);
                bestSol = nodesList.clone();
                sair = true;

            } else {
                iniDist = newDist;
                bestSol = nodesList.clone();
                nodesList = iniSol.clone();
                a++;
                b--;
            }
        }

        return bestSol;
    }

    public City_node[] DoisOpt(City_node[] nodesList) {
        //try {
        boolean sair = false;
        City_node[] iniSol = nodesList, bestSol = nodesList;
        double iniDist = distance(nodesList), newDist = distance(nodesList);
        int a = 0, b = nodesList.length - 1;

        while (!sair) {
            for (int i = a, j = b; i <= nodesList.length / 2; i++, j--) {
//
//                try {
                    System.err.println("i = " + i);
                    System.err.println("j = " + j);

                    newDist -= nodesList[i].distancia(nodesList[i + 1]) + nodesList[j].distancia(nodesList[j - 1]);
                    newDist += nodesList[i].distancia(nodesList[j - 1]) + nodesList[j].distancia(nodesList[i + 1]);
//                } catch (Exception e) {
//                }
            }
            if (newDist < iniDist) {
                iniDist = newDist;
                bestSol = nodesList;
                nodesList = iniSol;
                a++;
                b--;
            } else {
                sair = true;
            }
        }

        return bestSol;

//        } catch (Exception e) {
//            System.err.println("Problemas em doisOpt");
//        }
//        return null;
    }

    //Calcula todas as distancias e retorna distancia total
    public double distance(City_node[] nodesList) {
        Adjacencia bestDistance;
        double totalPath = 0;

        try {
            for (int i = 1; i < nodesList.length; i++) {
                totalPath += nodesList[i].distancia(nodesList[i - 1]);
            }

            return totalPath;
        } catch (Exception e) {
            System.err.println("Problema na funcao Distance do VND");
        }
//        for (City_node aux : nodesList) {
//            bestDistance = aux;
//            totalPath += bestDistance.distance;
//
//        }

        return 0.0;
    }

}

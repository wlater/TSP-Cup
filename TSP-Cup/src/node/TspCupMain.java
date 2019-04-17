package node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TspCupMain {

	public static void main(String[] args) {
		
		float nodeX, nodeY;
		int nodeID;
		int nodeEuclid = 0;
		Scanner scanner = null;
		
			try {
			    scanner =  new Scanner(new File("C:\\Users\\Erick-PC\\Downloads\\instancias\\instancias_tsp_cup\\tsp2.txt"));
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado ou vazio.");
				}   
		
		int aux = scanner.nextInt();
		City_node graphNode[][] = new City_node[aux][aux];
		System.out.println(aux);
				   
		   for(int i=0; i<aux-1; i++) {
			   for(int j=0; j<aux-1; j++) {   
				   	nodeID = scanner.nextInt();
				   	
				   		//não ta pegando esses floats do arquivo e convertendo para int.
				   	
				   	nodeX = Math.round(scanner.nextFloat());
				   	nodeY = Math.round(scanner.nextFloat());
				   	
				   		//calcular a distancia euclidiana entre nodeX e nodeY e colocar en nodeEuclid.
				   	
		    	    //graphNode[i][j] = new City_node(nodeEuclid, nodeID);
			   
			   }
		   }
		

	}

}

package View;

import Infra.Loader;
import Model.node.City_node;
import java.util.ArrayList;

public class TSP {

    public static void main(String args[]) {

        Loader loader = new Loader();
        

        ArrayList<City_node> cn = loader.loaderCoord("tsp1");
        
        for (int i = 0; i < cn.size(); i++){
            System.out.println(cn.get(i).nodeID + "\t" + 
                               cn.get(i).nodeX + "\t" + 
                               cn.get(i).nodeY);
        }

        /*
        // inicio mapeamento de arquivo
		float nodeX, nodeY;
		int nodeID;
		int nodeEuclid = 0;
		Scanner scanner = null;

		// testa se existe arquivo
		try {
			// coloca aqui o path para o arquivo e n esquece de colocar o .txt no final
			scanner = new Scanner(new File("C:\\Users\\Erick-PC\\Downloads\\instancias\\instancias_tsp_cup\\tsp2.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado ou vazio.");
		}

		int aux = scanner.nextInt(); // pega do arquivo o primeiro valor que � o tamanho da matriz
		City_node graphNode[][] = new City_node[aux][aux]; // cria a matriz com o tamanho

		for (int i = 0; i < aux - 1; i++) {
			for (int j = 0; j < aux - 1; j++) {
				nodeID = scanner.nextInt(); //pega o ID do node caso a gente for usar para algo

					// ERRO: n�o ta pegando esses floats do arquivo, arrendondando e convertendo para int.

				nodeX = Math.round(scanner.nextFloat());
				nodeY = Math.round(scanner.nextFloat());

				//graphNode[i][j] = new City_node(nodeEuclid, nodeX, nodeY);

			} // fim mapeamento de arquivo
		}
		
		for (int i = 0; i < aux - 1; i++) {
			for (int j = 0; j < aux - 1; j++) {
				//chamar a fun��o de calcular a distancia entre on nodes (Node_Map)

			} 
		}
         */
    }
}
# Terceiro estágio da disciplina de Análise e Projeto de Algoritmos

## Objetivos: 

 - Representação da solução
 - Implementação heurística de construção
 - Implementação dos movimentos de vizinhança (Mínimo 2)
 - Implementação do VND
 - Implementação de uma meta-heurística
 - Tabela de Resultados

### Representação da solução

A representação da solução é dada através da soma da distância de um vértice (node) para outro. Está situada na classe [Operações](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/Operacoes.java):

```
 	solucao = [ 2 | 4 | 1 | 3 | 2 ]

 	Matriz:

		   **1	 2   3   4**
	**1**    0   5   6   7
	**2**    5   0   4   2
	**3**    6   4   0   9
	**4**    7   2   9   0

	totalPath = 2 + 7 + 6 + 4
```
### Implementação heurística de construção

A heuristica de construção foi realizada escolhendo-se um node inicial e inserindo todos os outros de forma sequencial no vetor solução, por fim, a ultima posição do vetor será preenchida com o primeiro vértice inserido. Posteriormente esta solução será melhorada com as funções inseridas no VND.

### Implementação dos movimentos de vizinhança

As técnicas de movimento de vizinhança utilizadas foram o Swap e o 2-Opt localizadas na classe [VND](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/VND.java)

O Swap realiza trocas com os vizinhos mais próximos e vai testando com os mais distantes enquanto a solução for otimizada.

O 2-Opt inverte a ordem dos vértices em um certo limite.

### Implementação do VND

Tamém encontrada na classe [VND](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/VND.java), O VND aplica o Swap e o 2-Opt na solução. Inicialmente o Swap é aplicado na solução, e continua sendo até que a mesma não consiga ser mais otimizada por esta técnica.

Em seguida o 2-Opt é aplicado na solução, e caso a mesma consiga ser melhorada, a técnica de Swap é aplicada novamente.

### Implementação de uma meta-heurística

A meta-heurística implementada foi a técnica de GRASP, encontrada na classe [GRASP](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/GRASP.java). A mesma recebe:

 - Uma matriz de adjacência: Identifica o valor de distância entre os vértices / nodes

 - Valor *Alpha*: Um valor em um intervalo de [0 - 1]. Esta representa o grau de aleatoriedade do algoritmo, onde 0 (zero) disnifica que o mesmo é completamente guloso e 1 (um) que é 100% aleatório

 - Critério de Parada: Indica para o algoritmo quantas vezes ele deve tentar melhorar a solução encontrada.

 A técnica GRASP iniciamente constroi a solução inicial por meio dos termos citados acima e em seguida aplica o VND a fim de otimizar a solução encontrada.


### Tabela de Resultados

 ![tabela](https://github.com/wlater/TSP-Cup/blob/master/img/tabela.jpg?raw=true)
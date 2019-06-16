# Third stage of Algorithm Design Analysis

## Topics:

- [Solution Representation](https://github.com/wlater/TSP-Cup#representa%C3%A7%C3%A3o-da-solu%C3%A7%C3%A3o)

- [Heuristic implementation of construction](https://github.com/wlater/TSP-Cup#implementa%C3%A7%C3%A3o-heur%C3%ADstica-de-constru%C3%A7%C3%A3o)

- [Implementation of neighborhood movements](https://github.com/wlater/TSP-Cup#implementa%C3%A7%C3%A3o-dos-movimentos-de-vizinhan%C3%A7a)

- [VND Implementation](https://github.com/wlater/TSP-Cup#implementa%C3%A7%C3%A3o-do-vnd)

- [Implementation of a meta-heuristic](https://github.com/wlater/TSP-Cup#implementa%C3%A7%C3%A3o-de-uma-meta-heur%C3%ADstica)
 
- [Results Table](https://github.com/wlater/TSP-Cup#tabela-de-resultados)

### Solution Representation

The solution representation is given by summing the distance from one vertex (node) to another. It is located in the class [Operations](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristics/Operations.java):

```
 	solution = [ 2 | 4 | 1 | 3 | 2 ]

 	Matrix:

		 1   2   3   4
	1    0   5   6   7
	2    5   0   4   2
	3    6   4   0   9
	4    7   2   9   0

	totalPath = 2 + 7 + 6 + 4
```
### Building heuristic implementation

Building Heuristic is a initial solution that we need to pass for the [VND](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/VND.java) method. The building heuristic was performed choosing one initial node  and inserting all the others in a sequential form on the soluction vector, finally, the last position of the vector will be the first vertice assigned to the vector. Then this soluction will be ready to be passed to the VND method. 

### Implementation of neighborhood movements

The neighborhood movement techniques used were Swap and 2-Opt, located in the class [VND](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/VND.java)

O The Swap performs the exchanges with the closest neighbors and goes testing with the most distant ones as a solution goes on.

O 2-Opt inverts the order of the vertices by a certain limit.

### VND implementation

It can also be found in [VND](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/VND.java), this one, applies Swap and 2-Opt in the solution. Initially the Swap is applied to the solution, and remains until it couldnt be optmized anymore.

Then the 2-Opt is applied in the solution, and if it can be improved, a Swap technique is used again, if not, We have our soluction.

### Implementation of a metaheuristic

A metaheuristic implemented was a GRASP technique, found in the class [GRASP](https://github.com/wlater/TSP-Cup/blob/master/src/Heuristicas/GRASP.java). It receives:

- An adjacency matrix: Identifies the distance value between the vertices / nodes

- Value * Alpha *: A value in a range of [0 - 1]. This is the representation of the degree of randomness of the algorithm, where 0 (zero) disallows that it is completely greedy and 1 (one) that is 100% random

- Stop Criteria:

The GRASP technique started the construction of a solution with the terms mentioned above and in the next application.


### Results Table

 ![tabela](https://github.com/wlater/TSP-Cup/blob/master/img/tabela.jpg?raw=true)

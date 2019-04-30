/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heuristicas;

import Model.node.City_node;
public interface Heuristica {
    public City_node[] solucao(City_node[] nodes);
}

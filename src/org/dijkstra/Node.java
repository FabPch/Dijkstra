package org.dijkstra;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fabien on 23/01/2018.
 */
public class Node {

    private String name;
    private int weight = Integer.MAX_VALUE;
    private Node antecedent;
    private boolean settled = false;
    private Map<Node, Integer> adjacentNodes = new HashMap<Node, Integer>();

    public Node(String name) {
        this.name = name;
    }

    public void calculateSonsWeight(){
        for (Map.Entry<Node, Integer> e : this.adjacentNodes.entrySet()){
            Node s = e.getKey();
            if (s.getWeight() > e.getValue() + this.weight){
                s.setAntecedent(this);
                s.setWeight(e.getValue() + this.weight);
            }
        }
    }

    public void addAdjacentNode(Node n, Integer i){
        this.adjacentNodes.put(n, i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Node antecedent) {
        this.antecedent = antecedent;
    }

    public boolean isSettled() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }
}

package org.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabien on 23/01/2018.
 */
public class Graph {

    private int nbSettled = 0;

    private List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public int getNbSettled() {
        return nbSettled;
    }

    public void upSettledNodes(){
        this.nbSettled += 1;
    }
}

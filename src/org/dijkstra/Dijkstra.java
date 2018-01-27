package org.dijkstra;

/**
 * Created by Fabien on 23/01/2018.
 */
public class Dijkstra {
    public static void main(String[] args){

        if (args.length < 1){
            String m = "\nyou need to enter 2 arguments : \n";
            m += "\t source\n";
            m += "\t destination\n";
            m += "Choose the cities in the list below :\n";
            m += "Brest \t Nantes \t Paris \t Arras \t Strasbourg \t Lyon\n";
            m += "Marseille \t Montpellier \t Bordeaux \t Poitiers\n";
            throw new IllegalArgumentException(m);
        }

        //Nodes and Graph construction
        Node brest = new Node("Brest");
        Node nantes = new Node("Nantes");
        Node paris = new Node("Paris");
        Node arras = new Node("Arras");
        Node strasbourg = new Node("Strasbourg");
        Node lyon = new Node("Lyon");
        Node marseille = new Node("Marseille");
        Node montpellier = new Node("Montpellier");
        Node bordeaux = new Node("Bordeaux");
        Node poitiers = new Node("Poitiers");

        Graph graph = new Graph();

        brest.addAdjacentNode(nantes, 298);
        brest.addAdjacentNode(paris, 593);
        nantes.addAdjacentNode(brest, 298);
        nantes.addAdjacentNode(paris, 386);
        nantes.addAdjacentNode(arras, 561);
        nantes.addAdjacentNode(bordeaux, 334);
        paris.addAdjacentNode(nantes, 386);
        paris.addAdjacentNode(brest, 593);
        paris.addAdjacentNode(arras, 185);
        paris.addAdjacentNode(lyon, 465);
        paris.addAdjacentNode(poitiers, 338);
        arras.addAdjacentNode(paris, 185);
        arras.addAdjacentNode(nantes, 561);
        arras.addAdjacentNode(strasbourg, 522);
        strasbourg.addAdjacentNode(arras, 522);
        strasbourg.addAdjacentNode(lyon, 494);
        strasbourg.addAdjacentNode(marseille, 809);
        strasbourg.addAdjacentNode(montpellier, 797);
        lyon.addAdjacentNode(strasbourg, 494);
        lyon.addAdjacentNode(marseille, 315);
        lyon.addAdjacentNode(montpellier, 303);
        lyon.addAdjacentNode(paris, 465);
        poitiers.addAdjacentNode(paris, 338);
        poitiers.addAdjacentNode(montpellier, 557);
        poitiers.addAdjacentNode(bordeaux, 237);
        montpellier.addAdjacentNode(poitiers, 557);
        montpellier.addAdjacentNode(lyon, 303);
        montpellier.addAdjacentNode(marseille, 171);
        montpellier.addAdjacentNode(strasbourg, 797);
        marseille.addAdjacentNode(strasbourg, 809);
        marseille.addAdjacentNode(lyon, 315);
        marseille.addAdjacentNode(montpellier, 171);
        bordeaux.addAdjacentNode(poitiers, 237);
        bordeaux.addAdjacentNode(nantes, 334);

        graph.getNodes().add(nantes);
        graph.getNodes().add(brest);
        graph.getNodes().add(paris);
        graph.getNodes().add(marseille);
        graph.getNodes().add(lyon);
        graph.getNodes().add(arras);
        graph.getNodes().add(poitiers);
        graph.getNodes().add(montpellier);
        graph.getNodes().add(strasbourg);
        graph.getNodes().add(bordeaux);

        //init
        Node s = new Node(args[0]);
        Node d = new Node(args[1]);

        int c = 0;
        if (args[0] != null && args[1] != null){
            for (Node n : graph.getNodes()){
                if (n.getName().equalsIgnoreCase(s.getName())){
                    s = n;
                    c++;
                }
                if (n.getName().equalsIgnoreCase(d.getName())){
                    d = n;
                    c++;
                }
            }
        }

        if (c < 2){
            throw new IllegalArgumentException("\none the city you enter is not in the list");
        }

        s.setWeight(0);

        //main function
        while (graph.getNbSettled() < graph.getNodes().size() - 1){
            Node nodeMin = min(graph);
            nodeMin.setSettled(true);
            nodeMin.calculateSonsWeight();
            graph.upSettledNodes();
        }

        //result
        System.out.println(d.getWeight());

        //print path
        while (d.getName() != s.getName()){
            System.out.println(d.getName());
            d = d.getAntecedent();
        }


    }

    public static Node min(Graph g){
        int m = Integer.MAX_VALUE;
        Node nodeMin = new Node("yo");
        for (Node n : g.getNodes()){
            if (!n.isSettled() && n.getWeight() < m){
                m = n.getWeight();
                nodeMin = n;
            }
        }
        return nodeMin;
    }

}

import java.io.File;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.Vector;

/**
 * Created by shubhankar on 12/1/16.
 */
public class Dijkstra {
    public static void main(String[] args) {
        new Dijkstra().run();
    }

    public void run() {
        int inf = Integer.MAX_VALUE;
        int max_row = 0, max_col = 0;
        int adj[][] = null;

        try {
            System.out.print("Enter the file name with extension: ");
            Scanner input = new Scanner(System.in);
            File file = new File(input.nextLine());
            input = new Scanner(file);


            if (input.hasNextLine()) {
                input.next();
                max_col = max_row = input.nextInt();
                adj = new int[max_row][max_col];
                input.nextLine();
                input.nextLine();
                input.nextLine();
                int row = 0;
                while (input.hasNextLine()) {
                    String delim = "\\s+";
                    String line = input.nextLine();
                    String[] tokens = line.split(delim);
                    for (int col = 0; col < tokens.length; col++) {
                        if (tokens[col].equals("inf")) {
                            adj[row][col] = inf;
                        } else adj[row][col] = Integer.parseInt(tokens[col]);
                    }
                    row += 1;
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Vector<Vertex> graph = new Vector<Vertex>();
        for (int i = 65; i < 65 + max_col; i++) {
            graph.add(new Vertex(String.valueOf((char) i)));
        }

        for (int i = 0; i < max_row; i++) {
            // Go through each row of the adjacency matrix collecting neighbours
            Vertex v = graph.elementAt(i);
            for (int j = 0; j < max_col; j++) {
                if (adj[i][j] != inf) {
                    v.add_edge(new Edge(i, j, adj[i][j]));
                }
            }
            v.order_edges(); /* Order (sort) the neighbours for this vertex */
        }

        /*for (Vertex v : graph) {
            System.out.println(v);
        }*/
        for (int count = 0; count < graph.size(); count++) {
            Vector<Edge> hopList;
            hopList = new Vector<Edge>();


            int start = count;
            int cost;
            int newCost;
            int vertex;
            int vertexCost;

            for (int dest = 0; dest < graph.size(); dest++) {
                int pred = -1;
                if (dest != start) {
                    assert adj != null;
                    cost = adj[start][dest];
                    if (cost == inf) {
                        hopList.add(new Edge(pred, dest, cost));
                    } else hopList.add(new Edge(start, dest, cost));
                }
                Collections.sort(hopList);

            }

            int update = 0;


            System.out.println("Start vertex: " + graph.elementAt(count).get_name());
            for (int i = 0; i < hopList.size(); i++) {

                vertex = hopList.elementAt(update).destination;
                vertexCost = hopList.elementAt(update).cost;

                for (int dest = 1; dest < hopList.size(); dest++) {

                    assert adj != null;
                    cost = hopList.elementAt(dest).cost;
                /*System.out.println("Dest: " + dest);
                System.out.println("Vertex: " + vertex);*/

                /*System.out.println("Cost from vertex: " + Vertex.get_vertex_name(hopList.elementAt(update).destination) +" to dest: " + Vertex.get_vertex_name(hopList.elementAt(dest).destination) + " is " + adj[vertex][dest]);*/
                    if (adj[vertex][hopList.elementAt(dest).destination] != inf) {
                        newCost = vertexCost + adj[vertex][hopList.elementAt(dest).destination];
                    } else newCost = inf;

                    if (newCost < cost) {
                        hopList.elementAt(dest).cost = newCost;
                        hopList.elementAt(dest).source = vertex;
                    }
                }
                Collections.sort(hopList);
                update++;
            }
            for (Edge e : hopList) {
                System.out.println(Vertex.get_vertex_name(start) + " --> " + Vertex.get_vertex_name(e.destination) + " : " + " Cost is " + e.cost);
            }
        }
    }

    //--------------------------------------------------------------------
    static class Vertex {
        private String name;
        private int id;    /* Integral id of vertex: [0, n-1] */
        private int state; /* 0: undiscovered; 1: discovered; 2: visited */
        private int pred;  /* Predecessor node.  Unused here */
        private Vector<Edge> edgelist;

        private static int counter = 0;

        public Vertex(String name) {
            this.name = name;
            state = 0;
            pred = -1;
            id = counter++;
            edgelist = null;
        }

        public void order_edges() {
            Collections.sort(edgelist);
        }

        public String toString() {
            StringBuilder s = new StringBuilder();

            s.append("Vertex: " + name + "(" + id + ")");
            s.append(" (" + state + ", " + pred + ")\n");
            s.append("  Neighbours: ");
            for (Edge e : edgelist) {
                s.append(e);
                s.append(" ");
            }

            return s.toString();
        }

        public void add_edge(Edge e) {
            if (edgelist == null) {
                edgelist = new Vector<Edge>();
            }
            edgelist.add(e);
        }

        public boolean match_name(String name) {
            if (this.name.equals(name))
                return true;
            else
                return false;
        }

        public void visited() {
            state = 2;
        }

        public String get_name() {
            return name;
        }

        public static int get_vertex_index(String name) {
            int v = -1;

            switch (name) {
                case "A":
                    v = 0;
                    break;
                case "B":
                    v = 1;
                    break;
                case "C":
                    v = 2;
                    break;
                case "D":
                    v = 3;
                    break;
                case "E":
                    v = 4;
                    break;
                case "F":
                    v = 5;
                    break;
                case "G":
                    v = 6;
                    break;
                case "H":
                    v = 7;
                    break;
                case "I":
                    v = 8;
                    break;
                default:
                    System.out.println("get_vertex_index: invalid name");
                    break;
            }
            return v;
        }

        public static String get_vertex_name(int index) {
            String v = "null";
            switch (index) {
                case 0:
                    v = "A";
                    break;
                case 1:
                    v = "B";
                    break;
                case 2:
                    v = "C";
                    break;
                case 3:
                    v = "D";
                    break;
                case 4:
                    v = "E";
                    break;
                case 5:
                    v = "F";
                    break;
                case 6:
                    v = "G";
                    break;
                case 7:
                    v = "H";
                    break;
                case 8:
                    v = "I";
                    break;
                case -1:
                    v = "null";
                    break;
                default:
                    System.out.println("get_vertex_name: invalid index");
                    break;
            }
            return v;
        }
    } // Class Vertex

    static class Edge implements Comparable<Edge> {
        private int source;
        private int destination;
        private int cost;

        public Edge(int s, int d, int c) {
            source = s;
            destination = d;
            cost = c;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();

            s.append("(" + Vertex.get_vertex_name(source) + ", " +
                    Vertex.get_vertex_name(destination) + ", " + cost + ")");
            return s.toString();
        }

        public int compareTo(Edge o) {
            if (this.cost < o.cost)
                return -1;
            else if (this.cost > o.cost)
                return 1;
            else
                return 0;
        }

    } // Class Edge
}

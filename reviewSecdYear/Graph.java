package reviewSecdYear;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph {
    static int time = 0;

    public static void main(String[] args) {
        // Map<Vertex, ArrayList<Vertex>> G = new HashMap<>();
        // Vertex r = new Vertex('r');
        // Vertex s = new Vertex('s');
        // Vertex t = new Vertex('t');
        // Vertex u = new Vertex('u');
        // Vertex v = new Vertex('v');
        // Vertex w = new Vertex('w');
        // Vertex x = new Vertex('x');
        // Vertex y = new Vertex('y');

        // ArrayList<Vertex> neighbour = new ArrayList<>();
        // neighbour.add(v);
        // neighbour.add(s);
        // G.put(r, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(r);
        // neighbour.add(w);
        // G.put(s, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(w);
        // neighbour.add(x);
        // neighbour.add(u);
        // G.put(t, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(t);
        // neighbour.add(x);
        // neighbour.add(y);
        // G.put(u, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(r);
        // G.put(v, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(s);
        // neighbour.add(t);
        // neighbour.add(x);
        // G.put(w, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(w);
        // neighbour.add(t);
        // neighbour.add(u);
        // neighbour.add(y);
        // G.put(x, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(x);
        // neighbour.add(u);
        // G.put(y, neighbour);

        // dfs_1(G);
        // System.out.println();

        // Map<Vertex, ArrayList<Vertex>> G = new HashMap<>();
        // Vertex a = new Vertex('a');
        // Vertex b = new Vertex('b');
        // Vertex c = new Vertex('c');
        // Vertex d = new Vertex('d');
        // Vertex e = new Vertex('e');
        // Vertex f = new Vertex('f');
        // Vertex g = new Vertex('g');
        // Vertex h = new Vertex('h');
        // ArrayList<Vertex> neighbour = new ArrayList<>();

        // neighbour.add(b);
        // G.put(a, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(c);
        // neighbour.add(e);
        // neighbour.add(f);
        // G.put(b, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(d);
        // neighbour.add(g);
        // G.put(c, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(c);
        // neighbour.add(h);
        // G.put(d, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(a);
        // neighbour.add(f);
        // G.put(e, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(g);
        // G.put(f, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(f);
        // neighbour.add(h);
        // G.put(g, neighbour);

        // neighbour = new ArrayList<>();
        // neighbour.add(h);
        // G.put(h, neighbour);
        // scc(G);
        // Map<Vertex, ArrayList<Vertex>> Graph = new HashMap<>();
        // ArrayList<Edge> edges = new ArrayList<>();
        // ArrayList<Vertex> neighbors = new ArrayList<>();
        // Vertex a = new Vertex('a');
        // Vertex b = new Vertex('b');
        // Vertex c = new Vertex('c');
        // Vertex d = new Vertex('d');
        // Vertex e = new Vertex('e');
        // Vertex f = new Vertex('f');
        // Vertex g = new Vertex('g');
        // Vertex h = new Vertex('h');
        // Vertex i = new Vertex('i');

        // neighbors.add(b);
        // neighbors.add(h);
        // Graph.put(a, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(a);
        // neighbors.add(h);
        // neighbors.add(c);
        // Graph.put(b, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(b);
        // neighbors.add(i);
        // neighbors.add(f);
        // neighbors.add(d);
        // Graph.put(c, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(c);
        // neighbors.add(e);
        // neighbors.add(f);
        // Graph.put(d, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(d);
        // neighbors.add(f);
        // Graph.put(e, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(c);
        // neighbors.add(d);
        // neighbors.add(e);
        // neighbors.add(g);
        // Graph.put(f, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(f);
        // neighbors.add(i);
        // neighbors.add(h);
        // Graph.put(g, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(i);
        // neighbors.add(g);
        // neighbors.add(a);
        // neighbors.add(b);
        // Graph.put(h, neighbors);

        // neighbors = new ArrayList<>();
        // neighbors.add(h);
        // neighbors.add(g);
        // neighbors.add(c);
        // Graph.put(i, neighbors);

        // edges.add(new Edge(a, h, 8));
        // edges.add(new Edge(a, b, 4));
        // edges.add(new Edge(h, b, 11));
        // edges.add(new Edge(b, c, 8));
        // edges.add(new Edge(c, i, 2));
        // edges.add(new Edge(c, f, 4));
        // edges.add(new Edge(c, d, 7));
        // edges.add(new Edge(f, d, 14));
        // edges.add(new Edge(d, e, 9));
        // edges.add(new Edge(e, f, 10));
        // edges.add(new Edge(f, g, 2));
        // edges.add(new Edge(g, i, 6));
        // edges.add(new Edge(g, h, 1));
        // edges.add(new Edge(h, i, 7));

        // // System.out.println(Kruskal(Graph, edges));
        // Prim(Graph, edges, d);

        Map<Vertex, Map<Vertex, Integer>> G = new HashMap<>();
        Map<Vertex, Integer> neighbor = new HashMap<>();
        Vertex s = new Vertex('s');
        Vertex t = new Vertex('t');
        Vertex x = new Vertex('x');
        Vertex y = new Vertex('y');
        Vertex z = new Vertex('z');
        neighbor.put(t, 10);
        neighbor.put(y, 5);
        G.put(s, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(y, 2);
        neighbor.put(x, 1);
        G.put(t, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(z, 4);
        G.put(x, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(t, 3);
        neighbor.put(x, 9);
        neighbor.put(z, 2);
        G.put(y, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(s, 7);
        neighbor.put(x, 6);
        G.put(z, neighbor);
        Shortest_path(G, t, z);
    }

    static void scc(Map<Vertex, ArrayList<Vertex>> G) {
        dfs_1(G);
        Map<Vertex, ArrayList<Vertex>> GT = new HashMap<>();
        for (Map.Entry<Vertex, ArrayList<Vertex>> entry : G.entrySet()) {
            for (Vertex v : entry.getValue()) {
                ArrayList<Vertex> list = GT.get(v);
                if (list == null) {
                    list = new ArrayList<>();
                    GT.put(v, list);
                }
                list.add(entry.getKey());
            }
        }
        dfs_1(GT);
    }

    static void bfs(Map<Vertex, ArrayList<Vertex>> G, Vertex s) {
        s.d = 0;
        s.c = Color.gray;
        Queue<Vertex> Q = new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            for (Vertex vertex : G.get(u)) {
                if (vertex.c == Color.white) {
                    vertex.pi = u;
                    vertex.d = 1 + u.d;
                    vertex.c = Color.gray;
                    Q.add(vertex);
                }
            }
            u.c = Color.black;
        }
    }

    static void dfs(Map<Vertex, ArrayList<Vertex>> G, Vertex s) {
        s.d = 0;
        s.c = Color.gray;
        Stack<Vertex> Q = new Stack<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            Vertex u = Q.pop();
            for (Vertex vertex : G.get(u)) {
                if (vertex.c == Color.white) {
                    vertex.pi = u;
                    vertex.d = 1 + u.d;
                    vertex.c = Color.gray;
                    Q.add(vertex);
                }
            }
            u.c = Color.black;
        }
    }

    static void dfs_1(Map<Vertex, ArrayList<Vertex>> G) {
        time = 0;
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.addAll(G.keySet());
        if (vertices.get(0).f == 0)
            for (Vertex u : vertices) {
                if (u.c == Color.white)
                    dfs_visit(G, u);
            }
        else {
            vertices.sort((v, u) -> u.f - v.f);
            for (Vertex vertex : vertices) {
                vertex.c = Color.white;
            }
            for (Vertex u : vertices) {
                if (u.c == Color.white) {
                    System.out.print('[');
                    dfs_visit(G, u);
                    System.out.println(']');
                }
            }
        }
    }

    static void dfs_visit(Map<Vertex, ArrayList<Vertex>> G, Vertex u) {
        u.d = ++time;
        u.c = Color.gray;
        if (u.f != 0)
            System.out.print(u + "_");
        for (Vertex v : G.get(u)) {
            if (v.c == Color.white) {
                v.pi = u;
                dfs_visit(G, v);
            }
        }
        u.c = Color.black;
        u.f = ++time;
    }

    static ArrayList<Edge> Kruskal(Map<Vertex, ArrayList<Vertex>> G, ArrayList<Edge> edges) {
        ArrayList<Edge> paths = new ArrayList<>();
        Map<Vertex, Set<Vertex>> S = new HashMap<>();
        for (Vertex v : G.keySet()) {
            Set<Vertex> s = new HashSet<>();
            s.add(v);
            S.put(v, s);
        }
        edges.sort((e1, e2) -> e1.weight - e2.weight);
        for (Edge edge : edges) {
            Set<Vertex> s1 = S.get(edge.v1);
            Set<Vertex> s2 = S.get(edge.v2);
            if (s1 != s2) {
                paths.add(edge);
                s1.addAll(s2);
                for (Vertex vertex : s2) {
                    S.put(vertex, s1);
                }
            }
        }
        return paths;
    }

    static void Prim(Map<Vertex, ArrayList<Vertex>> Graph, ArrayList<Edge> edges, Vertex r) {
        Map<Vertex, Map<Vertex, Integer>> nGraph = new HashMap<>();
        Map<Vertex, Integer> map = new HashMap<>();
        for (Vertex v : Graph.keySet()) {
            map = new HashMap<>();
            nGraph.put(v, map);
        }
        for (Edge edge : edges) {
            Vertex v1 = edge.v1;
            Vertex v2 = edge.v2;
            map = nGraph.get(v2);
            map.put(v1, edge.weight);
            nGraph.put(v2, map);
            map = nGraph.get(v1);
            map.put(v2, edge.weight);
            nGraph.put(v1, map);
        }
        r.d = 0;
        PriorityQueue<Vertex> Q = new PriorityQueue<>((v1, v2) -> v1.d - v2.d);
        Q.addAll(nGraph.keySet());
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            Map<Vertex, Integer> M = nGraph.get(u);
            for (Vertex vertex : M.keySet()) {
                if (Q.contains(vertex) && M.get(vertex) < vertex.d) {
                    vertex.pi = u;
                    vertex.d = M.get(vertex);
                    System.out.println(vertex + " " + vertex.d);
                    Q.remove(vertex);
                    Q.add(vertex);
                }
            }
        }
    }

    public static ArrayList<Vertex> Dijkstra(Map<Vertex, Map<Vertex, Integer>> G, Vertex s) {
        s.d = 0;
        ArrayList<Vertex> paths = new ArrayList<>();
        PriorityQueue<Vertex> Q = new PriorityQueue<>((v1, v2) -> (v1.d - v2.d));
        Q.addAll(G.keySet());
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            paths.add(u);
            Map<Vertex, Integer> map = G.get(u);
            for (Vertex vertex : map.keySet()) {
                if (vertex.d > u.d + map.get(vertex)) {
                    vertex.d = u.d + map.get(vertex);
                    vertex.pi = u;
                    Q.remove(vertex);
                    Q.add(vertex);
                }
            }
        }
        return paths;
    }

    public static void Shortest_path(Map<Vertex, Map<Vertex, Integer>> G, Vertex v1, Vertex v2) {
        Dijkstra(G, v1);
        Stack<Vertex> S = new Stack<>();
        S.add(v2);
        while (v2.pi != null) {
            S.add(v2.pi);
            v2 = v2.pi;
        }
        while (!S.isEmpty()) {
            System.out.print(S.pop() + "_");
        }
    }
}

class Vertex {
    char key;
    int d;
    Vertex pi;
    Color c;
    int f;

    public Vertex(char key) {
        this.key = key;
        this.d = Integer.MAX_VALUE;
        this.c = Color.white;
    }

    public String toString() {
        return "" + key;
    }
}

class Edge {
    Vertex v1;
    Vertex v2;
    int weight;

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public String toString() {
        return v1 + "<->" + v2;
    }

}

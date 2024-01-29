package reviewSec_Again;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import java.util.Map;
import java.util.PriorityQueue;

public class Graph {

    public void bfs(Map<Vertex, ArrayList<Vertex>> GG, Vertex s) {
        s.d = 0;
        s.c = Color.gray;
        Queue<Vertex> Q = new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            System.out.println(u);
            for (Vertex vertex : GG.get(u)) {
                if (vertex.c == Color.white) {
                    vertex.c = Color.gray;
                    vertex.d = u.d + 1;
                    vertex.pi = u;
                    Q.add(vertex);
                }
            }
            u.c = Color.black;
        }
    }

    public void dfs(Map<Vertex, ArrayList<Vertex>> GG, Vertex s) {
        s.d = 0;
        s.c = Color.gray;
        Stack<Vertex> S = new Stack<>();
        S.add(s);
        while (!S.isEmpty()) {
            Vertex u = S.pop();
            System.out.println(u);
            for (Vertex vertex : GG.get(u)) {
                if (vertex.c == Color.white) {
                    vertex.c = Color.gray;
                    vertex.d = u.d + 1;
                    vertex.pi = u;
                    S.add(vertex);
                }
            }
            u.c = Color.black;
        }
    }

    int time;

    public void dfs_1(Map<Vertex, ArrayList<Vertex>> GG) {
        time = 0;
        ArrayList<Vertex> Vertices = new ArrayList<>(GG.keySet());
        if (Vertices.get(0).f <= 0)
            for (Vertex v : Vertices) {
                if (v.c == Color.white) {
                    dfs_visit(GG, v);
                }
            }
        else {
            Vertices.sort((o1, o2) -> (o2.f - o1.f));
            for (Vertex v : Vertices) {
                if (v.c == Color.white) {
                    System.out.println("scc is");
                    dfs_visit(GG, v);
                }
            }
        }
    }

    public void dfs_visit(Map<Vertex, ArrayList<Vertex>> GG, Vertex s) {
        s.d = ++time;
        s.c = Color.gray;
        if (s.f > 0)
            System.out.println(s);
        for (Vertex vertex : GG.get(s)) {
            if (vertex.c == Color.white) {
                vertex.pi = s;
                dfs_visit(GG, vertex);
            }
        }
        s.c = Color.black;
        s.f = ++time;
    }

    public void scc(Map<Vertex, ArrayList<Vertex>> GG) {
        dfs_1(GG);
        Map<Vertex, ArrayList<Vertex>> GT = new HashMap<>();
        for (Vertex v : GG.keySet()) {
            for (Vertex u : GG.get(v)) {
                ArrayList<Vertex> Vs = GT.get(u);
                if (Vs == null) {
                    Vs = new ArrayList<>();
                    GT.put(u, Vs);
                }
                Vs.add(v);
            }
        }
        for (Vertex v : GG.keySet()) {
            v.c = Color.white;
        }
        dfs_1(GT);
    }

    public ArrayList<Edge> Kruskal(Map<Vertex, ArrayList<Vertex>> G, ArrayList<Edge> edges) {
        ArrayList<Edge> paths = new ArrayList<>();
        Map<Vertex, Set<Vertex>> S = new HashMap<>();
        for (Vertex vertex : G.keySet()) {
            Set<Vertex> s = new HashSet<>();
            s.add(vertex);
            S.put(vertex, s);
        }
        edges.sort((e1, e2) -> (e1.weight - e2.weight));
        for (Edge e : edges) {
            Set<Vertex> s1 = S.get(e.v1);
            Set<Vertex> s2 = S.get(e.v2);
            if (s1 != s2) {
                paths.add(e);
                s1.addAll(s2);
                for (Vertex vertex : s2) {
                    S.put(vertex, s1);
                }
            }
        }
        return paths;
    }

    public void Prim(Map<Vertex, Map<Vertex, Integer>> G, Vertex s) {
        s.d = 0;
        PriorityQueue<Vertex> Q = new PriorityQueue<>((o1, o2) -> (o1.d - o2.d));
        Q.addAll(G.keySet());
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            for (Vertex vertex : G.get(u).keySet()) {
                int distance = G.get(u).get(vertex);
                if (vertex.d > distance) {
                    vertex.d = distance;
                    Q.remove(vertex);
                    Q.add(vertex);
                }
            }
        }
    }

    public void Dijkstra(Map<Vertex, Map<Vertex, Integer>> G, Vertex s) {
        s.d = 0;
        PriorityQueue<Vertex> Q = new PriorityQueue<>((o1, o2) -> (o1.d - o2.d));
        Q.addAll(G.keySet());
        while (!Q.isEmpty()) {
            Vertex v = Q.poll();
            for (Vertex vertex : G.get(v).keySet()) {
                int distance = v.d + G.get(v).get(vertex);
                if (vertex.d > distance) {
                    vertex.d = distance;
                    Q.remove(vertex);
                    Q.add(vertex);
                }
            }
        }
    }
}

class Vertex {
    int d;
    Color c;
    Vertex pi;
    char key;
    int f;

    public Vertex(char key) {
        this.key = key;
        d = Integer.MAX_VALUE;
        c = Color.white;
    }

    public String toString() {
        return key + "";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (key != other.key)
            return false;
        return true;
    }

}

class Edge {
    int weight;
    Vertex v1;
    Vertex v2;

    public Edge(int weight, Vertex v1, Vertex v2) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }

    public String toString() {
        return v1 + "->" + v2 + ":" + weight;
    }
}

package reviewSec_Again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        // o(n^2)、o(nlogn)的排序测试
        // Integer[] a = { 48, 0, 23, 1, 3213, -232, -8 };
        // System.out.println(Arrays.toString(a));
        // heap.sort(a);
        // System.out.println(Arrays.toString(a));

        // o(n)排序的测试
        // int[] a = { 234, 0, 43, 6, 235, 65, 67, 22322, 1 };
        // System.out.println(Arrays.toString(a));
        // radix.sort(a);
        // System.out.println(Arrays.toString(a));

        // Stack的测试
        // Stack<Integer> s = new Stack<>(5);
        // for (int i = 0; i < 5; i++) {
        // s.push(i + 1);
        // }
        // for (int i = 0; i < 4; i++) {
        // s.pop();
        // }
        // System.out.println(s.isEmpty());

        // Queue的测试
        // Queue<Integer> Q = new Queue<>(5);
        // for (int i = 0; i < 5; i++) {
        // Q.enqueue(i + 2);
        // }
        // Q.dequeue();
        // for (int i = 0; i < 3; i++) {
        // Q.dequeue();
        // }
        // System.out.println(Q.isEmpty());

        // LinkedList的测试 哨兵
        // LinkedList<Integer> l = new LinkedList<>();
        // for (int i = 0; i < 5; i++) {
        // l.add(i + 1);
        // }
        // System.out.println(l.Search(1));

        // LinkedList测试，非哨兵
        // LinkedList_Nocircle<Integer> list = new LinkedList_Nocircle<>();
        // for (int i = 0; i < 5; i++) {
        // list.add(i + 1);
        // }
        // list.remove(2);
        // System.out.println(list);

        // 二叉搜索树的测试
        // BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        // bst.insert(5);
        // for (int i = 0; i < 10; i++) {
        // bst.insert(i);
        // }
        // System.out.println(bst);
        // System.out.println(bst.Search(5));
        // System.out.println(bst.Search_Re(5));
        // System.out.println(bst.getHeight());
        // System.out.println(bst.Successor(4));

        // 图的测试
        // G = createMap_bfs();
        // System.out.println(G);
        // new Graph().bfs(G, s);
        // createMap_dfs();
        // System.out.println(G);
        // new Graph().dfs_1(G);
        // createMap_scc();
        // new Graph().scc(G);
        // createMap_Kruskal();
        // System.out.println(new Graph().Kruskal(G, edges));

        // DP的测试
        // 最大子数组
        // int[] a = { 100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79,
        // 94, 90, 97 };
        // System.out.println(Max_Subarray.Brutal(a));
        // int[] b = new int[a.length];
        // for (int i = 1; i < b.length; i++) {
        // b[i] = a[i] - a[i - 1];
        // }
        // System.out.println(Max_Subarray.DC(b, 0, b.length - 1));
        // System.out.println(Max_Subarray.DP(a));

        // 爬楼梯
        // Climbing_Stairs.solve(9);

        // Unique Path、Dungeon Game都在Leetcode上过了

        // 切钢条
        // int[] p = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
        // System.out.println(Rod_cutting.Recursion(p, p.length));
        // System.out.println(Rod_cutting.Top_down(p, p.length));
        // System.out.println(Rod_cutting.DP(p));

        // 排列组合
        // System.out.println(Permutation.permutation(new StringBuffer("abcde"), new
        // StringBuffer(" "), 0));
        // System.out.println(Permutation.combination(new StringBuffer("abcde"), new
        // StringBuffer(" "), 0));
        System.out.println(Permutation.coins(new int[] { 1, 2, 5 }, new ArrayList<>(), 18));
    }

    static Vertex r, s, t, u, v, w, x, y, z, a, b, c, d, e, f, g, h, i;
    static Map<Vertex, ArrayList<Vertex>> G;
    static ArrayList<Edge> edges;
    static ArrayList<Vertex> neighbor;

    public static Map<Vertex, ArrayList<Vertex>> createMap_bfs() {
        G = new HashMap<>();
        r = new Vertex('r');
        s = new Vertex('s');
        t = new Vertex('t');
        u = new Vertex('u');
        v = new Vertex('v');
        w = new Vertex('w');
        x = new Vertex('x');
        y = new Vertex('y');
        add(G, r, v);
        add(G, r, s);
        add(G, s, r);
        add(G, s, w);
        add(G, t, w);
        add(G, t, x);
        add(G, t, u);
        add(G, u, t);
        add(G, u, x);
        add(G, u, y);
        add(G, v, r);
        add(G, w, s);
        add(G, w, t);
        add(G, w, x);
        add(G, x, w);
        add(G, x, t);
        add(G, x, u);
        add(G, x, y);
        add(G, y, x);
        add(G, y, u);
        return G;
    }

    public static void createMap_dfs() {
        G = new HashMap<>();
        u = new Vertex('u');
        v = new Vertex('v');
        w = new Vertex('w');
        x = new Vertex('x');
        y = new Vertex('y');
        z = new Vertex('z');
        add(G, u, x);
        add(G, u, v);
        add(G, v, y);
        add(G, w, y);
        add(G, w, z);
        add(G, x, v);
        add(G, y, x);
        add(G, z, z);
    }

    public static void createMap_scc() {
        G = new HashMap<>();
        a = new Vertex('a');
        b = new Vertex('b');
        c = new Vertex('c');
        d = new Vertex('d');
        e = new Vertex('e');
        f = new Vertex('f');
        g = new Vertex('g');
        h = new Vertex('h');
        add(G, a, b);
        add(G, b, e);
        add(G, b, f);
        add(G, b, c);
        add(G, c, g);
        add(G, c, d);
        add(G, d, c);
        add(G, d, h);
        add(G, e, a);
        add(G, e, f);
        add(G, f, g);
        add(G, g, f);
        add(G, g, h);
        add(G, h, h);
    }

    public static void createMap_Kruskal() {
        G = new HashMap<>();
        edges = new ArrayList<>();
        a = new Vertex('a');
        b = new Vertex('b');
        c = new Vertex('c');
        d = new Vertex('d');
        e = new Vertex('e');
        f = new Vertex('f');
        g = new Vertex('g');
        h = new Vertex('h');
        i = new Vertex('i');
        addDou(G, a, b);
        addDou(G, a, h);
        addDou(G, h, b);
        addDou(G, c, b);
        addDou(G, h, i);
        addDou(G, h, g);
        addDou(G, c, i);
        addDou(G, i, g);
        addDou(G, c, d);
        addDou(G, c, f);
        addDou(G, g, f);
        addDou(G, d, f);
        addDou(G, e, d);
        addDou(G, e, f);
        edges.add(new Edge(4, a, b));
        edges.add(new Edge(8, a, h));
        edges.add(new Edge(8, c, b));
        edges.add(new Edge(11, h, b));
        edges.add(new Edge(7, h, i));
        edges.add(new Edge(1, h, g));
        edges.add(new Edge(2, i, c));
        edges.add(new Edge(6, i, g));
        edges.add(new Edge(7, c, d));
        edges.add(new Edge(4, c, f));
        edges.add(new Edge(2, g, f));
        edges.add(new Edge(14, d, f));
        edges.add(new Edge(9, d, e));
        edges.add(new Edge(10, f, e));
    }

    public static void add(Map<Vertex, ArrayList<Vertex>> G, Vertex a, Vertex b) {
        if (!G.containsKey(a)) {
            G.put(a, new ArrayList<>());
        }
        neighbor = G.get(a);
        neighbor.add(b);
    }

    public static void addDou(Map<Vertex, ArrayList<Vertex>> G, Vertex a, Vertex b) {
        if (!G.containsKey(a)) {
            G.put(a, new ArrayList<>());
        }
        neighbor = G.get(a);
        neighbor.add(b);
        if (!G.containsKey(b)) {
            G.put(b, new ArrayList<>());
        }
        neighbor = G.get(b);
        neighbor.add(a);
    }
}

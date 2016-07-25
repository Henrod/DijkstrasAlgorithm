import java.util.*;

class Graph {
	private Vertex[] vertices;
	private HashMap<Vertex, List<Vertex>> adj;
	private HashMap<Vertex, HashMap<Vertex, Integer>> w;

	public Graph(int N, List<Edge> edges) {
		vertices = new Vertex[N];
		adj = new HashMap<>();
		w = new HashMap<>();

		for (int i = 0; i < N; i++) {
			vertices[i] = new Vertex(i + 1);
			adj.put(vertices[i], new LinkedList<>());
			w.put(vertices[i], new HashMap<>());
		}

		for (Edge e : edges) {
			Vertex u = vertices[e.u];
			Vertex v = vertices[e.v];
			adj.get(u).add(v);
			w.get(u).put(v, e.w);
		}
	}

	private int weight(Vertex u, Vertex v) {
		return w.get(u).get(v);
	}

	private List<Vertex> adj(Vertex u) {
		return adj.get(u);
	}

	private void initialize(Vertex s) {
		for (Vertex v : vertices) {
			v.key = Integer.MAX_VALUE;
			v.parent = null;
		}

		s.key = 0;
	}

	public static Vertex[] Dijkstra(Graph graph, int source) {
		Vertex s = graph.vertices[source];
		graph.initialize(s);

		Heap heap = new Heap(graph.vertices.length);
		for (Vertex v : graph.vertices) {
			heap.insert(v);
		}

		while (!heap.isEmpty()) {
			Vertex u = heap.extractMin();
			for (Vertex v : graph.adj(u)) {
				if (v.key > u.key + graph.weight(u, v)) {
					v.key = u.key + graph.weight(u, v);
					v.parent = u;
					heap.decreaseKey(v);
				}
			}
		}

		return graph.vertices;
	}
}

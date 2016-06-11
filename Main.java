import java.util.*;

class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<Vertex> vertices = new LinkedList<Vertex>();

		for (int i = 1; i <= N; i++)
			vertices.add(new Vertex(i));

		HashMap<Vertex, List<Edge>> adj = new HashMap<>();
		for (Vertex v : vertices)
			adj.put(v, new LinkedList<Edge>());

		for (int i = 0; i < M; i++) {
			Vertex src = vertices.get(sc.nextInt() - 1);
			Vertex dst = vertices.get(sc.nextInt() - 1);
			int wei = sc.nextInt();

			adj.get(src).add(new Edge(dst, wei));
		}

		Graph graph = new Graph (adj, vertices);
		graph.dijkstra(1);
		for (Vertex v : vertices) {
			graph.print(v.index);
		}
	}
}

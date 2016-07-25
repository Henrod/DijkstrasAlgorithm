import java.util.*;

class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Edge> edges = new LinkedList<>();

		while (sc.hasNext()) {
			Edge e = new Edge();
			e.u = sc.nextInt() - 1;
			e.v = sc.nextInt() - 1;
			e.w = sc.nextInt();
			edges.add(e);
		}

		Graph graph = new Graph(N, edges);
		for (Vertex v : Graph.Dijkstra(graph, 0))
			System.out.println(v.toString());
	}
}

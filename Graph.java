import java.util.*;

class Graph {
	private HashMap<Vertex, List<Edge>> adj;
	private List<Vertex> vertices;

	public Graph (HashMap<Vertex, List<Edge>> adj, List<Vertex> vertices) {
		this.adj = adj;
		this.vertices = vertices;
	}

	private void initialize_single_source (int s) {
		for (Vertex v : vertices) {
			v.distance = Integer.MAX_VALUE;
			v.parent = null;
		}
		vertices.get(s - 1).distance = 0;
	}

	public void print (int s) {
		Vertex v = vertices.get(s - 1);
		while (v != null) {
			if (v.distance == Integer.MAX_VALUE)
				System.out.print(v.index + ": -1 | ");
			else
				System.out.print(v.index + ": " + v.distance + " | ");
			v = v.parent;
		}
		System.out.println("");
	}

	public void dijkstra (int s) {
		initialize_single_source(s);
		PriorityQueue<Vertex> pq = new PriorityQueue<>(vertices);

		while (!pq.isEmpty()) {
			Vertex u = pq.poll();
			for (Edge e : adj.get(u)) {
				if (e.vertex.distance > u.distance + e.weight) {
					e.vertex.parent = u;
					if (u.distance != Integer.MAX_VALUE) {
						pq.remove(e.vertex);
						e.vertex.distance = u.distance + e.weight;
						pq.offer(e.vertex);
					}
				}
			}
		}
	}
}

class Vertex implements Comparable<Vertex> {
	int key;
	Vertex parent;
	int index;

	public Vertex (int index) {
		this.index = index;
	}

	public int compareTo (Vertex v) {
		return this.key - v.key;
	}

	public String toString() {
		String str = index + ": dist = " + key + ", parent = ";
		if (parent == null)
			return str + "nil";
		return str + parent.index;
	}
}

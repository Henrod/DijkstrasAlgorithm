import java.util.*;

class Heap {
	int size;
	Vertex[] heap;
	HashMap<Vertex, Integer> map;

	public Heap(int N) {
		size = 0;
		heap = new Vertex[N + 1];
		map = new HashMap<>();
	}

	public void insert(Vertex v) {
		heap[++size] = v;
		map.put(v, size);
		swim(size);
	}

	private void swim(int pos) {
		int i = pos;
		while (true) {
			int j = i/2;
			if (j > 0 && heap[j].compareTo(heap[i]) > 0) {
				exch(i, j);
				i = j;
			} else break;
		}
	}

	public Vertex extractMin() {
		Vertex min = heap[1];
		exch(1, size--);
		sink(1);

		return min;
	}

	public void delete(Vertex v) {
		int pos = map.get(v);
		exch(pos, size--);
		heap[size + 1] = null;
		sink(pos);
	}

	private void sink(int pos) {
		int i = pos;
		while (i <= size/2) {
			int j = 2*i;
			if (j < size && heap[j].compareTo(heap[j+1]) > 0) j++;
			if (heap[j].compareTo(heap[i]) < 0) {
				exch(i, j);
				i = j;
			} else break;
		}
	}

	public void decreaseKey(Vertex v) {
		int pos = map.get(v);
		swim(pos);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void exch(int i, int j) {
		Vertex tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;

		map.put(heap[i], i);
		map.put(heap[j], j);
	}
}
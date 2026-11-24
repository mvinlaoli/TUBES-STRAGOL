import java.util.PriorityQueue;

public class Djikstra {

    static class Node implements Comparable<Node> {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        int[][] d = {
            
            { 0,  4,  5,  0,  0,  0}, // A
            { 4,  0, 11,  9,  7,  0}, // B
            { 5, 11,  0,  0,  3,  0}, // C
            { 0,  9,  0,  0, 13,  2}, // D
            { 0,  7,  3, 13,  0,  6}, // E
            { 0,  0,  0,  2,  6,  0}  // F
        };

        int n = d.length;
        int source = 0; // Titik awal A
        int target = 5; // Titik tujuan F

        PriorityQueue<Node> heap = new PriorityQueue<>();

        heap.add(new Node(source, 0));
        
        Node current = heap.poll();

        while (current.node != target) {
            for (int i = 0; i < n; i++) {
                if (d[current.node][i] > 0) {
                    heap.add(new Node(i, current.distance + d[current.node][i]));
                }
            }
            current = heap.poll(); 
        }

        System.out.println("Target tercapai pada Node: " + (char)('A' + current.node));
        System.out.println("Total jarak terpendek : " + current.distance);

    }
}
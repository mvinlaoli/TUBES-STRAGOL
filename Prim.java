import java.util.PriorityQueue;

public class Prim {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {

        // 0=A, 1=B, 2=C, 3=D, 4=E
        int[][] graph = {
            { 0, 2, 6, 0, 0 }, // A
            { 2, 0, 3, 5, 0 }, // B
            { 6, 3, 0, 4, 8 }, // C
            { 0, 5, 4, 0, 7 }, // D
            { 0, 0, 8, 7, 0 }  // E
        };

        int n = graph.length;
        int start = 0; 

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        visited[start] = true;
        int visitedCount = 1;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            if (graph[start][i] > 0) {
                pq.add(new Edge(start, i, graph[start][i]));
            }
        }

        System.out.println("Edge yang dipilih untuk MST:");

        while (visitedCount < n && !pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.to]) {
                continue;
            }

            visited[current.to] = true;
            visitedCount++;
            totalCost += current.weight;

            char fromNode = (char) ('A' + current.from);
            char toNode = (char) ('A' + current.to);
            System.out.println(fromNode + " - " + toNode + " (bobot: " + current.weight + ")");

            for (int next = 0; next < n; next++) {
                if (graph[current.to][next] > 0 && !visited[next]) {
                    pq.add(new Edge(current.to, next, graph[current.to][next]));
                }
            }
        }

        System.out.println("Minimum Total Cost : " + totalCost);
    }
}
public class FloydWarshall {

    static final int INF = 99999;

    public static void main(String[] args) {
        int n = 6; // Jumlah titik (A sampai F)
        String[] namaTitik = {"A", "B", "C", "D", "E", "F"};

        int[][] d = {
            // A    B    C    D    E    F
            {  0,   4,   5, INF, INF, INF }, // A
            {  4,   0,  11,   9,   7, INF }, // B
            {  5,  11,   0, INF,   3, INF }, // C
            {INF,   9, INF,   0,  13,   2 }, // D
            {INF,   7,   3,  13,   0,   6 }, // E
            {INF, INF, INF,   2,   6,   0 }  // F
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
                }
            }
        }

        System.out.println("=== MATRIKS JARAK TERPENDEK (FLOYD-WARSHALL) ===");
        System.out.print("    ");
        for (String nama : namaTitik) {
            System.out.printf("%4s", nama);
        }
        System.out.println("\n--------------------------------");

        for (int j = 0; j < n; j++) {
            System.out.printf("%2s |", namaTitik[j]);
            for (int k = 0; k < n; k++) {
                System.out.printf("%4d", d[j][k]);
            }
            System.out.println();
        }
    }
}
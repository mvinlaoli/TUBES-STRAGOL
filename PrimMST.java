import java.util.PriorityQueue;

public class PrimMST {

    static class Edge implements Comparable<Edge> {
        int asal;
        int tujuan;
        int bobot;

        Edge(int asal, int tujuan, int bobot) {
            this.asal = asal;
            this.tujuan = tujuan;
            this.bobot = bobot;
        }

        @Override
        public int compareTo(Edge lain) {
            if (this.bobot < lain.bobot) {
                return -1;
            }
            if (this.bobot > lain.bobot) {
                return 1;
            }
            return 0;
        }
    }

    static String[] gedung = {"A", "B", "C", "D", "E"};

    public static void main(String[] args) {
        int n = 5;
        int[][] graf = new int[n][n];

        // Bobot kabel antar gedung sesuai slide (0 = tidak ada jalur langsung)
        graf[0][1] = 2; graf[1][0] = 2; // A - B (2)
        graf[0][2] = 6; graf[2][0] = 6; // A - C (6)
        graf[1][2] = 3; graf[2][1] = 3; // B - C (3)
        graf[1][3] = 5; graf[3][1] = 5; // B - D (5)
        graf[2][3] = 4; graf[3][2] = 4; // C - D (4)
        graf[2][4] = 8; graf[4][2] = 8; // C - E (8)
        graf[3][4] = 7; graf[4][3] = 7; // D - E (7)

        prim(graf, n, 0); // Mulai dari gedung A (indeks 0)
    }

    static void prim(int[][] graf, int n, int awal) {
        boolean[] dikunjungi = new boolean[n];
        PriorityQueue<Edge> antrean = new PriorityQueue<>();

        int total = 0;
        int terhubung = 0;

        // 1. Pilih vertex awal
        dikunjungi[awal] = true;
        terhubung = 1;

        for (int g = 0; g < n; g++) {
            if (graf[awal][g] > 0) {
                antrean.add(new Edge(awal, g, graf[awal][g]));
            }
        }

        // 2 & 3. Ambil edge termurah keluar tree, tambah & ulangi sampai semua terhubung
        while (terhubung < n && !antrean.isEmpty()) {
            Edge ambil = antrean.poll();

            // Lewati jika tujuan sudah dikunjungi agar tidak membentuk cycle
            if (dikunjungi[ambil.tujuan]) {
                continue;
            }

            // Masukkan vertex baru ke tree dan tambahkan bobotnya
            dikunjungi[ambil.tujuan] = true;
            terhubung = terhubung + 1;
            total = total + ambil.bobot;

            System.out.println(
                "Dipilih: " + gedung[ambil.asal] + "-" + gedung[ambil.tujuan]
                + " (bobot " + ambil.bobot + ")"
            );

            for (int g = 0; g < n; g++) {
                if (graf[ambil.tujuan][g] > 0 && !dikunjungi[g]) {
                    antrean.add(new Edge(ambil.tujuan, g, graf[ambil.tujuan][g]));
                }
            }
        }

        System.out.println("Total edges: " + (terhubung - 1) + " (n - 1 = " + (n - 1) + ")");
        System.out.println("Minimum Total Cost: " + total);
    }
}
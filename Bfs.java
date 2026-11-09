import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    static String[] namaStasiun = {"A", "B", "C", "D", "E", "F", "G", "H"};

    // Matriks Rel 8x8 (1 = Ada Rel, 0 = Tidak Ada Rel)
    static int[][] rel = {
        // A  B  C  D  E  F  G  H
        {  0, 0, 1, 0, 1, 0, 1, 0 }, // Stasiun A
        {  0, 0, 1, 0, 0, 0, 0, 0 }, // Stasiun B
        {  1, 1, 0, 1, 0, 0, 0, 0 }, // Stasiun C
        {  0, 0, 1, 0, 0, 1, 0, 0 }, // Stasiun D
        {  1, 0, 0, 0, 0, 1, 0, 0 }, // Stasiun E
        {  0, 0, 0, 1, 1, 0, 0, 0 }, // Stasiun F
        {  1, 0, 0, 0, 0, 0, 0, 1 }, // Stasiun G
        {  0, 0, 0, 0, 0, 0, 1, 0 }  // Stasiun H
    };

    static boolean[] sudahDikunjungi = new boolean[8];

    static void telusuriBFS(int stasiunAwal) {
        Queue<Integer> antrean = new LinkedList<>();

       
        sudahDikunjungi[stasiunAwal] = true;
        antrean.add(stasiunAwal);

        System.out.println("=== HASIL URUTAN BFS (PER LAPIS) ===");

        while (!antrean.isEmpty()) {
            int saatIni = antrean.poll();
            System.out.print(namaStasiun[saatIni] + " ");

            for (int tujuan = 0; tujuan < 8; tujuan++) {
                if (rel[saatIni][tujuan] == 1 && !sudahDikunjungi[tujuan]) {
                    sudahDikunjungi[tujuan] = true; 
                    antrean.add(tujuan);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        telusuriBFS(0); 
    }
}
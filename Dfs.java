public class Dfs {

    static String[] namaStasiun = {"A", "B", "C", "D", "E", "F", "G", "H"};

    static int[][] rel = {
        // A  B  C  D  E  F  G  H
        {  0, 0, 1, 0, 1, 0, 1, 0 }, // Stasiun A (0)
        {  0, 0, 1, 0, 0, 0, 0, 0 }, // Stasiun B (1)
        {  1, 1, 0, 1, 0, 0, 0, 0 }, // Stasiun C (2)
        {  0, 0, 1, 0, 0, 1, 0, 0 }, // Stasiun D (3)
        {  1, 0, 0, 0, 0, 1, 0, 0 }, // Stasiun E (4)
        {  0, 0, 0, 1, 1, 0, 0, 0 }, // Stasiun F (5)
        {  1, 0, 0, 0, 0, 0, 0, 1 }, // Stasiun G (6)
        {  0, 0, 0, 0, 0, 0, 1, 0 }  // Stasiun H (7)
    };

    static boolean[] sudahDikunjungi = new boolean[8];

    static void telusuri(int stasiunSaatIni) {
        sudahDikunjungi[stasiunSaatIni] = true;
        System.out.print(namaStasiun[stasiunSaatIni] + " ");

        for (int tujuan = 0; tujuan < 8; tujuan++) {
            
            if (rel[stasiunSaatIni][tujuan] == 1 && !sudahDikunjungi[tujuan]) {
                telusuri(tujuan);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== HASIL PENELUSURAN STASIUN (DFS MATRIKS) ===");
        
        telusuri(0); 
    }
}
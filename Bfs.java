import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Stasiun {
    String nama;
    List<Stasiun> tetangga = new ArrayList<>();
    boolean sudahDikunjungi = false;

    public Stasiun(String nama) {
        this.nama = nama;
    }

    public void hubungkan(Stasiun tujuan) {
        this.tetangga.add(tujuan);
        tujuan.tetangga.add(this);
    }
}

public class Bfs {

    public static void penelusuranBFS(Stasiun stasiunAwal) {
        Queue<Stasiun> antrean = new LinkedList<>();

        
        stasiunAwal.sudahDikunjungi = true;
        antrean.add(stasiunAwal);

        System.out.println("=== HASIL AKHIR URUTAN KUNJUNGAN (BFS) ===");

        while (!antrean.isEmpty()) {
         
            Stasiun saatIni = antrean.poll();
            System.out.print(saatIni.nama + " ");

          
            for (Stasiun t : saatIni.tetangga) {
                if (!t.sudahDikunjungi) {
                    t.sudahDikunjungi = true; 
                    antrean.add(t);           
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stasiun A = new Stasiun("A");
        Stasiun B = new Stasiun("B");
        Stasiun C = new Stasiun("C");
        Stasiun D = new Stasiun("D");
        Stasiun E = new Stasiun("E");
        Stasiun F = new Stasiun("F");
        Stasiun G = new Stasiun("G");
        Stasiun H = new Stasiun("H");

        A.hubungkan(C);
        A.hubungkan(E);
        A.hubungkan(G);
        B.hubungkan(C);
        C.hubungkan(D);
        D.hubungkan(F);
        E.hubungkan(F);
        G.hubungkan(H);

        penelusuranBFS(A);
    }
}
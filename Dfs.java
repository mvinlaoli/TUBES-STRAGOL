import java.util.ArrayList;
import java.util.List;

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

public class Dfs {

    public static void telusuri(Stasiun stasiunSaatIni) {
        stasiunSaatIni.sudahDikunjungi = true;
        System.out.print(stasiunSaatIni.nama + " ");

        for (Stasiun t : stasiunSaatIni.tetangga) {
            if (!t.sudahDikunjungi) {
                telusuri(t); 
            }
        }
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

        
        System.out.println("=== KONEKSI TIAP STASIUN ===");
        Stasiun[] daftarStasiun = {A, B, C, D, E, F, G, H};
        
        for (Stasiun s : daftarStasiun) { 
            System.out.print(s.nama + " -> ");
            for (int i = 0; i < s.tetangga.size(); i++) {
                System.out.print(s.tetangga.get(i).nama);
                if (i < s.tetangga.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("\n=== URUTAN HASIL KUNJUNGAN ===");
        telusuri(A);
    }
}
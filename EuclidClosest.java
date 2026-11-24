import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EuclidClosest {

    
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static double hitungJarak(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

  
    static double cariJarakTerdekat(Point[] points, int left, int right) {
       
        if (right - left <= 2) {
            double minJarak = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    minJarak = Math.min(minJarak, hitungJarak(points[i], points[j]));
                }
            }
            return minJarak;
        }

        
        int mid = (left + right) / 2;
        int medianX = points[mid].x;

        double jarakKiri = cariJarakTerdekat(points, left, mid);
        double jarakKanan = cariJarakTerdekat(points, mid + 1, right);

        
        double R = Math.min(jarakKiri, jarakKanan);

        List<Point> areaTengah = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - medianX) <= R) {
                areaTengah.add(points[i]);
            }
        }

        for (int i = 0; i < areaTengah.size(); i++) {
            for (int j = i + 1; j < areaTengah.size(); j++) {
                double jarakLintasBatas = hitungJarak(areaTengah.get(i), areaTengah.get(j));
                if (jarakLintasBatas < R) {
                    R = jarakLintasBatas; 
                }
            }
        }

        return R;
    }

    public static void main(String[] args) {
        Point[] titik = {
            new Point(2, 7), new Point(3, 6), new Point(10, 7), new Point(6, 4),
            new Point(1, 3), new Point(8, 2), new Point(9, 2), new Point(5, 0)
        };

        Arrays.sort(titik, (a, b) -> Integer.compare(a.x, b.x));

        double jarakTerpendek = cariJarakTerdekat(titik, 0, titik.length - 1);
        System.out.printf("Jarak antar dua titik paling dekat adalah: %.2f\n", jarakTerpendek);
    }
}
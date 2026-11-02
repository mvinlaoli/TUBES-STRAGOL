import java.util.Arrays;
import java.util.Scanner;

public class BigO {

    // 1. O(1) 
    public static int getFirstElement(int[] arr) {
        if (arr.length == 0) return -1;
        return arr[0]; 
    }

    // 2. O(log n)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 3. O(n) 
    public static double average(double[] numbers) {
        double result = 0; 
        for (int i = 0; i < numbers.length; i++) {
            result = result + numbers[i]; 
        }
        
        if (numbers.length > 0) {
            result = result / numbers.length;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("1. O(1)");
            System.out.println("2. O(log n)");
            System.out.println("3. O(n)");
            System.out.println("0. Keluar Program");
            System.out.print("Silakan pilih menu (0-3): ");
            
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Pengujian O(1)");
                    System.out.print("Masukkan jumlah elemen array: ");
                    int n1 = scanner.nextInt();
                    int[] arr1 = new int[n1];
                    
                    System.out.println("Masukkan " + n1 + " angka: ");
                    for (int i = 0; i < n1; i++) {
                        arr1[i] = scanner.nextInt();
                    }
                    
                    if (arr1.length == 0) {
                        System.out.println("Array kosong!");
                    } else {
                        int hasil1 = getFirstElement(arr1);
                        System.out.println("Elemen pertama (O(1)): " + hasil1);
                    }
                    break;

                case 2:
                    System.out.println("Pengujian O(log n)");
                    System.out.print("Masukkan jumlah elemen array: ");
                    int n2 = scanner.nextInt();
                    int[] arr2 = new int[n2];
                    
                    System.out.println("Masukkan " + n2 + " angka: ");
                    for (int i = 0; i < n2; i++) {
                        arr2[i] = scanner.nextInt();
                    }
                    
                    System.out.print("Masukkan angka yang ingin dicari: ");
                    int target = scanner.nextInt();
                    
                    int hasil2 = binarySearch(arr2, target);
                    if (hasil2 != -1) {
                        System.out.println("Data ditemukan pada indeks ke" + hasil2);
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.println("Pengujian O(n)");
                    System.out.print("Masukkan jumlah elemen array desimal: ");
                    int n3 = scanner.nextInt();
                    double[] arr3 = new double[n3];
                    
                    System.out.println("Masukkan " + n3 + " angka desimal: ");
                    for (int i = 0; i < n3; i++) {
                        arr3[i] = scanner.nextDouble();
                    }
                    
                    double hasil3 = average(arr3);
                    System.out.println("Elemen rata-rata (O(n)): " + hasil3);
                    break;

                case 0:
                    System.out.println("Keluar");
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }
}
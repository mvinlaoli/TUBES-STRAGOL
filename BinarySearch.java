public class BinarySearch {
    static int binarySearch(int[] arr, int target) {
        int left = 0;                
        int right = arr.length - 1;   

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1; 
            } 
            else {
                right = mid - 1; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 6, 9, 13, 20, 23, 44, 50, 60};
        int target = 20;

        int hasilIndex = binarySearch(data, target);

        if (hasilIndex == -1) {
            System.out.println("Angka " + target + " tidak ditemukan.");
        } else {
            System.out.println("Angka " + target + " ditemukan pada index ke-" + hasilIndex);
        }
    }
}
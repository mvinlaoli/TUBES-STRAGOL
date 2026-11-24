import java.util.Arrays;

public class MergeSort {
    static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]}; 
        }

       
        int mid = (left + right) / 2;

        int[] leftArr = mergeSort(arr, left, mid);
        int[] rightArr = mergeSort(arr, mid + 1, right);

        return merge(leftArr, rightArr);
    }

    static int[] merge(int[] leftArr, int[] rightArr) {
        int[] merged = new int[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        // Loop 1: Bandingkan elemen terdepan kiri & kanan, masukkan yang lebih kecil
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                merged[mergedIndex++] = leftArr[leftIndex++];
            } else {
                merged[mergedIndex++] = rightArr[rightIndex++];
            }
        }

        // Loop 2: Jika array kanan sudah habis, masukkan sisa elemen array kiri
        while (leftIndex < leftArr.length) {
            merged[mergedIndex++] = leftArr[leftIndex++];
        }

        // Loop 3: Jika array kiri sudah habis, masukkan sisa elemen array kanan
        while (rightIndex < rightArr.length) {
            merged[mergedIndex++] = rightArr[rightIndex++];
        }

        return merged;
    }

    public static void main(String[] args) {
        // Data contoh persis seperti di gambar slide dosen[cite: 6]
        int[] data = {6, 5, 12, 10, 9, 1};

        System.out.println("Sebelum urut : " + Arrays.toString(data));
        int[] hasilUrut = mergeSort(data, 0, data.length - 1);
        System.out.println("Setelah urut : " + Arrays.toString(hasilUrut));
    }
}
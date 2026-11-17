public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4, 5};
        int target = 5;

        int[][] arr = new int[coins.length][target + 1];

        for (int i = 0; i < coins.length; i++) {
            arr[i][0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            int coinValue = coins[i];
            for (int j = 1; j <= target; j++) {
                
                int atas = 0;
                if (i > 0) {
                    atas = arr[i - 1][j];
                }
                
                int samping = 0;
                if (j >= coinValue) {
                    samping = arr[i][j - coinValue];
                }
                
                arr[i][j] = atas + samping;
            }
        }
        
        int hasilAkhir = arr[coins.length - 1][target];
        System.out.println("Jumlah cara untuk mencapai sum " + target + " dengan 5 koin [1, 2, 3, 4, 5] adalah: " + hasilAkhir + " cara.");
    }
}
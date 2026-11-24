public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 5}; 
        int targetSum = 6;          
        int n = coins.length;       // Jumlah koin = 4

        int[][] dp = new int[n + 1][targetSum + 1];

        // Inisialisasi seluruh isi tabel dengan nilai 0
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= targetSum; j++) {
                dp[i][j] = 0;
            }
        }

        //Inisialisasi Basis, kolom sum = 0 pada setiap baris bernilai 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            int koin = coins[i - 1];

            for (int j = 1; j <= targetSum; j++) {
                int atas = dp[i - 1][j];

                int samping = 0;
                if (j >= koin) {
                    samping = dp[i][j - koin];
                }

                dp[i][j] = atas + samping;
            }
        }

        int hasil = dp[n][targetSum];

        System.out.println("Target Sum: " + targetSum);
        System.out.println("Jumlah kombinasi cara: " + hasil);
    }
}
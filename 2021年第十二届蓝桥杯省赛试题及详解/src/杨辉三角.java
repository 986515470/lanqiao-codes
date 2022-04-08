import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Wcy
 * @Date 2022/4/8 16:00
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        // long start = System.currentTimeMillis();

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int len = 44725;
        long[] dp = new long[len];
        dp[0] = 1L;
        long sum = 1L;

        long n = in.nextLong();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < len; i++) {
            int ed = Math.max(1, i / 2);
            for (int j = i; j >= ed; j--) {
                dp[j] += dp[j - 1];
                if (dp[j] == n) {
                    System.out.println(sum + (i - j) + 1);
                    return;
                }
            }
            sum += (i + 1);
        }

        System.out.println(((1 + n) * n / 2) + 2);
        in.close();

        // long finish = System.currentTimeMillis();
        // long timeElapsed = finish - start;
        // System.out.println(timeElapsed / 1000.0);
    }
}

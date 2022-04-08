import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wcy
 * @Date 2022/4/8 16:07
 */
public class 双向排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt(), m = in.nextInt();
        Integer[] arr = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int p = in.nextInt();
            int split = in.nextInt();
            if (p == 0) {
                Arrays.sort(arr, 1, split + 1, (a, b) -> Integer.compare(b, a));
            } else {
                Arrays.sort(arr, split, n + 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }

        in.close();
    }
}

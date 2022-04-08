import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Wcy
 * @Date 2022/4/8 13:37
 */
public class 最少砝码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int num = in.nextInt();
        int sum = 0, pow3 = 1, cnt = 0;

        do {
            sum += pow3;
            pow3 *= 3;
            cnt++;
        } while (sum < num);

        System.out.println(cnt);
        in.close();
    }
}

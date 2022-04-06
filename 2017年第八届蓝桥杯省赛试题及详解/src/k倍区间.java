/**
 * @author Wcy
 * @Date 2022/4/2 18:06
 */

import java.util.Scanner;

/**
 *给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。
 *
 * 你能求出数列中总共有多少个K倍区间吗？
 *
 * 输入
 * -----
 * 第一行包含两个整数N和K。(1 <= N, K <= 100000)
 * 以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)
 *
 * 输出
 * -----
 * 输出一个整数，代表K倍区间的数目。
 *
 *
 * 例如，
 * 输入：
 * 5 2
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * 程序应该输出：
 * 6
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 2000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 */
public class k倍区间 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++)
            sum[i] = sum[i-1] + in.nextInt();

        int ans = 0;

        for(int i=1;i<=n;i++)
            for(int j=0;j+i<=n;j++)
                if((sum[j+i]-sum[j])%k==0)
                    ans++;

        System.out.println(ans);

    }

    //求两个数最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    //求两个数最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }



}

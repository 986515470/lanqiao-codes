/**
 * @author Wcy
 * @Date 2022/4/8 13:21
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图 中的最短路径。
 * 小蓝的图由 2021 个结点组成，依次编号 1 至 2021。
 * 对于两个不同的结点 a, b，如果 a 和 b 的差的绝对值大于 21，
 * 则两个结点 之间没有边相连；如果 a 和 b 的差的绝对值小于等于 21，
 * 则两个点之间有一条 长度为 a 和 b 的最小公倍数的无向边相连
 * 例如：结点 1 和结点 23 之间没有边相连；
 * 结点 3 和结点 24 之间有一条无向边，长度为 24；
 * 结点 15 和结点 25 之间有一条无向边，长度为 75。
 * <p>
 * 请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
 */
public class 路径 {
    static int[][] graph = new int[2050][2050];
    static final int INF = 0x3f3f3f3f;

    private static void floyd() {
        for (int k = 1; k <= 2021; k++) {
            for (int i = 1; i <= 2021; i++) {
                for (int j = 1; j <= 2021; j++) {
                    if (i != j && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 2021; i++) {
            for (int j = 1; j <= 2021; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 1; i <= 2021; i++) {
            int st = Math.max(i - 21, 1);
            for (int j = st; j <= i; j++) {
                int div = gcd(j, i);
                int lcm = i * j / div;
                graph[i][j] = lcm;
                graph[j][i] = lcm;
            }
        }

        floyd();

        System.out.println(graph[1][2021]); // 10266837
    }
}

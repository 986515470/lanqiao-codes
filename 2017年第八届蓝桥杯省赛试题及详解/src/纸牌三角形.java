/**
 * @author Wcy
 * @Date 2022/4/2 15:39
 */

/**
 * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
 * 下图就是一种排法（如有对齐问题，参看p1.png）。
 * <p>
 * A          1
 * 9 6       2  3
 * 4   8     4    5
 * 3 7 5 2   6 7  8 9
 * <p>
 * 这样的排法可能会有很多。
 * <p>
 * 如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
 * <p>
 * 请你计算并提交该数字。
 * <p>
 * 注意：需要提交的是一个整数，不要提交任何多余内容。
 */
public class 纸牌三角形 {
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int total = 0;

    public static void main(String[] args) {
        dfs(0);
        System.out.println(total / 6);
    }

    public static void dfs(int m) {
        if (m >= 9) {
            if (a[0] + a[1] + a[3] + a[5] == a[0] + a[2] + a[4] + a[8] && a[0] + a[1] + a[3] + a[5] == a[5] + a[6] + a[7] + a[8] && a[0] + a[2] + a[4] + a[8] == a[5] + a[6] + a[7] + a[8]) {
                total++;
            }
        }
        for (int i = m; i < 9; i++) {
            swap(i, m);
            dfs(m + 1);
            swap(i, m);
        }

    }

    public static void swap(int i, int j) {
        int ju = a[i];
        a[i] = a[j];
        a[j] = ju;

    }
}

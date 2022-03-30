package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 20:18
 */

import java.util.Scanner;

/**
 * 问题描述
 * 　　小蓝有一个插板，形状用一个 n * m 的01矩阵表示，0 表示板面，1 表示插孔。
 * 　　小蓝还有一个插头，形状用一个 r * c 的01矩阵表示，0 表示没有伸出的部分，1 表示伸出的部分。插头伸出的部分必须插在插孔里面。
 * 　　为了安全，插头插到面板上不能有任何部分超过插板边界（包括没有伸出的部分）。
 * 　　插头和插板都不能旋转，也不能翻转。请求出插头插入插板的合理位置。
 * 输入格式
 * 　　输入的第一行包含两个整数 n, m。
 * 　　接下来 n 行，每行一个长度为 m 的01串，表示插板的形状。
 * 　　接下来一行包含两个整数 r, c。
 * 　　接下来 r 行，每行一个长度为 c 的01串，表示插头的形状。
 * 输出格式
 * 　　如果插头没办法安全插入插板中，输出“NO”。否则输出两个数 a, b，表示插头的第 1 行第 1 列对应插板的第 a 行第 b 列。如果有多种情况满足要求，输出 a 最小的方案，如果 a 最小的方案有多个，输出在 a 最小的前提下 b 最小的方案。
 * 样例输入
 * 3 4
 * 0 1 1 0
 * 0 0 0 0
 * 0 0 0 0
 * 3 3
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 样例输出
 * NO
 * 样例说明
 * 　　在插头不超出范围的前提下无法插入。
 * 样例输入
 * 4 7
 * 1 1 1 0 1 0 0
 * 1 1 0 1 1 1 1
 * 0 0 0 1 1 1 1
 * 0 0 0 0 0 1 1
 * 2 3
 * 1 1 1
 * 0 1 1
 * 样例输出
 * 2 4
 * 评测用例规模与约定
 * 　　对于 50% 的评测用例，2 <= n, m, r, c <= 20。
 * 　　对于所有评测用例，2 <= n, m, r, c <= 100。
 */
public class 插头问题 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] cb = new int[a][b];
        for (int i = 0; i < a; i++)
            for (int j = 0; j < b; j++)
                cb[i][j] = scanner.nextInt();

        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int[][] ct = new int[c][d];
        if (c > a || d > b) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < c; i++)
            for (int j = 0; j < d; j++)
                ct[i][j] = scanner.nextInt();
        //暴力匹配
        int de = c * d;
        int add = 0;
        String str = "NO";
        for (int i = 0; i < a; i++) {
            if (a - i < c) break;
            for (int j = 0; j < b; j++) {
                if (b - j < d) break;

                if (ct[0][0] == cb[i][j]) {

                    for (int z = 0; z < c; z++)
                        for (int n = 0; n < d; n++) {

                            if (ct[z][n] == cb[i + z][j + n] || (ct[z][n] == 0 && cb[i + z][j + n] == 1)) {
                                add++;
                                if (add == de) {
                                    str = i + " " + j;
                                }

                            } else {
                                break;
                            }
                        }
                }
                add=0;

            }

        }
        System.out.println(str);
    }
}

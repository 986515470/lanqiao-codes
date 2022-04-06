/**
 * @author Wcy
 * @Date 2022/4/6 19:49
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【问题描述】
 * 给定 N 个加号、M 个减号以及 N + M + 1 个整数 A1, A2, · · · , AN+M+1，小
 * 明想知道在所有由这 N 个加号、M 个减号以及 N + M + 1 个整数凑出的合法的
 * 后缀表达式中，结果最大的是哪一个？
 * 请你输出这个最大的结果。
 * 例如使用1 2 3 + -，则 “2 3 + 1 -” 这个后缀表达式结果是 4，是最大的。
 * 【输入格式】
 * 第一行包含两个整数 N 和 M。
 * 第二行包含 N + M + 1 个整数 A1, A2, · · · , AN+M+1。
 * 【输出格式】
 * 输出一个整数，代表答案。
 * 【样例输入】
 * 1 1
 * 1 2 3
 * 【样例输出】
 * 4
 * 【评测用例规模与约定】
 * 对于所有评测用例，0 ≤ N, M ≤ 100000，−109 ≤ Ai ≤ 109。
 *
 * 思路：
 * 因为只有加减，故加上所有最大值，减去所有最小值即为最大解
 */
public class 后缀表达式 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[n+m+1];
        for(int i = 0; i < n+m+1; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        for(int i=0,j=n+m; i<=n; i++,j--){
            sum+=a[j];
        }
        for(int i=0,j=m-1; i<m; i++,j--){
            sum-=a[j];
        }
        System.out.println(sum);

    }
}

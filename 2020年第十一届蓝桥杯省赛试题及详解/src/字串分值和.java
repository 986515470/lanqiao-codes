/**
 * @author Wcy
 * @Date 2022/4/6 21:26
 */

import java.util.Scanner;

/**
 * 【问题描述】
 * 对于一个字符串 S，我们定义 S 的分值 f(S) 为 S 中出现的不同的字符个
 * 数。例如 f(”aba”) = 2，f(”abc”) = 3, f(”aaa”) = 1。
 * 现在给定一个字符串 S[0…n − 1]（长度为 n），请你计算对于所有 S 的非空
 * 子串 S[i…j](0 ≤ i ≤ j < n)，f(S[i…j]) 的和是多少。
 *
 * 【输入格式】
 * 输入一行包含一个由小写字母组成的字符串 S。
 *
 * 【输出格式】
 * 输出一个整数表示答案。
 *
 * 【样例输入】
 * ababc
 *
 * 【样例输出】
 * 28
 *
 * 【样例说明】
 * 子串 f值
 * a 1
 * ab 2
 * aba 2
 * abab 2
 * ababc 3
 * b 1
 * ba 2
 * bab 2
 * babc 3
 * a 1
 * ab 2
 * abc 3
 * b 1
 * bc 2
 * c 1
 *
 * 【评测用例规模与约定】
 * 对于 20% 的评测用例，1 ≤ n ≤ 10；
 * 对于 40% 的评测用例，1 ≤ n ≤ 100；
 * 对于 50% 的评测用例，1 ≤ n ≤ 1000；
 * 对于 60% 的评测用例，1 ≤ n ≤ 10000；
 * 对于所有评测用例，1 ≤ n ≤ 100000。
 * 时间限制: 1.0s 内存限制: 256.0MB
 *
 * 思路
 * 先实现功能函数f(S)；再遍历字符串，通过substr(start_pos, length)获取不同的子字符串。
 */
public class 字串分值和 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str =cin.next();
        cin.close();
        int[] a = new int[30];

        long ans = 0;
        int n = str.length();
        str = " " + str;
        for(int i=1;i<=n;++i) {
            ans+=(i-a[str.charAt(i)-'a'])*(long)1*(n-i+1);
            a[str.charAt(i)-'a']=i;
        }
        System.out.println(ans);
    }
}

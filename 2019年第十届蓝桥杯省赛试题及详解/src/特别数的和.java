/**
 * @author Wcy
 * @Date 2022/4/6 19:46
 */

import java.util.Scanner;

/**
 * 【问题描述】
 * 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到
 * 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
 * 请问，在 1 到 n 中，所有这样的数的和是多少？
 * 【输入格式】
 * 输入一行包含两个整数 n。
 * 【输出格式】
 * 输出一行，包含一个整数，表示满足条件的数的和。
 * 【样例输入】
 * 40
 * 【样例输出】
 * 574
 * 【评测用例规模与约定】
 * 对于 20% 的评测用例，1 ≤ n ≤ 10。
 * 对于 50% 的评测用例，1 ≤ n ≤ 100。
 * 对于 80% 的评测用例，1 ≤ n ≤ 1000。
 * 对于所有评测用例，1 ≤ n ≤ 10000。
 *
 * 思路
 * 和第二题思路一样，一次遍历把整数转换成字符串来判断是否右2，0，1，9
 */
public class 特别数的和 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long sum = (long) 0;
        for(int i = 1; i <= n; i++) {
            if(String.valueOf(i).contains("1")||String.valueOf(i).contains("2")||String.valueOf(i).contains("9")||String.valueOf(i).contains("0")) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}

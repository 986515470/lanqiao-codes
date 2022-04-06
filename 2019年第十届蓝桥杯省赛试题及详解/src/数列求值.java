/**
 * @author Wcy
 * @Date 2022/4/6 19:44
 */

/**
 * 【问题描述】
 * 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求
 * 第 20190324 项的最后 4 位数字。
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个 4 位整数（提示：答案的千位不为 0），在提交答案时只填写这个整数，填写
 * 多余的内容将无法得分。
 *
 * 思路：定义三个常量不停交换之间的值，三位数的合对10000取模
 */
public class 数列求值 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int a = 1,b = 1,c = 1;
        for (int i = 4; i <= 20190324; i++) {
            int temp = (a + b + c) % 10000;
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(c);

    }
}

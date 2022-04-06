/**
 * @author Wcy
 * @Date 2022/4/6 19:56
 */

/**
 * 【问题描述】
 * 如果一个分数的分子和分母的最大公约数是 1，这个分数称为既约分数。
 * 例如， 3/4 , 5/2 , 1/8 , 7/1 都是既约分数。
 * 请问，有多少个既约分数，分子和分母都是 1 到 2020 之间的整数（包括 1
 * 和 2020）？
 *
 * 【答案提交】
 * 这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
 * 整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 即约分数 {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2020; i++) {
            for (int j = 1; j <= 2020; j++) {
                if (gcd(i, j) == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //求两个数最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

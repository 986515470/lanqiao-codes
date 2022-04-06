/**
 * @author Wcy
 * @Date 2022/4/6 20:58
 */

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 2020 年春节期间，有一个特殊的日期引起了大家的注意：2020 年 2 月 2
 * 日。因为如果将这个日期按 “yyyymmdd” 的格式写成一个 8 位数是 20200202，
 * 恰好是一个回文数。我们称这样的日期是回文日期。
 * 有人表示 20200202 是 “千年一遇” 的特殊日子。对此小明很不认同，因为
 * 不到 2 年之后就是下一个回文日期：20211202 即 2021 年 12 月 2 日。
 * 也有人表示 20200202 并不仅仅是一个回文日期，还是一个 ABABBABA
 * 型的回文日期。对此小明也不认同，因为大约 100 年后就能遇到下一个
 * ABABBABA 型的回文日期：21211212 即 2121 年 12 月 12 日。算不上 “千
 * 年一遇”，顶多算 “千年两遇”。
 * 给定一个 8 位数的日期，请你计算该日期之后下一个回文日期和下一个
 * ABABBABA 型的回文日期各是哪一天。
 * <p>
 * 【输入格式】
 * 输入包含一个八位整数 N，表示日期。
 * <p>
 * 【输出格式】
 * 输出两行，每行 1 个八位数。第一行表示下一个回文日期，第二行表示下
 * 一个 ABABBABA 型的回文日期。
 * <p>
 * 【样例输入】
 * 20200202
 * <p>
 * 【样例输出】
 * 20211202
 * 21211212
 * <p>
 * 【评测用例规模与约定】
 * 对于所有评测用例，10000101 ≤ N ≤ 89991231，保证 N 是一个合法日期的
 * 8 位数表示。
 * 时间限制: 1.0s 内存限制: 256.0MB
 * <p>
 * 思路
 * 本题的关键在于先要判断是否为合法日期。如果是合法日期，再依次判断是否为回文日期和ABABBABA 型的回文日期。
 */
public class 回文日期 {
    static boolean check(int x) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            format.setLenient(false);
            format.parse(String.valueOf(x));

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //判断回文数
    static boolean hui(int x) {
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] != c[c.length - i - 1])
                return false;
        }
        if (!check(x))//不是合法的
            return false;
        return true;
    }

    //是回文，是否ABAB BABA 型
    static boolean aba(int x) {
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        int len = c.length;
        //是回文，检查一半就行
        for (int i = 0; i < len / 2 - 2; i++) {
            if (c[i] != c[i + 2])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 0;//控制只输出一个回文
        for (int i = n + 1; i <= 99999999; i++) {
            if (hui(i)) {
                if (f == 0)//只输出第一个
                    System.out.println(i);
                f = 1;
                if (aba(i)) {//是否为题目要求得类型
                    System.out.println(i);
                    return;
                }
            }
        }
    }


}

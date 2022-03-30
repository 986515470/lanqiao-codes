/**
 * @author Wcy
 * @Date 2022/3/28 15:59
 */

import java.util.Arrays;

/**
 * A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
 * 要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
 * <p>
 * 请填写出所有符合要求的排列中，字典序最小的那个。
 * <p>
 * 例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
 * <p>
 * <p>
 * 请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。
 */
//2342A3A4
public class 扑克序列 {
    // A比2大  所有A>=5
    public static String result = "AAAAAAAA";

    // 排列
    public static void f(char[] a, int k) {
        if (k == a.length - 1) {
            work(a);
            return;
        } else {
            for (int i = k; i < a.length; i++) {
                {
                    char t = a[k];
                    a[k] = a[i];
                    a[i] = t;
                }
                f(a, k + 1);
                {
                    char t = a[k];
                    a[k] = a[i];
                    a[i] = t;
                }
            }
        }
        return;
    }

    // 筛选符合题意的
    public static void work(char[] a) {
        char temp1 = 'A', temp2 = '2', temp3 = '3', temp4 = '4';
        int dA = distance(a, temp1);
        int d2 = distance(a, temp2);
        int d3 = distance(a, temp3);
        int d4 = distance(a, temp4);
        // 两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌
        if (dA == 1 && d2 == 2 && d3 == 3 && d4 == 4) {
            String A = "";
            for (int i = 0; i < a.length; i++) {
                A += a[i];
            }
            if (A.compareTo(result) < 0)
                result = A;
            return;
        }
    }

    // 计算相同字符之间的距离
    public static int distance(char[] a, char temp) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == temp && a[j] == temp) {
                    return j - (i + 1);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        f("AA223344".toCharArray(), 0);
        System.out.println(result);
    }


}

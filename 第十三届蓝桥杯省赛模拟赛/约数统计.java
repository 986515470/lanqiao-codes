package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 21:12
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 问题描述
 * 　　给定正整数 a, b, c，请问有多少个正整数，是其中至少两个数的约数。
 * 输入格式
 * 　　输入一行包含三个正整数 a, b, c。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 30 70 35
 * 样例输出
 * 6
 * 样例说明
 * 　　1、2、5、7、10、35满足条件。
 * 评测用例规模与约定
 * 　　对于 50% 的评测用例，1 <= a, b, c <= 1000000。
 * 　　对于所有评测用例，a, b, c 不超过 10**12（10的12次方）。
 */
public class 约数统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        result.addAll(yue(a, b));
        result.addAll(yue(a, c));
        result.addAll(yue(c, b));
        HashSet<Integer> set=new HashSet<>(result);
//        System.out.println(set.toString());
        System.out.println(set.size());
    }

    public static List<Integer> yue(int a, int b) {
        List<Integer> list = new ArrayList<>();
        int min = Math.min(a, b);
        for (int i = 1; i <=min; i++) {
            if (a % i == 0 && b % i == 0)
                list.add(i);
        }
        return list;

    }
}

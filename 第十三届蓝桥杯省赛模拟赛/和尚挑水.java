package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 19:57
 */

import java.util.Scanner;

/**
 * 问题描述
 * 　　一个和尚要挑水，每次最多能挑 a 千克，水缸最多能装 t 千克，开始时水缸为空。
 * 　　请问这个和尚最少要挑多少次可以将水缸装满？
 * 输入格式
 * 　　输入一行包含两个整数 a, t，用一个空格分隔。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 20 2021
 * 样例输出
 * 102
 * 评测用例规模与约定
 * 　　对于所有评测用例，1 <= a <= 100，1 <= t <= 10000。
 */
public class 和尚挑水 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int aa=b%a;
        System.out.println(Integer.parseInt(String.valueOf((b-aa)/a+1)));
    }
}

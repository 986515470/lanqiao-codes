/**
 * @author Wcy
 * @Date 2022/4/8 13:34
 */

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 小蓝要和朋友合作开发一个时间显示的网站。
 * 在服务器上，朋友已经获取 了当前的时间，
 * 用一个整数表示，值为从 1970 年 1 月 1 日 00:00:00 到当前时 刻经过的毫秒数。
 *
 * 现在，小蓝要在客户端显示出这个时间。
 * 小蓝不用显示出年月日，只需要 显示出时分秒即可，毫秒也不用显示，直接舍去即可。
 *
 * 给定一个用整数表示的时间，请将这个时间对应的时分秒输出。
 * 输入格式
 * 输入一行包含一个整数，表示时间。
 * 输出格式
 * 输出时分秒表示的当前时间，格式形如 HH:MM:SS，
 * 其中 HH 表示时，值 为 0 到 23，
 * MM 表示分，值为 0 到 59，
 * SS 表示秒，值为 0 到 59。
 * 时、分、秒 不足两位时补前导 0。
 * 样例输入 1
 * 46800999
 * 样例输出 1
 * 13:00:00
 */
public class 时间限制 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        long ms = in.nextLong();

        long hour_div = 60 * 60 * 1000;
        long min_div = 60 * 1000;

        // 保证小时在 [0, 23] 之内
        long hour = (ms / hour_div) % 24;
        ms %= hour_div;
        long min = ms / min_div;
        ms %= min_div;
        long sec = ms / 1000;

        System.out.printf("%02d:%02d:%02d\n", hour, min, sec);
        in.close();
    }
}

package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 20:02
 */

import java.util.Scanner;

/**
 * 问题描述
 * 　　在金融领域，通常将金额的百位和千位之间、十万位和百万位之间增加逗号（千分位分隔符），以方便阅读。一般从个位开始，每三位之前增加一个逗号。
 * 　　例如：1234567890.00 通常写成 1,234,567,890.00。
 * 　　注意小数点后固定保留 2 位。
 * 　　给定一个包含千分位分隔符的数值，请读入后输出对应的不含千分位的数值，小数点仍然保留 2 位。
 * 输入格式
 * 　　输入一行包含一个由千分位分隔符的数值，恰好有 2 位小数。
 * 输出格式
 * 　　输出不含千分位分隔符的数值，保留 2 位小数。
 * 样例输入
 * 1,234,567,890.00
 * 样例输出
 * 1234567890.00
 * 评测用例规模与约定
 * 　　对于所有评测用例，给定的数值整数部分不超过12位。
 */
public class 增加逗号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
        str=str.replace(",","");
        System.out.println(str);
    }
}

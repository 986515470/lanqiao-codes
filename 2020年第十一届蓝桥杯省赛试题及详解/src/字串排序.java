/**
 * @author Wcy
 * @Date 2022/4/6 21:30
 */

import java.util.Scanner;

/**
 * 小蓝最近学习了一些排序算法，其中冒泡排序让他印象深刻。
 *
 *
 *
 * 在冒泡排序中，每次只能交换相邻的两个元素。
 *
 *
 *
 * 小蓝发现，如果对一个字符串中的字符排序，只允许交换相邻的两个字符，则在所有可能的排序方案中，冒泡排序的总交换次数是最少的。
 *
 *
 *
 * 例如，对于字符串 lan 排序，只需要 1次交换。对于字符串 qiao 排序，总共需要4次交换。
 *
 *
 *
 * 小蓝的幸运数字是 ，他想找到一个只包含小写英文字母的字符串，对这个串中的字符进行冒泡排序，正好需要V 次交换。请帮助小蓝找一个这样的字符串。如果可能找到多个，请告诉小蓝最短的那个。如果最短的仍然有多个，请告诉小蓝字典序最小的那个。请注意字符串中可以包含相同的字符。
 */
public class 字串排序 {
    public static void bubble_sort(char [] c) {
        /*
         * 双指针一左（j）一右（i）
         * 如果c[j] > c[j + 1]，则交换i、j所指元素且i ++、 j ++
         * 否则
         *
         */
        int n = c.length;
        int cnt = 0; //交换次数
        for(int i = 0; i < n - 1; i ++) {
            for( int j = 0; j < n - 1 - i; j ++) {
                if( c[j] > c[j + 1]) {
                    char tmp = c[j + 1];
                    c[j + 1] = c[j];
                    c[j] = tmp;
                    cnt ++;
                }
            }
        }

        System.out.println(new String(c));
        System.out.println(cnt);


    }

    public static void main(String[] args) {
        //abcdefghijklmno
        char c[] = "jonmlkihgfedcba".toCharArray();
        //char c[] = "onmlkjihgfedcba".toCharArray();
        bubble_sort(c);

    }

}

/**
 * @author Wcy
 * @Date 2022/4/6 19:48
 */

import java.util.Scanner;

/**
 * 【问题描述】
 * 小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob
 * 有多少次同时出现。
 * 更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本
 * 中 Alice 和 Bob 之间不超过 K 个字符。
 * 例如以下文本：
 * This is a story about Alice and Bob. Alice wants to send a private message to Bob.
 * 假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob”
 * 和”Bob. Alice”。前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
 * 注意:
 *
 * Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。
 * Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能
 * 有字母。例如 Bobbi 並不算出现了 Bob。
 * 【输入格式】
 * 第一行包含一个整数 K。
 * 第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超
 * 过 1000000。
 * 【输出格式】
 * 输出一个整数，表示 Alice 和 Bob 同时出现的次数。
 * 【样例输入】
 * 20
 * This is a story about Alice and Bob. Alice wants to send a private message to Bob.
 * 【样例输出】
 * 2
 * 【评测用例规模与约定】
 * 对于所有评测用例，1 ≤ K ≤ 1000000。
 * 思路：
 * 找出所有符合题意的单独单词进行比较绝对值。 通过indexOf(String str,int fromIndex)不断跟新fromindex从而找出所有的符合题意的单词
 */
public class 人物相关性分析 {
    //This is a story about Alice and Bob. Alice wants to send a private message to Bob.
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String tempString = scanner.nextLine();//吃掉回车
        String s = scanner.nextLine();
        int left = -5, right = -3;
        int[] lefts = new int[100000];//记录所有的Alice的坐标
        int[] rights = new int[100000];//记录所有的Bob的坐标
        int sum = 0;
        int indexa = 0, indexb = 0;
        while(true){

            left = s.indexOf("Alice", left+5);
            if(left == -1) {
                break;
            }
            //System.out.println(left);
            if(!judge(s, left, 5)) {
                continue;
            }else {
                lefts[indexa++] = left;
            }
        }
        while(true){
            right = s.indexOf("Bob", right+3);
            if(right == -1) {
                break;
            }
            if(!judge(s, right, 3)) {
                continue;
            }else {
                rights[indexb++] = right;
            }
        }

        for(int i = 0; i < indexa; i++) {
            for(int j = 0; j < indexb; j++) {
                if(Math.abs(lefts[i]-rights[j]) <= n) {
                    sum++;
                }
                if(lefts[i] - rights[j] <= n*(-1)) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    //对找到了Alice和Bob进行判断是否是独立单词
    public static Boolean judge(String s, int index, int length) {
        if(index == 0) {
            ;
        }else {
            if((s.charAt(index-1) >= 65 && s.charAt(index-1) <= 90) || (s.charAt(index-1) >= 97 && s.charAt(index-1) <= 122)) {
                return false;
            }
        }
        if(index+length == s.length()) {
            ;
        }else {
            if((s.charAt(index-1) >= 65 && s.charAt(index-1) <= 90) || (s.charAt(index-1) >= 97 && s.charAt(index-1) <= 122)) {
                return false;
            }
        }
        return true;
    }

}

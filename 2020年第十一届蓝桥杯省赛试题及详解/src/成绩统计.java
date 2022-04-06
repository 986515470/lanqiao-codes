/**
 * @author Wcy
 * @Date 2022/4/6 20:40
 */

import java.util.Scanner;

/**
 * 【问题描述】
 * 小蓝给学生们组织了一场考试，卷面总分为 100 分，每个学生的得分都是
 * 一个 0 到 100 的整数。
 * 如果得分至少是 60 分，则称为及格。如果得分至少为 85 分，则称为优秀。
 * 请计算及格率和优秀率，用百分数表示，百分号前的部分四舍五入保留整
 * 数。
 * <p>
 * 【输入格式】
 * 输入的第一行包含一个整数 n，表示考试人数。
 * 接下来 n 行，每行包含一个 0 至 100 的整数，表示一个学生的得分。
 * <p>
 * 【输出格式】
 * 输出两行，每行一个百分数，分别表示及格率和优秀率。百分号前的部分
 * 四舍五入保留整数。
 * <p>
 * 【样例输入】
 * 7
 * 80
 * 92
 * 56
 * 74
 * 88
 * 100
 * 0
 * <p>
 * 【样例输出】
 * 71%
 * 43%
 * <p>
 * 【评测用例规模与约定】
 * 对于 50% 的评测用例，1 ≤ n ≤ 100。
 * 对于所有评测用例，1 ≤ n ≤ 10000。
 * <p>
 * 时间限制: 1.0s 内存限制: 256.0MB
 */
public class 成绩统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        int num1 = 0;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            if (score >= 60) {
                num++;
            }
            if (score >= 85) {
                num1++;
            }
        }
        String s = num * 100.0 / n + 0.5 + "%";
        String s1 = num1 * 100.0 / n + 0.5 + "%";
        System.out.println(s);
        System.out.println(s1);
    }
}

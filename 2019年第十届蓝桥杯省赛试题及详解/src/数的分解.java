/**
 * @author Wcy
 * @Date 2022/4/6 19:44
 */

/**
 * 【问题描述】
 * 把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包
 * 含数字 2 和 4，一共有多少种不同的分解方法？
 * 注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和
 * 1001+1000+18 被视为同一种。
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 思路
 * 1.每个正整数都不包含数字 2 和 4。
 * 2.交换 3 个整数的顺序被视为同一种方法。
 * 对于条件1，可以自己写一个函数将数字逐位分解，在判断是否是2或4，
 * 也可以将数字转换为字符串，利用String类的contains方法判断字符串中是否
 * 存在子串“2”或“4”。这里使用的是第二种方法。
 * 对于条件2，只要保证三个数是从小到大排列的，那么就不会出现重复问题。
 */
public class 数的分解 {
    public static void main(String[] args) {
        int sum = 0;
        String str;
        //2019/3=673 只要保证三个数是从小到大排列的，那么就不会出现重复问题
        for (int i = 1; i < 673; i++) {
            //以便于使用String类中的contains方法
            str = String.valueOf(i);
            if (str.contains("2") || str.contains("4")) continue;
            //(2019-i+1)/2考虑了2019-i是奇偶数两种情况下，都该是
            //j < (2019-i+1)/2能取得j的最大值
            for (int j = i+1; j < (2019-i+1)/2; j++) {
                str = String.valueOf(j);
                if (str.contains("2") || str.contains("4")) continue;
                str = String.valueOf(2019-i-j);
                if (str.contains("2") || str.contains("4")) continue;
                sum++;
            }
        }
        System.out.println(sum);
    }
}

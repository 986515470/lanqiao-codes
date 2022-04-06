/**
 * @author Wcy
 * @Date 2022/4/6 19:50
 */

import java.util.Scanner;

/**
 * 【题目背景】
 * 在游戏《星际争霸 II》中，高阶圣堂武士作为星灵的重要 AOE 单位，在
 * 游戏的中后期发挥着重要的作用，其技能”灵能风暴“可以消耗大量的灵能对
 * 一片区域内的敌军造成毁灭性的伤害。经常用于对抗人类的生化部队和虫族的
 * 刺蛇飞龙等低血量单位。
 * 【问题描述】
 * 你控制着 n 名高阶圣堂武士，方便起见标为 1, 2, · · · , n。每名高阶圣堂武士
 * 需要一定的灵能来战斗，每个人有一个灵能值 ai 表示其拥有的灵能的多少（ai
 * 非负表示这名高阶圣堂武士比在最佳状态下多余了 ai 点灵能，ai 为负则表示这
 * 名高阶圣堂武士还需要 −ai 点灵能才能到达最佳战斗状态）。现在系统赋予了
 * 你的高阶圣堂武士一个能力，传递灵能，每次你可以选择一个 i ∈ [2, n − 1]，若
 * ai ≥ 0 则其两旁的高阶圣堂武士，也就是 i − 1、i + 1 这两名高阶圣堂武士会从
 * i 这名高阶圣堂武士这里各抽取 ai 点灵能；若 ai < 0 则其两旁的高阶圣堂武士，
 * 也就是 i − 1, i + 1 这两名高阶圣堂武士会给 i 这名高阶圣堂武士 −ai 点灵能。形
 * 式化来讲就是 ai−1+ = ai, ai+1+ = ai, ai− = 2ai。
 * 灵能是非常高效的作战工具，同时也非常危险且不稳定，一位高阶圣堂
 * 武士拥有的灵能过多或者过少都不好，定义一组高阶圣堂武士的不稳定度为
 * maxni=1|ai|，请你通过不限次数的传递灵能操作使得你控制的这一组高阶圣堂武
 * 士的不稳定度最小。
 * 【输入格式】
 * 本题包含多组询问。输入的第一行包含一个正整数 T 表示询问组数。
 * 接下来依次输入每一组询问。
 * 每组询问的第一行包含一个正整数 n，表示高阶圣堂武士的数量。
 * 接下来一行包含 n 个数 a1, a2, · · · , an。
 * 【输出格式】
 * 输出 T 行。每行一个整数依次表示每组询问的答案。
 * 【样例输入】
 * 3
 * 3
 * 5 -2 3
 * 4
 * 0 0 0 0
 * 3
 * 1 2 3
 * 【样例输出】
 * 3
 * 0
 * 3
 * 【样例说明】
 * 对于第一组询问：
 * 对 2 号高阶圣堂武士进行传输操作后 a1 = 3，a2 = 2，a3 = 1。答案为 3。
 * 对于第二组询问：
 * 这一组高阶圣堂武士拥有的灵能都正好可以让他们达到最佳战斗状态。
 * 【样例输入】
 * 3
 * 4
 * -1 -2 -3 7
 * 4
 * 2 3 4 -8
 * 5
 * -1 -1 6 -1 -1
 * 【样例输出】
 * 5
 * 7
 * 4
 * 【样例输入】
 * 见文件trans3.in。
 * 【样例输出】
 * 见文件trans3.ans。
 * 【数据规模与约定】
 * 对于所有评测用例，T ≤ 3，3 ≤ n ≤ 300000，|ai
 * | ≤ 109。
 * 评测时将使用 25 个评测用例测试你的程序，每个评测用例的限制如下：
 * 评测用例编号 n |ai
 * | 特殊性质
 * 1 = 3 ≤ 1000 无
 * 2,3 ≤ 5 ≤ 1000 无
 * 4,5,6,7 ≤ 10 ≤ 1000 无
 * 8,9,10 ≤ 20 ≤ 1000 无
 * 11 ≤ 100 ≤ 109 所有 ai 非负
 * 12,13,14 ≤ 100 ≤ 109 无
 * 15,16 ≤ 500 ≤ 109 无
 * 17,18,19 ≤ 5000 ≤ 109 无
 * 20 ≤ 5000 ≤ 109 所有 ai 非负
 * 21 ≤ 100000 ≤ 109 所有 ai 非负
 * 22,23 ≤ 100000 ≤ 109 无
 * 24,25 ≤ 300000 ≤ 109 无
 * 注意：本题输入量较大请使用快速的读入方式。
 *
 * 思路：
 * 通过两种操作使得其中的绝对值最大的数达到最小：
 *
 * 如果 a[i] > 0 并且 a[i - 1] 或者 a[i+1] 小于 0，我们可以将 a[i] 借给 i-1 元素和 i+1元素，同时 a[i] 要变成 -a[i]。
 * 如果 a[i] < 0 并且 a[i - 1] 或者 a[i+1] 大于 0，我们可以将a[i-1] 和 a[i+1] 各借 abs(a[i]) 给 i 元素，之后 i 元素的值变成 -a[i] 也就是正数（a[i]本身是小于 0 的），同时 a[i - 1] 和 a[i + 1] 要减掉 abs(a[i])。
 * 那么就有以下几种情况：
 * 1、所有的数字都为正数或者都为负数，即所有的数字都同号。这种情况是没法借的，因为不符合操作要求，因此这种情况求出数组中绝对值最大的数即可。
 *
 * 2、对于 a[i]，如果 a[i] 是正数，并且 a[i - 1] 和 a[i + 1] 至少有一个负数，那么我们的目标就是把那个绝对值最大的负数的绝对值缩小，这个时候如果另一边是正数，则需要考虑操作之后是否会产生新的绝对值更大的正数，比如现在有三个数：5 5 -6，如果我们把中间那个 5 按上面的操作 1 变换之后：10 -5 -1，绝对值最大数变成了 10，而之前是 6，显然不行。如果这三个数是这样的：1 5 -7，那么我们就可以按操作 1 变换：6 -5 -2，最大绝对值从 7 减小到了 6，是可行的。那么变换条件是什么呢？这里假设 a[i - 1] 是正数，a[i + 1] 是负数，那么条件可以写成：a[i - 1] + a[i] < abs(a[i + 1])。而如果 a[i - 1] 和 a[i + 1] 都是负数的时候，当两边的绝对值有一个大于 a[i] 时，就可以进行操作 1 变换。
 *
 * 3、对于 a[i] 是负数的时候，如果 a[i - 1] 是负数， a[i+1] 是正数，那么确保 a[i + 1] > abs(a[i] + a[i-1])，就可以进行操作 2 变换，如果两边都是正数则只要有一边的值大于 abs(a[i]) 时就可以进行操作 2 变换
 */
public class 灵能传输 {
    public static int nums[] = new int[300005];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while((T--)>0) {
            Boolean ZS = false;
            Boolean FS = false;
            int n = scanner.nextInt();
            int max = 0;
            for(int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                if(nums[i] < 0) FS = true;
                else if(nums[i] > 0) ZS = true;
            }

            if(ZS && FS) {
                Boolean nextBoolean;
                do {
                    nextBoolean = false;
                    for(int i = 1; i < n - 1; i++) {
                        // nums[i] 和 nums[i-1] 或 nums[i+1] 异号
                        if(judge(nums[i], nums[i-1]) || judge(nums[i], nums[i+1])) {
                            if(nums[i] > 0) {
                                // nums[i-1] 和 nums[i+1] 异号，
                                if(judge(nums[i-1], nums[i+1])) {
                                    if ((nums[i-1] > 0 && Math.abs(nums[i+1]) > nums[i-1] + nums[i]) ||
                                            (nums[i+1] > 0 && Math.abs(nums[i-1]) > nums[i+1] + nums[i])) {
                                        nums[i+1] += nums[i];
                                        nums[i-1] += nums[i];
                                        nums[i] = -nums[i];
                                        nextBoolean = true;
                                    }
                                }else {
                                    // nums[i-1] 和 nums[i+1] 同号，都 < 0
                                    if (Math.abs(nums[i-1]) > nums[i] || Math.abs(nums[i+1]) > nums[i]) {
                                        nums[i+1] += nums[i];
                                        nums[i-1] += nums[i];
                                        nums[i] = -nums[i];
                                        nextBoolean = true;
                                    }
                                }
                            }else if(nums[i] < 0) {
                                if (judge(nums[i-1], nums[i+1])) {
                                    // nums[i-1] 和 nums[i+1] 异号
                                    if ((nums[i-1] > 0 && nums[i-1] > Math.abs(nums[i+1] + nums[i])) ||
                                            (nums[i+1] > 0 && nums[i+1] > Math.abs(nums[i-1] + nums[i]))) {
                                        nums[i+1] += nums[i];
                                        nums[i-1] += nums[i];
                                        nums[i] = -nums[i];
                                        nextBoolean = true;
                                    }
                                } else {
                                    // nums[i-1] 和 nums[i+1] 同号，都 > 0
                                    if (nums[i-1] > Math.abs(nums[i]) || nums[i+1] > Math.abs(nums[i])) {
                                        nums[i+1] += nums[i];
                                        nums[i-1] += nums[i];
                                        nums[i] = -nums[i];
                                        nextBoolean = true;
                                    }
                                }
                            }
                        }
                    }
                }while(nextBoolean);
            }
            for(int i = 0; i < n; i++) {
                max = Math.max(max, Math.abs(nums[i]));
            }
            System.out.println(max);
        }

    }

    //判断是否异号
    public static boolean judge(int a, int b) {
        return a > 0 && b < 0 || a < 0 && b > 0;
    }
}

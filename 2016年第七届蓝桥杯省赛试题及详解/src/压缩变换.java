/**
 * @author Wcy
 * @Date 2022/3/31 20:12
 */

import java.util.*;

/**
 * 小明最近在研究压缩算法。
 * 他知道，压缩的时候如果能够使得数值很小，就能通过熵编码得到较高的压缩比。
 * 然而，要使数值很小是一个挑战。
 *
 * 最近，小明需要压缩一些正整数的序列，这些序列的特点是，后面出现的数字很大可能是刚出现过不久的数字。对于这种特殊的序列，小明准备对序列做一个变换来减小数字的值。
 *
 * 变换的过程如下：
 * 从左到右枚举序列，每枚举到一个数字，如果这个数字没有出现过，刚将数字变换成它的相反数，如果数字出现过，则看它在原序列中最后的一次出现后面（且在当前数前面）出现了几种数字，用这个种类数替换原来的数字。
 *
 * 比如，序列(a1, a2, a3, a4, a5)=(1, 2, 2, 1, 2)在变换过程为：
 * a1: 1未出现过，所以a1变为-1；
 * a2: 2未出现过，所以a2变为-2；
 * a3: 2出现过，最后一次为原序列的a2，在a2后、a3前有0种数字，所以a3变为0；
 * a4: 1出现过，最后一次为原序列的a1，在a1后、a4前有1种数字，所以a4变为1；
 * a5: 2出现过，最后一次为原序列的a3，在a3后、a5前有1种数字，所以a5变为1。
 * 现在，给出原序列，请问，按这种变换规则变换后的序列是什么。
 *
 * 输入格式：
 * 输入第一行包含一个整数n，表示序列的长度。
 * 第二行包含n个正整数，表示输入序列。
 *
 * 输出格式：
 * 输出一行，包含n个数，表示变换后的序列。
 *
 * 例如，输入：
 * 5
 * 1 2 2 1 2
 *
 * 程序应该输出：
 * -1 -2 0 1 1
 *
 * 再例如，输入：
 * 12
 * 1 1 2 3 2 3 1 2 2 2 3 1
 *
 * 程序应该输出：
 * -1 0 -2 -3 1 1 2 2 0 0 2 2
 *
 * 数据规模与约定
 * 对于30%的数据，n<=1000；
 * 对于50%的数据，n<=30000；
 * 对于100%的数据，1 <=n<=100000，1<=ai<=10^9
 *
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 3000ms
 */
public class 压缩变换 {
    static Map<Integer, Integer> lastIndex = new HashMap<Integer, Integer>();//数字与下标的映射
    static int[] data;//记录原始数据
    static int[] ans;//记录答案
    private static int n;

    public static void main(String[] args) {
        //  处理输入
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data = new int[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            data[i] = num;
            if (lastIndex.get(num) == null)//没出现过
            {
                ans[i] = -num;
            } else {
                //统计p_num和i之间有多少不同的数字
                Set<Integer> set = new HashSet<Integer>();
                for (int j = lastIndex.get(num) + 1; j < i; j++) {
                    set.add(data[j]);
                }
                ans[i] = set.size();
            }
            lastIndex.put(num, i);//更新
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}

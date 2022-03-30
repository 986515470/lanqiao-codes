/**
 * @author Wcy
 * @Date 2022/3/19 21:44
 */

import java.util.Scanner;

/**
 *  100 可以表示为带分数的形式：100 = 3 + 69258 / 714
 *
 *     还可以表示为：100 = 82 + 3546 / 197
 *
 *     注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
 *
 *     类似这样的带分数，100 有 11 种表示法。
 *
 * 题目要求：
 * 从标准输入读入一个正整数N (N<1000*1000)
 * 程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
 * 注意：不要求输出每个表示，只统计有多少表示法！
 *
 *
 * 例如：
 * 用户输入：
 * 100
 * 程序输出：
 * 11
 *
 * 再例如：
 * 用户输入：
 * 105
 * 程序输出：
 * 6
 *
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 64M
 * CPU消耗  < 3000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class 带分数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        dfs(0);
        System.out.println(ans);
    }
    static int ans = 0,n = 9,x;
    static int A[] = new int[] {1,2,3,4,5,6,7,8,9};
    static void dfs(int m) {
        if(m>=9) {
            for(int i=1;i<n;i++) {// x = a + b/c     x-a =b/c  (x-a)*c=b
                int a=0;
                for(int k=0;k<i;k++)
                    a = 10*a + A[k];
                if(a>x)
                    break;
                for(int j=i+1;j<n;j++) {
                    int b=0,c=0;
                    for(int k=i;k<j;k++)
                        b = 10*b + A[k];
                    for(int k=j;k<n;k++)
                        c = 10*c + A[k];
                    if((x-a)*c==b)
                        ans++;
                }
            }
            return;
        }

        for(int i=m;i<n;i++) {
            swap(i,m);
            dfs(m+1);
            swap(i,m);
        }


    }
    private static void swap(int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

}

/**
 * @author Wcy
 * @Date 2022/4/6 19:37
 */

import java.util.Scanner;

/**
 * 我们知道包含N个元素的堆可以看成是一棵包含N个节点的完全二叉树。
 * 每个节点有一个权值。对于小根堆来说，父节点的权值一定小于其子节点的权值。
 *
 * 假设N个节点的权值分别是1~N，你能求出一共有多少种不同的小根堆吗？
 *
 * 例如对于N=4有如下3种：
 *
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 *
 *     1
 *    / \
 *   3   2
 *  /
 * 4
 *
 *     1
 *    / \
 *   2   4
 *  /
 * 3
 *
 * 由于数量可能超过整型范围，你只需要输出结果除以1000000009的余数。
 *
 * 【输入格式】
 * 一个整数N。
 * 对于40%的数据，1 <= N <= 1000
 * 对于70%的数据，1 <= N <= 10000
 * 对于100%的数据，1 <= N <= 100000
 *
 * 【输出格式】
 * 一个整数表示答案。
 *
 * 【输入样例】
 * 4
 *
 * 【输出样例】
 * 3
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 */
public class 堆的计数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = new long[n+5];
        inv = new long[n+5];
        f[0]=1;
        for(int i=1;i<n+5;i++) {
            f[i]=f[i-1]*i%mod;
            inv[i] = mpow(f[i],mod-2);
        }


    }

    static int n;
    static long mod = 1000000009;
    static long[] f;
    static long[] inv;

    static long C(int n,int m) {
        return f[n]*inv[m]%mod*inv[n-m]%mod;
    }

    static long mpow(long a,long n) {//快速幂
        if(n==0 || a==1)
            return 1;
        long ans=1;
        while(n!=0) {
            if(n%2==1)
                ans = a*ans%mod;
            a=a*a%mod;
            n>>=1;
        }

        return ans;
    }
}

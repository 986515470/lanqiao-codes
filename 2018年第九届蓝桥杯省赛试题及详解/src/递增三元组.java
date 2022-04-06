/**
 * @author Wcy
 * @Date 2022/4/6 19:34
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定三个整数数组
 * A = [A1, A2, ... AN],
 * B = [B1, B2, ... BN],
 * C = [C1, C2, ... CN]，
 * 请你统计有多少个三元组(i, j, k) 满足：
 *
 * 1. 1 <= i, j, k <= N
 * 2. Ai < Bj < Ck
 *
 * 【输入格式】
 * 第一行包含一个整数N。
 * 第二行包含N个整数A1, A2, ... AN。
 * 第三行包含N个整数B1, B2, ... BN。
 * 第四行包含N个整数C1, C2, ... CN。
 *
 * 对于30%的数据，1 <= N <= 100
 * 对于60%的数据，1 <= N <= 1000
 * 对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
 *
 * 【输出格式】
 * 一个整数表示答案
 *
 * 【输入样例】
 * 3
 * 1 1 1
 * 2 2 2
 * 3 3 3
 *
 * 【输出样例】
 * 27
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 */
public class 递增三元组 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];

        for(int i=0;i<n;i++)
            A[i] = in.nextInt();
        for(int i=0;i<n;i++)
            B[i] = in.nextInt();
        for(int i=0;i<n;i++)
            C[i] = in.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                if(A[i]<B[j]) {
                    int l=0,r=n-1;
                    while(l<=r){
                        int m = (l+r)/2;
                        if(C[m]>B[j]) r= m-1;
                        else    l = m +1;
                    }
//			        System.out.println(i+" "+j+" "+l);
                    ans+=n-l;
                }
//			System.out.println();
        }

        System.out.println(ans);
    }

}

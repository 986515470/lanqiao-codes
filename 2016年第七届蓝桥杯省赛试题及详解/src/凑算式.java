/**
 * @author Wcy
 * @Date 2022/3/31 19:22
 */

import java.util.Arrays;

/**
 *      B      DEF
 * A + --- + ------- = 10
 *      C      GHI
 *
 * （如果显示有问题，可以参见【图1.jpg】）
 *
 *
 * 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
 *
 * 比如：
 * 6+8/3+952/714 就是一种解法，
 * 5+3/1+972/486 是另一种解法。
 *
 * 这个算式一共有多少种解法？
 *
 * 注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
 */
public class 凑算式 {
    public static void main(String[] args) {
        dfs(0);
        System.out.println(ans);
    }

    static int[] a = new int[] {1,2,3,4,5,6,7,8,9};
    static int ans=0;
    static void dfs(int m) {
        if(m>=9) {
            //a[0]+a[1]/a[2]+a[3]a[4]a[5]/(a[6]a[7]a[8]) = 10
            //--> A + B/C + D/E = 10 --> A*C*E + B*E + D*C = 10*C*E
            int A = a[0];
            int B = a[1];
            int C = a[2];
            int D = 100*a[3]+10*a[4]+a[5];
            int E = 100*a[6]+10*a[7]+a[8];
            if(A*C*E + B*E +D*C == 10*C*E) {
                ans++;
                System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
            }
            return;
        }

        for(int i=m;i<9;i++) {
            swap(m,i);
            dfs(m+1);
            swap(m,i);
        }

    }

    static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}

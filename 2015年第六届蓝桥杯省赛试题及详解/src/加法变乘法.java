/**
 * @author Wcy
 * @Date 2022/3/30 19:45
 */

/**
 * 我们都知道：1+2+3+ ... + 49 = 1225
 * 现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
 * <p>
 * 比如：
 * 1+2+3+...+10*11+12+...+27*28+29+...+49 = 2015
 * 就是符合要求的答案。
 * <p>
 * 请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
 * <p>
 * 注意：需要你提交的是一个整数，不要填写任何多余的内容。
 */
public class 加法变乘法 {
    public static void main(String[] args) {
        int[] sum = new int[50];
        for(int i=1;i<=49;i++)
            sum[i]=sum[i-1]+i;

        for(int i=1;i<49;i++)
            for(int j=i+2;j<49;j++) {
                int ans = 1225;
                ans = ans -(i+i+1);
                ans = ans -(j+j+1);
                ans = ans + i*(i+1)+j*(j+1);
                if(ans==2015)
                    System.out.println(i+" "+j);
            }


    }

}

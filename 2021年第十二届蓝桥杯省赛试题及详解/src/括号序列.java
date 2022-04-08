import java.util.Scanner;

/**
 * @author Wcy
 * @Date 2022/4/8 16:08
 */

/**
 * 时间限制: 5.0s 内存限制: 512.0MB 本题总分：25 分
 * 【问题描述】
 * 给定一个括号序列，要求尽可能少地添加若干括号使得括号序列变得合法，
 * 当添加完成后，会产生不同的添加结果，请问有多少种本质不同的添加结果。
 * 两个结果是本质不同的是指存在某个位置一个结果是左括号，而另一个是右括
 * 号。
 * 例如，对于括号序列 ((()，只需要添加两个括号就能让其合法，有以下几
 * 种不同的添加结果：()()()、()(())、(())()、(()()) 和 ((()))。
 * 【输入格式】
 * 输入一行包含一个字符串 s，表示给定的括号序列，序列中只有左括号和
 * 右括号。
 * 【输出格式】
 * 输出一个整数表示答案，答案可能很大，请输出答案除以 1000000007 (即
 * 10 9 + 7) 的余数。
 * 【样例输入】
 * ((()
 * 【样例输出】
 * 5
 * 【评测用例规模与约定】
 * 对于 40% 的评测用例，|s| ≤ 200。
 * 对于所有评测用例，1 ≤ |s| ≤ 5000。
 */
public class 括号序列 {
    static int mod = 1000000000+7;
    static int []add = new int[5003];
    static int [][]f = new int[5003][5003];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入括号字符串
        String s =sc.next();
        sc.close();
        int len =s.length();
        char []arr = s.toCharArray();
        ans = work(len,arr);
        //获取镜像
        for(int i =1;i<=len;++i){
            if(arr[i-1]=='(') arr[i-1]=')';
            else arr[i-1]='(';
        }
        String s1 =  new String(arr);
        //字符串反转
        String s2 =new StringBuffer(s1).reverse().toString();
        ans=ans*work(len,s2.toCharArray())%mod;
        System.out.println(ans);

    }
    private static int work(int len,char []arr){
        int lcnt =0,rcnt =0,num=0;//未匹配的左右括号数，及右括号编号
        for(int i=1;i<=len;++i){
            if(arr[i-1]=='('){
                lcnt++;
            }else{
                rcnt++;
                num++;
                if(lcnt!=0) {
                    rcnt--;
                    lcnt--;
                }
                add[num]=rcnt; //记录最少需要添加左括号的数量，add单调不减
            }
        }
        for(int i =add[1];i<=len;++i){
            f[1][i]=1;
        }
        //n^3转移
//        for(int i=2;i<=num;i++){
//           for(int j=add[i];j<=len;++j){
//               for(int k=0;k<=j;++k){
//                   f[i][j]=(f[i][j]+f[i-1][j-k])%mod;
//
//               }
//           }
//        }

        for(int i=2;i<=num;++i){
            for(int j=0;j<=add[i];j++){
                f[i][add[i]]=(f[i][add[i]]+f[i-1][j])%mod;
            }
            for(int j=add[i]+1;j<=len;++j){
                f[i][j]=(f[i][j-1]+f[i-1][j])%mod;
            }
        }
        return f[num][rcnt];//返回答案
    }

}

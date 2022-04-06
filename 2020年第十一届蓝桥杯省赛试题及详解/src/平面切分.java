/**
 * @author Wcy
 * @Date 2022/4/6 21:44
 */

import java.util.Scanner;

/**
 * 【问题描述】
 * 平面上有 N 条直线，其中第 i 条直线是 y = A i · x + B i 。
 * 请计算这些直线将平面分成了几个部分。
 *
 * 【输入格式】
 * 第一行包含一个整数 N。
 * 以下 N 行，每行包含两个整数 A i , B i 。
 *
 * 【输出格式】
 * 一个整数代表答案。
 *
 * 【样例输入】
 * 3
 * 1 1
 * 2 2
 * 3 3
 *
 * 【样例输出】
 * 6
 * 【评测用例规模与约定】
 * 对于 50% 的评测用例，1 ≤ N ≤ 4, −10 ≤ A i , B i ≤ 10。
 * 对于所有评测用例，1 ≤ N ≤ 1000, −100000 ≤ A i , B i ≤ 100000。
 */
public class 平面切分 {
    static int check(int jiaodian[], int cnt)
    {
        int k=1;
        for(int i=0;i<cnt;i++)
        {
            for(int j=i+1;j<cnt;j++)
            {
                if(jiaodian[i]!=jiaodian[j])
                    k++;
            }
        }
        return k;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int[] A=new int[1005];
        int []B=new int[1005];
        for(int i=0;i<N;i++)
        {
           A[i]= sc.nextInt();
           B[i]= sc.nextInt();
        }
        int couter=N+1;  //第一条直线把平面分成两部分
        for(int i=1;i<N;i++)   //i=1,从第二条直线开始
        {
            int[] jiaodian=new int[10005];   //记录交点坐标
            int cnt=0;
            for(int j=0;j<i && j!=i;j++)  //每一条直线与前面直线的交点
            {
                if(A[i]!=A[j])  //判断两直线斜率
                {
                    jiaodian[cnt]=(B[j]-B[i])/(A[i]-A[j]);  //记录交点横坐标
                    cnt++;
                }
                else
                {
                    couter--;
                    break;
                }
            }
            if(cnt!=0)   //去掉重合的线
                couter=couter+check(jiaodian,cnt);
        }
        System.out.println(couter);
    }
}

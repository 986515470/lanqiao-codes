/**
 * @author Wcy
 * @Date 2022/4/6 19:47
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【问题描述】
 * “饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
 * 一个优先级，初始时 (0 时刻) 优先级都为 0。
 * 每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
 * 到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
 * 如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
 * 优先级小于等于 3，则会被清除出优先缓存。
 * 给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
 * 先缓存中。
 * 【输入格式】
 * 第一行包含 3 个整数 N、M 和 T。
 * 以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
 * 一个订单。
 * 【输出格式】
 * 输出一个整数代表答案。
 * 【样例输入】
 * 2 6 6
 * 1 1
 * 5 2
 * 3 1
 * 6 2
 * 2 1
 * 6 2
 * 【样例输出】
 * 1
 * 【样例解释】
 * 6 时刻时，1 号店优先级降到 3，被移除出优先缓存；2 号店优先级升到 6，
 * 加入优先缓存。所以是有 1 家店 (2 号) 在优先缓存中。
 * 【评测用例规模与约定】
 * 对于 80% 的评测用例，1 ≤ N, M, T ≤ 10000。
 * 对于所有评测用例，1 ≤ N, M, T ≤ 100000，1 ≤ ts ≤ T，1 ≤ id ≤ N。
 *
 * 思路：
 * 对输入的订单时间进行排序，然后转换成list，对1-T时间进行遍历，每个时间段所有非0的店先全部-1，在LIst里面找当前时间段的订单并对其店的优先值+3，最后遍历所有店铺的优先值大于5则在缓冲区中
 */
public class 外卖店优先级 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        int a[][] = new int[M][2];
        int b[] = new int[N+1];
        for(int i = 0; i < M; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }

        //按时刻排序
        for(int i=0; i<M-1; i++){
            for(int j=i+1; j<M; j++){
                if(a[i][0]>a[j][0]){
                    int temp = a[i][0];
                    a[i][0] = a[j][0];
                    a[j][0] = temp;
                    temp = a[i][1];
                    a[i][1] = a[j][1];
                    a[j][1] = temp;
                }
            }
        }


        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int i = 0; i < M; i++){
            list.add(a[i]);
        }

        for(int i = 1; i <= T; i++) {
            for(int j = 0; j < N; j++) {
                if(b[j] != 0) {
                    b[j]--;
                }
            }

            //判断I时刻有无订单
            while(list.size() != 0 && list.get(0)[0] == i) {
                int p = list.get(0)[1]-1;
                b[p] += 3;
                list.remove(0);
            }
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(b[i] > 5) {
                sum++;
            }
        }
        System.out.println(sum);

    }
}

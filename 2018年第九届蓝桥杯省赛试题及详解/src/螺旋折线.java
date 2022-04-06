/**
 * @author Wcy
 * @Date 2022/4/6 19:35
 */

import java.util.Scanner;

/**
 * 如图p1.pgn所示的螺旋折线经过平面上所有整点恰好一次。
 * 对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。
 *
 * 例如dis(0, 1)=3, dis(-2, -1)=9
 *
 * 给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？
 *
 * 【输入格式】
 * X和Y
 *
 * 对于40%的数据，-1000 <= X, Y <= 1000
 * 对于70%的数据，-100000 <= X， Y <= 100000
 * 对于100%的数据, -1000000000 <= X, Y <= 1000000000
 *
 * 【输出格式】
 * 输出dis(X, Y)
 *
 * 【输入样例】
 * 0 1
 *
 * 【输出样例】
 *
 * 3
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 *
 * 主类的名字必须是：Main，否则按无效代码处理。
 *
 *
 */
public class 螺旋折线 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long X = in.nextLong();
        long Y = in.nextLong();

        // 判断所在点所在的正方形
        long n = Math.max(Math.abs(X) , Math.abs(Y));

        // 1. 之前正方形的长度和
        long Sn = 4*(n-1)*n;

        // 2. 计算点(-n, -n) 到点(X, Y)的距离, 考虑清楚情况
        long sum = 0;
        long px = -n, py = -n;
        long d1 = X-px, d2 = Y-py;
        if (Y > X) {
            sum += (d1+d2);
        } else {
            sum += (8*n-d1-d2);
        }
        System.out.println(sum + Sn);
    }

}

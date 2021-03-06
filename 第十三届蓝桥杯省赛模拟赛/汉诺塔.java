package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 21:28
 */

import java.util.Scanner;

/**
 * 问题描述
 * 　　小蓝很喜欢玩汉诺塔游戏。
 * 　　游戏中有三根柱子，开始时第一根柱子上有 n 个圆盘，从上到下圆盘的大小依次为 1 到 n。
 * 　　每次，可以将一个盘子从一根柱子上移动到另一根柱子上，这个盘子必须是柱子最上方的盘子，而且移到的柱子上的盘子必须比这个盘子大。
 * 　　小蓝的目标是将所有的盘子移动到第三根柱子上。
 * 　　汉诺塔是个经典问题，当盘子数量为 n 时，最少需要移动 2**n-1 步，其中 2**n 表示 2 的 n 次方。
 * 　　小蓝已经玩了一会儿（不一定按最优方案玩），他想知道，对于他目前的局面，最少还需要多少步可以到达目标。
 * 输入格式
 * 　　输入的第一行包含三个非负整数 a, b, c，分别表示目前每根柱子上的盘子数。在本题中，n=a+b+c。
 * 　　第二行包含 a 个整数，相邻的整数之间使用一个空格分隔，表示第一根柱子上的盘子，盘子按从上到下（从小到大）的顺序给出。
 * 　　第三行包含 b 个整数，相邻的整数之间使用一个空格分隔，表示第二根柱子上的盘子，盘子按从上到下（从小到大）的顺序给出。
 * 　　第四行包含 c 个整数，相邻的整数之间使用一个空格分隔，表示第三根柱子上的盘子，盘子按从上到下（从小到大）的顺序给出。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 1 2 3
 * 1
 * 2 3
 * 4 5 6
 * 样例输出
 * 7
 * 评测用例规模与约定
 * 　　对于 30% 的评测用例，2 <= n <= 5。
 * 　　对于所有评测用例，2 <= n <= 60。
 */
public class 汉诺塔 {


}

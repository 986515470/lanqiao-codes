/**
 * @author Wcy
 * @Date 2022/3/28 17:44
 */

import java.util.Scanner;

/**
 *    X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
 *     地宫的入口在左上角，出口在右下角。
 *     小明被带到地宫的入口，国王要求他只能向右或向下行走。
 *     走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
 *     当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
 *     请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
 * 【数据格式】
 *     输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
 *     接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值
 *     要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。
 * 例如，输入：
 * 2 2 2
 * 1 2
 * 2 1
 * 程序应该输出：
 * 2
 *
 * 再例如，输入：
 * 2 3 2
 * 1 2 3
 * 2 1 5
 * 程序应该输出：
 * 14
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 2000ms
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class 地宫取宝 {

    private static long N = 1000000007;
    private static int n,m,k;
    private static int map[][] = new int[50][50];  //记录迷宫
    //dp中，四个参数各代表坐标X,Y、手中持有宝物数量、手中宝物的最大值 表示的是该状态到终点有多少条路径
    private static int dp[][][][] = new int[50][50][15][15];

    public static void init(){//初始化每个状态都是-1 所以-1就说明这个状态之后的路径没有计算过
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                for(int k=0;k<15;k++){
                    for(int l=0;l<15;l++)
                        dp[i][j][k][l] = -1;
                }
            }
        }
    }

    /*
    就是一个搜索的函数，来不断地搜索，每次搜索到底的时候，
    也就是最后一个点的时候，虽然x、y是一样的，但是num和max也就是状态是不一样的
    但是显然我们知道最后一个点不论是什么状态它到终点的路径也只有一条
    所以会return一个1 然后回到递归的上一层 也就是上一个点的状态 可能它是往右到达最后这个点的
    还是往下到达这个点的 它 也就是调用了这个return 1 的这次dfs的那个点的状态 它的s必须要加上这个1
    然后一层一层往上递推 s是不断地增加的 直到初始点 的初始状态 它的dp值 也就是s 就是我们所要的答案
     */
    public static int DFS(int x, int y, int num, int max){
        //首先函数的前面可以写一些代码来控制条件来剪枝 减少一些无用的搜索
        //记忆化搜索，首先先检查该路径是否已经走过
        if(dp[x][y][num][max+1]!=-1){
            //说明已经走过这个条路径，就不用再次走（这个状态之前已经到过了，所以不用再计算了，直接返回之前得出的该状态的数值）
            //因为宝物有可能为0所以定义max时用最小值-1 这就导致无法作为下标使用
            //实际上如果测试数据中宝物价值没有0,将所有的+1 去掉也是可以的
            return  dp[x][y][num][max+1];
        }

        //到达边界
        if(x==n-1 && y==m-1){
            /*到达下角有两种情况成功
             * 1.当前手中的数量正好等于题目所要的k，这时不拿会成功
             * 2.当前手中的数量刚好差一个，然后地下的宝物大于手中的max，这时也会成功
             */
            if(num==k || (num==k-1 && max<map[x][y])){
                return dp[x][y][num][map[x][y]]=1;  //这里返回的1就是上文所提到的 这个状态到终点有一条路径 然后往外层递推一直递推到初始状态就是答案
            }else{
                return dp[x][y][num][max+1]=0;		//不满足条件,这里的max+1原因同上
            }
        }

        /*拿和不拿的两种情况：
         * 1.手中的max大于地下宝物价值，此时可拿可不拿
         * 2.手中的max小于地下宝物价值，此时只能不拿
         */
        long s = 0;
        if(x<n-1){//向下搜索
            if(max<map[x][y]){//可拿可不拿，不拿的情况可以想成是不符合条件所以不拿，这样来说就可以将其和不能拿一起处理
                s += DFS(x+1, y, num+1, map[x][y]);
            }
            s += DFS(x+1, y, num, max);//不拿，与不能拿时写在一起,这点很重要！
            s%=N;
        }

        if(y<m-1){//向右搜索
            if(max<map[x][y]){//可拿可不拿，不拿的情况可以想成是不符合条件所以不拿，这样来说就可以将其和不能拿一起处理
                s += DFS(x, y+1, num+1, map[x][y]);
            }
            s += DFS(x, y+1, num, max);//不拿，与不能拿时写在一起,这点很重要！
            s%=N;
        }

        //说明本层内的都回溯完了 也就是本层dfs结束 此时要赋给这个状态s 即表示有多少条路径到达终点
        return  dp[x][y][num][max+1]=(int) s;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = scan.nextInt();
            }
        }
        init();
        DFS(0, 0, 0, -1);
        System.out.println(dp[0][0][0][0]);//起点刚开始什么都没有的状态 这个状态的值就是答案
    }
}

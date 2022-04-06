/**
 * @author Wcy
 * @Date 2022/4/6 19:36
 */

import java.util.Scanner;

/**
 * 你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：
 *
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 *
 * 其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。
 *
 * 由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。
 *
 * 例如上图中的海域未来会变成如下样子：
 *
 * .......
 * .......
 * .......
 * .......
 * ....#..
 * .......
 * .......
 *
 * 请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
 *
 * 【输入格式】
 * 第一行包含一个整数N。  (1 <= N <= 1000)
 * 以下N行N列代表一张海域照片。
 *
 * 照片保证第1行、第1列、第N行、第N列的像素都是海洋。
 *
 * 【输出格式】
 * 一个整数表示答案。
 *
 * 【输入样例】
 * 7
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 *
 * 【输出样例】
 * 1
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 */
public class 全球变暖 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ch = new char[n][n];
        vis = new int[n][n];

        for(int i=0;i<n;i++)
            ch[i] = in.next().toCharArray();

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                vis[i][j] = 0;
                if(ch[i][j]=='#' && is(i,j))
                    ch[i][j] = '*';
            }

        int ans=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(ch[i][j]=='#' && vis[i][j]==0)
                    dfs(i,j,++ans);


        for(int i=0;i<n;i++) {//检查
            for(int j=0;j<n;j++)
                System.out.print(ch[i][j]);
            System.out.println();
        }

        System.out.println(ans);
    }

    static int n;
    static char[][] ch;
    static int[][] vis;
    static int[] dx = new int[] {1,0,-1,0};
    static int[] dy = new int[] {0,1,0,-1};

    static boolean is(int x,int y) {
        for(int i=0;i<4;i++)
            if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n && ch[x+dx[i]][y+dy[i]]=='.')
                return true;
        return false;
    }

    static void dfs(int x,int y,int t) {
        vis[x][y] = t;
        for(int i=0;i<4;i++)
            if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n && ch[x+dx[i]][y+dy[i]]=='#' && vis[x+dx[i]][y+dy[i]]==0)
                dfs(x+dx[i],y+dy[i],t);
    }

}

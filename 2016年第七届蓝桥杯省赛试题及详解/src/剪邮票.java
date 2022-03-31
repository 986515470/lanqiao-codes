/**
 * @author Wcy
 * @Date 2022/3/31 19:47
 */

/**
 * 如【图1.jpg】, 有12张连在一起的12生肖的邮票。
 * 现在你要从中剪下5张来，要求必须是连着的。
 * （仅仅连接一个角不算相连）
 * 比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。
 *
 * 请你计算，一共有多少种不同的剪取方法。
 *
 * 请填写表示方案数目的整数。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
//  a[3][4]
public class 剪邮票 {
    public static void main(String[] args) {

        for(int i=1;i<=12;i++) {
            for(int j=i+1;j<=12;j++) {
                for(int k=j+1;k<=12;k++) {
                    for(int x=k+1;x<=12;x++) {
                        for(int y=x+1;y<=12;y++) {
                            vis[i]=vis[j]=vis[k]=vis[x]=vis[y]=true;
                            t=0;
                            dfs(i);
                            if(t==5)
                                ans++;
                            vis[i]=vis[j]=vis[k]=vis[x]=vis[y]=false;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    //	static char[] a = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L'};
//	static HashSet<String> set = new HashSet<>();
    static boolean[] vis = new boolean[13];
    static int ans = 0;
    static int t=0;

    static void dfs(int x) {
        vis[x]=false;
        t++;
        if(x!=1 && x!=5 && x!=9 && vis[x-1])
            dfs(x-1);
        if(x!=4 && x!=8 && x!=12 && vis[x+1])
            dfs(x+1);
        if(x!=1 && x!=2 && x!=3 && x!=4 && vis[x-4])
            dfs(x-4);
        if(x!=9 && x!=10 && x!=11 && x!=12 && vis[x+4])
            dfs(x+4);
    }

}

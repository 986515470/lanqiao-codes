package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 18:29
 */

/**
 * 问题描述
 * 　　对于一个 n 行 m 列的表格，我们可以使用螺旋的方式给表格依次填上正整数，我们称填好的表格为一个螺旋矩阵。
 * 　　例如，一个 4 行 5 列的螺旋矩阵如下：
 * 　　1  2  3  4    5              1  2   3  4
 * 　　14 15 16 17   6              12 13  14 5
 * 　　13 20 19 18   7              11 16  15 6
 * 　　12 11 10 9    8              10 9   8  7
 * 　　请问，一个 30 行 30 列的螺旋矩阵，第 20 行第 20 列的值是多少？
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] a=new int[30][30];
        a=init(30,a,1);
        sout(init(30,a,1));
        System.out.println(a[19][19]);
    }
    //四行四列： 4 3 3 2 2 1 1                   1234 567 8910 1112 1314 15 16
    // 30 29 29 28 28 27 27 26 26
    public static void sout(int[][] a){
        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    //右下左上
    public static int[][] init(int n,int[][] a,int init){
       for(int i=0;i<n;i++){
           //向右移动n
           for(int j=0;j<n-i;j++){
               a[i][j]=init;
               init++;
           }
           //向下移动n-1
           for(int j=i+1;j<n-i;j++){
               a[j][n-i-1]=init;
               init++;
           }
           //向左移动n-1
           for(int j=n-i-2;j>=i;j--){
               a[n-i-1][j]=init;
               init++;
           }
           //向上移动n-2
           for(int j=n-i-2;j>i;j--){
               a[j][i]=init;
               init++;
           }
//          sout(a);
//          System.out.println();
       }
       return a;
    }

}

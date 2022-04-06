/**
 * @author Wcy
 * @Date 2022/4/6 19:45
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 【问题描述】
 * 下图给出了一个迷宫的平面图，其中标记为 1 的为障碍，标记为 0 的为可
 * 以通行的地方。
 * 010000
 * 000100
 * 001001
 * 110000
 * 迷宫的入口为左上角，出口为右下角，在迷宫中，只能从一个位置走到这
 * 个它的上、下、左、右四个方向之一。
 * 对于上面的迷宫，从入口开始，可以按DRRURRDDDR 的顺序通过迷宫，
 * 一共 10 步。其中 D、U、L、R 分别表示向下、向上、向左、向右走。
 * 对于下面这个更复杂的迷宫（30 行 50 列），请找出一种通过迷宫的方式，
 * 其使用的步数最少，在步数最少的前提下，请找出字典序最小的一个作为答案。
 * 请注意在字典序中D<L<R<U。（如果你把以下文字复制到文本文件中，请务
 * 必检查复制的内容是否与文档中的一致。在试题目录下有一个文件 maze.txt，
 * 内容与下面的文本相同）
 * 01010101001011001001010110010110100100001000101010
 * 00001000100000101010010000100000001001100110100101
 * 01111011010010001000001101001011100011000000010000
 * 01000000001010100011010000101000001010101011001011
 * 00011111000000101000010010100010100000101100000000
 * 11001000110101000010101100011010011010101011110111
 * 00011011010101001001001010000001000101001110000000
 * 10100000101000100110101010111110011000010000111010
 * 00111000001010100001100010000001000101001100001001
 * 11000110100001110010001001010101010101010001101000
 * 00010000100100000101001010101110100010101010000101
 * 11100100101001001000010000010101010100100100010100
 * 00000010000000101011001111010001100000101010100011
 * 10101010011100001000011000010110011110110100001000
 * 10101010100001101010100101000010100000111011101001
 * 10000000101100010000101100101101001011100000000100
 * 10101001000000010100100001000100000100011110101001
 * 00101001010101101001010100011010101101110000110101
 * 11001010000100001100000010100101000001000111000010
 * 00001000110000110101101000000100101001001000011101
 * 10100101000101000000001110110010110101101010100001
 * 00101000010000110101010000100010001001000100010101
 * 10100001000110010001000010101001010101011111010010
 * 00000100101000000110010100101001000001000000000010
 * 11010000001001110111001001000011101001011011101000
 * 00000110100010001000100000001000011101000000110011
 * 10101000101000100010001111100010101001010000001000
 * 10000010100101001010110000000100101010001011101000
 * 00111100001000010000000110111000000001000000001011
 * 10000001100111010111010001000110111010101101111000
 *
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个字符串，包含四种字母 D、U、L、R，在提交答案时只填写这个字符串，填
 * 写多余的内容将无法得分。
 *
 * 思路
 * BFS继续搜索，到终点开始回溯dir数组到起点，且输出路径
 *
 * 答案：DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDDRRRURRUURRDDDDRDRRRRRRDRRURRDDDRRRRUURUUUUUUULULLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDDRRRRRDDRRDDLLLDDRRDDRDDLDDDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR
 */
class node9{
    int x;
    int y;
}
public class 迷宫 {
    static int m,n;
    static final int max=105;
    static char map[][]=new char[max][max];
    static boolean vis[][]=new boolean[max][max];
    static char dir[][]=new char[max][max];
    static int dirx[]={1,0,0,-1};
    static int diry[]={0,-1,1,0};
    static Queue<node9> q=new ArrayDeque<node9>();
    public static void bfs(){
        node9 t=new node9();
        t.x=0; t.y=0;
        q.offer(t);
        vis[0][0]=true;
        boolean flag=false;
        while(!q.isEmpty()){
            t=q.poll();
            for(int i=0;i<4;i++){
                int xx=t.x+dirx[i];
                int yy=t.y+diry[i];
                if(xx<0||xx>=n||yy<0||yy>=m) continue;
                if(vis[xx][yy]||map[xx][yy]=='1') continue;
                node9 s=new node9();
                s.x=xx;
                s.y=yy;
                q.offer(s);
                vis[xx][yy]=true;
                if(i==0){
                    dir[xx][yy]='D';
                }
                else if(i==1){
                    dir[xx][yy]='L';
                }
                else if(i==2){
                    dir[xx][yy]='R';
                }
                else{
                    dir[xx][yy]='U';
                }
                if(xx==n-1&&yy==m-1){
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        //回溯
        ArrayList<Character> v=new ArrayList<>();
        int i=n-1,j=m-1;
        while(i!=0||j!=0){
            v.add(dir[i][j]);
            if(dir[i][j]=='D'){
                i=i-1;
            }
            else if(dir[i][j]=='L'){
                j=j+1;
            }
            else if(dir[i][j]=='R'){
                j=j-1;
            }
            else{
                i=i+1;
            }
        }
        for(int k=v.size()-1;k>=0;k--){
            System.out.print(v.get(k));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int index = 0;
        File file = new File("F:\\java\\JB\\maze.txt");
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new FileReader(file)) ;
            String tempString;
            while((tempString = bufferedReader.readLine()) != null) {
                //System.out.println(tempString);
                for(int i = 0; i < 50; i++) {
                    map[index][i] = tempString.charAt(i);
                }
                index++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
        }
        n = index;
        m = 50;
		/*
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/

        bfs();
    }
}


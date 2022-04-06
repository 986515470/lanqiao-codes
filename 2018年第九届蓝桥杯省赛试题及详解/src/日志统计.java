/**
 * @author Wcy
 * @Date 2022/4/6 19:35
 */

import java.util.*;

/**
 * 小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有N行。其中每一行的格式是：
 *
 * ts id
 *
 * 表示在ts时刻编号id的帖子收到一个"赞"。
 *
 * 现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为D的时间段内收到不少于K个赞，小明就认为这个帖子曾是"热帖"。
 *
 * 具体来说，如果存在某个时刻T满足该帖在[T, T+D)这段时间内(注意是左闭右开区间)收到不少于K个赞，该帖就曾是"热帖"。
 *
 * 给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。
 *
 * 【输入格式】
 * 第一行包含三个整数N、D和K。
 * 以下N行每行一条日志，包含两个整数ts和id。
 *
 * 对于50%的数据，1 <= K <= N <= 1000
 * 对于100%的数据，1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000
 *
 * 【输出格式】
 * 按从小到大的顺序输出热帖id。每个id一行。
 *
 * 【输入样例】
 * 7 10 2
 * 0 1
 * 0 10
 * 10 10
 * 10 1
 * 9 1
 * 100 3
 * 100 3
 *
 * 【输出样例】
 * 1
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
 */
public class 日志统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int k = in.nextInt();

        ArrayList<Node> list = new ArrayList<>();//曾经为热帖
        HashSet<Integer> set = new HashSet<>();//排重
        HashMap<Integer, Integer> map = new HashMap<>();//为什么用map,因为其实10W个id并没有全用上

        for(int i=0;i<n;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.put(b, 0);
            list.add(new Node(a,b));
        }
        Collections.sort(list);

        int min=list.get(0).t,max = list.get(0).t,i=0,j=0;
        while(j<n) {//双指针
            Node u = list.get(j);
            max = u.t;
            map.put(u.id, map.get(u.id)+1);
            while(max-min>=10){
                Node v = list.get(i);
                map.put(v.id, map.get(v.id)-1);
                i++;
                min = list.get(i).t;
            }
            if(map.get(u.id)>=k)
                set.add(u.id);
            j++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x:set)
            ans.add(x);
        Collections.sort(ans);
        for(int x:ans)
            System.out.println(x);
    }

    static class Node implements Comparable<Node>{
        int t,id;
        public Node(int t,int id) {
            this.t= t;
            this.id = id;
        }
        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

}

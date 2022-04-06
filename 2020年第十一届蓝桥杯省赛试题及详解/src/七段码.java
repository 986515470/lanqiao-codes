/**
 * @author Wcy
 * @Date 2022/4/6 20:29
 */

/**
 * 【问题描述】
 * 小蓝要用七段码数码管来表示一种特殊的文字。
 * 在这里插入图片描述
 * 上图给出了七段码数码管的一个图示，数码管中一共有 7 段可以发光的二
 * 极管，分别标记为 a, b, c, d, e, f, g。
 * 小蓝要选择一部分二极管（至少要有一个）发光来表达字符。在设计字符
 * 的表达时，要求所有发光的二极管是连成一片的。
 * 例如：b 发光，其他二极管不发光可以用来表达一种字符。
 * 例如：c 发光，其他二极管不发光可以用来表达一种字符。这种方案与上
 * 一行的方案可以用来表示不同的字符，尽管看上去比较相似。
 * 例如：a, b, c, d, e 发光，f, g 不发光可以用来表达一种字符。
 * 例如：b, f 发光，其他二极管不发光则不能用来表达一种字符，因为发光
 * 的二极管没有连成一片。
 * 请问，小蓝可以用七段码数码管表达多少种不同的字符？
 *
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 七段码 {
    static int[] arr = {0,1,2,3,4,5,6};

    public static void main(String[] args) {


//		System.out.println(7+7+1+10+16+20+19);

        int ans = 7;
        ans += dfs(0,2)/2;
        ans += dfs(0,3)/6;
        ans += dfs(0,4)/24;
        ans += dfs(0,5)/120;
        ans += 7;
        ans += 1;
        System.out.println(ans);

    }

    //测出所以可能
    private static int dfs(int index, int num) {
        int count = 0;
        if(index == num) {
            if(check(num)) count ++;
        }
        for(int j = index;j<7;j++) {
            {
                int t = arr[j];
                arr[j] = arr[index];
                arr[index] = t;
            }
            count +=dfs(index +1,num);
            {
                int t = arr[j];
                arr[j] = arr[index];
                arr[index] = t;
            }
        }
        return count;
    }

    //测试是否连通
    private static boolean check(int num) {
        int count  = 0;
        int[] check = new int[7];

        for(int i = 0;i<num;i++) {
            check[arr[i]] = 1;
        }
        for(int j = 0;j<7;j++) {
            if(check[j] ==1) {
                f(check,j);
                count ++;
            }
        }
        return count == 1;
    }

    private static void f(int[] check, int index) {
        check[index] = 0;
        if(index == 0) {
            if(check[1] == 1) {
                f(check,1);
            }
            if(check[5] == 1 ) {
                f(check,5);
            }
            if(check[6] == 1) {
                f(check,6);
            }
        }
        if(index == 1) {
            if(check[0] == 1) {
                f(check,0);
            }
            if(check[2] == 1) {
                f(check,2);
            }
        }
        if(index == 2) {

            if(check[1] == 1) {
                f(check,1);
            }
            if(check[3] == 1 ) {
                f(check,3);
            }
            if(check[6] == 1) {
                f(check,6);
            }
        }
        if(index == 3) {
            if(check[2] == 1) {
                f(check,2);
            }
            if(check[4] == 1 ) {
                f(check,4);
            }
            if(check[6] == 1) {
                f(check,6);
            }
        }
        if(index == 4) {
            if(check[3] == 1) {
                f(check,3);
            }
            if(check[5] == 1 ) {
                f(check,5);
            }
        }
        if(index == 5) {
            if(check[0] == 1) {
                f(check,0);
            }
            if(check[4] == 1 ) {
                f(check,4);
            }
            if(check[6] == 1) {
                f(check,6);
            }
        }
        if(index == 6) {
            if(check[0] == 1) {
                f(check,0);
            }
            if(check[2] == 1) {
                f(check,2);
            }
            if(check[3] == 1) {
                f(check,3);
            }
            if(check[5] == 1 ) {
                f(check,5);
            }
        }
    }

}

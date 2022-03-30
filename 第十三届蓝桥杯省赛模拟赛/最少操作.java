package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 18:22
 */

/**
 * 问题描述
 * 　　有一个整数 A=2021，每一次，可以将这个数加 1 、减 1 或除以 2，其中除以 2 必须在数是偶数的时候才允许。
 * 　　例如，2021 经过一次操作可以变成 2020、2022。
 * 　　再如，2022 经过一次操作可以变成 2021、2023 或 1011。
 * 　　请问，2021 最少经过多少次操作可以变成 1。
 * 答案提交
 * 　　这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 最少操作 {
    public static void main(String[] args) {
        System.out.println(totalNum(2021,0));
    }

    public static int  totalNum(int a,int num){
        if(a==1){
            System.out.println(a+" "+num);
            return num;
        }
        if(a%2==0) {
            System.out.println(a+" "+num);
            num++;
            return totalNum(a / 2, num);
        }{
            System.out.println(a+" "+num);
            num++;
            return totalNum(a-1,num);
        }

    }
}

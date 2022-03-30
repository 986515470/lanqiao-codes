package 第十三届蓝桥杯省赛模拟赛; /**
 * @author Wcy
 * @Date 2022/3/24 18:18
 */

/**
 * 问题描述
 * 　　如果一个整数的某个数位包含 2 ，则称这个数为一个“最2数字”。例如：102、2021 都是最2数字。
 * 　　请问在 1（含） 到 2021（含） 中，有多少个最2数字。
 * 答案提交
 * 　　这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 最2数字 {
    public static void main(String[] args) {
        int total=0;
        for(int i=1;i<2022;i++){
            String str=String.valueOf(i);
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='2'){
                    total++;
                    break;
                }

            }
        }
        System.out.println(total);
    }
}

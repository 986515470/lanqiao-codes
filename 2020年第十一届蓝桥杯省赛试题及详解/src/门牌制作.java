/**
 * @author Wcy
 * @Date 2022/4/6 19:52
 */

/**
 * 【问题描述】
 * 小蓝要为一条街的住户制作门牌号。
 * 这条街一共有 2020 位住户，门牌号从 1 到 2020 编号。
 * 小蓝制作门牌的方法是先制作 0 到 9 这几个数字字符，最后根据需要将字
 * 符粘贴到门牌上，例如门牌 1017 需要依次粘贴字符 1、0、1、7，即需要 1 个
 * 字符 0，2 个字符 1，1 个字符 7。
 * 请问要制作所有的 1 到 2020 号门牌，总共需要多少个字符 2？
 *
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 门牌制作 {
    static int total=0;
    public static void main(String[] args) {
        for (int i = 0; i <=2020; i++) {
            getNum(i);
        }
        System.out.println(total);
    }

    public static void getNum(int i){
        String str=String.valueOf(i);
        for (int j = 0; j < str.length(); j++) {
            if(str.charAt(j)=='2'){
                total++;
            }
        }
    }

}

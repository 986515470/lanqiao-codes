/**
 * @author Wcy
 * @Date 2022/3/19 17:18
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * 黄金分割数0.61803... 是个无理数，这个常数十分重要，在许多工程问题中会出现。有时需要把这个数字求得很精确。
 *
 *     对于某些精密工程，常数的精度很重要。也许你听说过哈勃太空望远镜，它首次升空后就发现了一处人工加工错误，对那样一个庞然大物，其实只是镜面加工时有比头发丝还细许多倍的一处错误而已，却使它成了“近视眼”!!
 *
 *
 *     言归正传，我们如何求得黄金分割数的尽可能精确的值呢？有许多方法。
 *
 *     比较简单的一种是用连分数：
 *
 *                   1
 *     黄金数 = ---------------------
 *                         1
 *              1 + -----------------
 *                           1
 *                  1 + -------------
 *                             1
 *                      1 + ---------
 *                           1 + ...
 *
 *
 *
 *     这个连分数计算的“层数”越多，它的值越接近黄金分割数。
 *
 *     请你利用这一特性，求出黄金分割数的足够精确值，要求四舍五入到小数点后100位。
 *
 *     小数点后3位的值为：0.618
 *     小数点后4位的值为：0.6180
 *     小数点后5位的值为：0.61803
 *     小数点后7位的值为：0.6180340
 *    （注意尾部的0，不能忽略）
 *
 * 你的任务是：写出精确到小数点后100位精度的黄金分割值。
 *
 * 注意：尾数的四舍五入！ 尾数是0也要保留！
 *
 * 显然答案是一个小数，其小数点后有100位数字，请通过浏览器直接提交该数字。
 * 注意：不要提交解答过程，或其它辅助说明类的内容。
 */

/**
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列，因数学家莱昂纳多·斐波那契（Leonardo Fibonacci）
 * 以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
 * 在现代物理、准晶体结构、化学等领域，斐波纳契数列都有直接的应用，为此，美国数学会从 1963 年起出版了以《斐波纳契数列季刊》为名的一份数学杂志，用于专门刊载这方面的研究成果。
 */
public class 黄金连分数 {
    public static void main(String[] args) {
        BigInteger a=BigInteger.ONE;
        BigInteger b=BigInteger.ONE;
        //斐波那契数列的迭代形式
        for (int i = 3; i < 500; i++) {
            BigInteger t=b;
            b=a.add(b);//大整数的加法
            a=t;
        }
        //大浮点数的除法
        BigDecimal divide = new BigDecimal(a,110).divide(new BigDecimal(b,110), BigDecimal.ROUND_HALF_DOWN);
        //截取字符串
        System.out.println(divide.toPlainString().substring(0,103));

    }
//0.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911375
/**
 *     0.6180339887
 *       4989484820
 *       4586834365
 *       6381177203
 *       0917980576
 *       2862135448
 *       6227052604
 *       6281890244
 *       9707207204
 *       18939113748
 *       向上取一位
 */

}

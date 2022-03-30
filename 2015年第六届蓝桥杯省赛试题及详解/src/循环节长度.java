/**
 * @author Wcy
 * @Date 2022/3/30 19:41
 */

import java.util.Vector;

/**
 * 两个整数做除法，有时会产生循环小数，其循环部分称为：循环节。
 * 比如，11/13=6=>0.846153846153.....  其循环节为[846153] 共有6位。
 * 下面的方法，可以求出循环节的长度。
 *
 * 请仔细阅读代码，并填写划线部分缺少的代码。
 */
public class 循环节长度 {
    public static int f(int n, int m)
    {
        n = n % m;
        Vector v = new Vector();

        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
//            if(v.indexOf(n)>=0)  _________________________________ ;  //填空
            if(v.indexOf(n)>=0)
                return v.size() - v.indexOf(n); //填空
        }
    }
}

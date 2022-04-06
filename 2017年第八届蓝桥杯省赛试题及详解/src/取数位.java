/**
 * @author Wcy
 * @Date 2022/4/2 16:55
 */

/**
 * 求1个整数的第k位数字有很多种方法。
 * 以下的方法就是一种。
 */
public class 取数位 {
    static int len(int x){
        if(x<10) return 1;
        return len(x/10)+1;
    }

    // 取x的第k位数字
    static int f(int x, int k){
        if(len(x)-k==0) return x%10;
//        return ______________________;  //填空
        return f((x-x%10)/10,k);
    }

    public static void main(String[] args)
    {
        int x = 23513;
        //System.out.println(len(x));
        System.out.println(f(x,3));
    }

}

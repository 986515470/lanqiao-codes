/**
 * @author Wcy
 * @Date 2022/3/19 17:58
 */

/**
 *     有理数就是可以表示为两个整数的比值的数字。一般情况下，我们用近似的小数表示。但有些时候，不允许出现误差，必须用两个整数来表示一个有理数。
 *
 *     这时，我们可以建立一个“有理数类”，下面的代码初步实现了这个目标。为了简明，它只提供了加法和乘法运算。
 */
public class Rational
{
    private long ra;
    private long rb;

//    辗转相除法取最简公因子
    private long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public Rational(long a, long b){
        ra = a;
        rb = b;
        long k = gcd(ra,rb);
        if(k>1){ //需要约分
            ra /= k;
            rb /= k;
        }
    }

    // 加法
//    public Rational add(Rational x){
//        return ________________________________________;  //填空位置
//    }
        public Rational add(Rational x){
        return  new Rational(ra*x.rb+rb*x.ra, rb*x.rb);  //填空位置
    }

    /**
     *
     * new Rational(ra*x.rb+rb*x.ra, rb*x.rb)
     * new Rational(this.ra * x.rb + x.ra * this.rb, this.rb * x.rb)
     *
     */


    // 乘法
    public Rational mul(Rational x){
        return new Rational(ra*x.ra, rb*x.rb);
    }
    public String toString(){
        if(rb==1) return "" + ra;
        return ra + "/" + rb;
    }
}


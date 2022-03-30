/**
 * @author Wcy
 * @Date 2022/3/30 19:22
 */

/**
 * 观察下面的加法算式：
 * <p>
 * 祥 瑞 生 辉
 * +   三 羊 献 瑞
 * -------------------
 * 三 羊 生 瑞 气
 * <p>
 * (如果有对齐问题，可以参看【图1.jpg】)
 * <p>
 * 其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
 * <p>
 * 请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
 */
public class 三羊献瑞 {
    /**
     * 三羊献气祥瑞生辉
     * a b c d e f g h
     * e*1000+f*100+g*10+h+a*1000+b*100+c*10+f=a*10000+b*1000+g*100+f*10+d
     */
    public static void main(String[] args) {
        for(int x1=0;x1<10;x1++)
            for(int x2=0;x2<10;x2++) {
                if(x1==x2)
                    continue;
                for(int x3=0;x3<10;x3++) {
                    if(x3==x1 || x3==x2)
                        continue;
                    for(int x4=0;x4<10;x4++) {
                        if(x4==x1 || x4==x2 || x4==x3)
                            continue;
                        for(int x5=0;x5<10;x5++) {
                            if(x5==x1 || x5==x2 || x5==x3 || x5==x4)
                                continue;
                            for(int x6=0;x6<10;x6++) {
                                if(x6==x1 || x6==x2 || x6==x3 || x6==x4 || x6==x5)
                                    continue;
                                for(int x7=0;x7<10;x7++) {
                                    if(x7==x1 || x7==x2 || x7==x3 || x7==x4 || x7==x5 || x7==x6)
                                        continue;
                                    for(int x8=0;x8<10;x8++) {
                                        if(x8==x1 || x8==x2 || x8==x3 || x8==x4 || x8==x5 || x8==x6 || x8==x7)
                                            continue;
                                        if(x1==0 || x5==0)
                                            continue;
                                        int x = 1000*x1 + 100*x2 + 10*x3 + x4;
                                        int y = 1000*x5 + 100*x6 + 10*x7 + x2;
                                        int z = 10000*x5 + 1000*x6 + 100*x3 + 10*x2 + x8;

                                        if(x+y==z) {
                                            System.out.println(x+"+"+y+"=="+z);
                                            System.out.println(x1+" "+x2+" "+x3+" "+x4+" "+x5+" "+x6+" "+x7+" "+x8+" ");
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }

    }


}

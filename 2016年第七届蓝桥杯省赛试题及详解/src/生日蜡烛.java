/**
 * @author Wcy
 * @Date 2022/3/31 19:09
 */

/**
 * 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
 * <p>
 * 现在算起来，他一共吹熄了236根蜡烛。
 * <p>
 * 请问，他从多少岁开始过生日party的？
 * <p>
 * 请填写他开始过生日party的年龄数。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class 生日蜡烛 {
    public static void main(String[] args) {
        for(int i=1;i<=150;i++) {
            int s=0;
            for(int j=i;j<=150;j++) {
                s+=j;
                if(s==236)
                    System.out.println(i);
                if(s>236)
                    break;
            }
        }

    }

}

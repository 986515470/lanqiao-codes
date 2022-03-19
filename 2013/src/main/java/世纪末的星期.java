/**
 * @author Wcy
 * @Date 2022/3/19 16:03
 */

/**
 * 曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。
 * <p>
 * 还有人称今后的某个世纪末的12月31日，如果是星期一则会....
 * <p>
 * 有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!!
 * <p>
 * 于是，“谣言制造商”又修改为星期日......
 * <p>
 * 1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
 * <p>
 * 请回答该年份（只写这个4位整数，不要写12月31等多余信息）
 */
public class 世纪末的星期 {
    public static void main(String[] args) {
        //从2000年开始
        int i = 2000;
        // 0 1 2 3 4 5 6  代表七天
        int index = 4;
        while (true) {
            int days = 365;
            if ((i%100!=0 && i%4==0) || i%400==0)
                days = 366;
            int yu = days % 7;
            index = (index + yu) % 7;
//            System.out.println(i+":"+index);
            if (i % 100 == 99)
                if ((index == 6)) {
                    System.out.println(i);
                    break;
                }
            i++;
        }
    }
}

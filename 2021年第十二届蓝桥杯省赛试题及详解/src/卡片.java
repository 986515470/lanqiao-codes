/**
 * @author Wcy
 * @Date 2022/4/8 8:59
 */

/**
 * 小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。
 * <p>
 * 小蓝准备用这些卡片来拼一些数，他想从 1 开始拼出正整数，每拼一个， 就保存起来，卡片就不能用来拼其它数了。
 * <p>
 * 小蓝想知道自己能从 1 拼到多少。
 * <p>
 * 例如，当小蓝有 30 张卡片，其中 0 到 9 各 3 张，则小蓝可以拼出 1 到 10， 但是拼 11 时卡片 1 已经只有一张了，不够拼出 11。
 * <p>
 * 现在小蓝手里有 0 到 9 的卡片各 2021 张，共 20210 张，请问小蓝可以从 1 拼到多少？
 */
public class 卡片 {
    public static void main(String[] args) {
        int[] cards = new int[10];
        for (int i = 0; i < 10; i++) {
            cards[i] = 2021;
        }
        int sum = 0;
        out:
        while (true) {
            String str = String.valueOf(sum);
            for (int i = 0; i < str.length(); i++) {
                int num = Integer.parseInt(String.valueOf(str.charAt(i)));
                if (cards[num] > 0) {
                    cards[num]--;
                } else {
                    System.out.println(sum - 1);
                    break out;
                }
            }
            sum++;

        }
    }
}

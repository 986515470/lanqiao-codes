/**
 * @author Wcy
 * @Date 2022/3/28 15:28
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 把abcd...s共19个字母组成的序列重复拼接106次，得到长度为2014的串。
 * <p>
 * 接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字母。
 * <p>
 * 得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。
 * <p>
 * 答案是一个小写字母，请通过浏览器提交答案。不要填写任何多余的内容。
 */
public class 猜字母 {
    public static void main(String[] args) {
        String[] str = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"};

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < 106; i++) {
            strList.addAll(Arrays.asList(str));
        }
        while (true) {
            for (int i = 0; i < strList.size(); i++) {
                if (i % 2 == 0)
                    strList.set(i, "");
            }
            //或者直接使用字符串的replace也可以 看个人喜好
            System.out.println(Arrays.toString(strList.toArray()));
            while(strList.contains("")) {
                strList.remove("");
            }
            if(strList.size()==1) {
                System.out.println(Arrays.toString(strList.toArray()));
                break;
            }
        }

    }
}

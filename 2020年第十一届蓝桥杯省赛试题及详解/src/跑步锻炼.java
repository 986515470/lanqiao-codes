/**
 * @author Wcy
 * @Date 2022/4/6 20:11
 */

/**
 * 【问题描述】
 * 小蓝每天都锻炼身体。
 * 正常情况下，小蓝每天跑 1 千米。如果某天是周一或者月初（1 日），为了
 * 激励自己，小蓝要跑 2 千米。如果同时是周一或月初，小蓝也是跑 2 千米。
 * 小蓝跑步已经坚持了很长时间，从 2000 年 1 月 1 日周六（含）到 2020 年
 * 10 月 1 日周四（含）。请问这段时间小蓝总共跑步多少千米？
 * <p>
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 跑步锻炼 {

    static int sum = 0;

    public static void main(String[] args) {
        // 这里写代码
        int year = 2000;
        int month = 1;
        while (true) {

            int days = getDaysOfMonth(year, month);

            boolean ju = false;

            for (int i = 1; i <= days; i++) {

                int week = getWeek(year, month, i);

                if (year == 2020 && month == 10 && i == 1) {
                    ju = true;
                    break;
                }

                if (week == 1 || i == 1) {  //周一或月初
                    sum += 2;
                } else {
                    sum += 1;
                }
            }
            if (ju) {
                break;
            }
            if (month == 12) {
                year++;
                month = 1;
            } else {
                month++;
            }
        }
        System.out.println(sum);
    }

    //获取这个月有多少天
    public static int getDaysOfMonth(int year, int month) {
        int days = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            days = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }
        return days;
    }

    //判断这一天是星期几
    public static int getWeek(int year, int month, int day) {
        int week = 0;
        int[] weekDays = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        int y = year - 1;
        int sum = y * 365 + y / 4 - y / 100 + y / 400 + weekDays[month - 1] + day;
        week = sum % 7;
        return week;
    }

}

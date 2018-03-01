package calender;

import java.util.Calendar;
import java.util.Date;

/**
 * 2016/8/23 17:05.
 * <p>
 * Email: cheerUpPing@163.com
 * 日期测试类
 */
public class CalenderTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("每个月的第几天"+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("一个星期的第几天"+calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("一天的第几个小时,12小时制"+calendar.get(Calendar.HOUR));
        System.out.println("一天的第几个小时,24小时制"+calendar.get(Calendar.HOUR_OF_DAY));
        Date date = calendar.getTime();
        System.out.println(date.getTime()+"-"+calendar.getTimeInMillis());
    }

}

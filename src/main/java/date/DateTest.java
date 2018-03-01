package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2017/1/9 17:01.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse("1992-12-01 00:00:00");
        Date end = sdf.parse("1993-12-01 00:00:00");
        Period period = new Period(start,end);
        System.out.println("-----------------------");
        start.setTime(new Date().getTime());
        System.out.println("===================");
    }

}


final class Period {

    private Date start;

    private Date end;

    public Period(Date start,Date end){
        if (start.getTime()>=end.getTime()){
            throw new RuntimeException("开始时间必须小于结束时间...");
        }
        this.start = start;
        this.end = end;
    }
}
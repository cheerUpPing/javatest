import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2017/8/18 11:25.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class Test {

    private static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("cmd /C tasklist");
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));//windows的默认系统中文编码是gbk所以从cmd控制台的信息已gbk来解码
        String line = null;
        while ((line = reader.readLine()) != null)
            System.out.println(line);
    }

}

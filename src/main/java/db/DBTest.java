package db;

import org.apache.commons.dbutils.DbUtils;

import java.sql.SQLException;

/**
 * 2017/9/5 16:47.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class DBTest {

    public static void main(String[] args) throws SQLException {
        DbUtils.rollback(null);
    }
}

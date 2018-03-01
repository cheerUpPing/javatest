package datasource;

import org.apache.commons.configuration.ConfigurationUtils;

import javax.sql.DataSource;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

/**
 * 2017/7/26 16:49.
 * <p>
 * Email: cheerUpPing@163.com
 * <p>
 * 自定义数据库连接池
 */
public class CustomDataSource implements DataSource {

    //保存数据库连接--队列
    private static ConcurrentLinkedQueue<Connection> connectionQueue = new ConcurrentLinkedQueue();
    private static String driver = null;
    private static String password = null;
    private static String username = null;
    private static String db_url = null;
    private static String minconnects = null;

    static {
        try {
            URL url = ConfigurationUtils.locate("db.properties");
            InputStream is = new FileInputStream(url.getPath());
            final Properties properties = new Properties();
            properties.load(is);
            driver = properties.getProperty("driver");
            password = properties.getProperty("password");
            username = properties.getProperty("username");
            db_url = properties.getProperty("url");
            minconnects = properties.getProperty("minconnects");
            Class.forName(driver);
            for (int i = 0; i < Integer.parseInt(minconnects); i++) {
                Connection connection = DriverManager.getConnection(db_url, username, password);
                connectionQueue.add(connection);
            }
            System.out.println("-----------------------数据库初始化完毕-----------------------");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection con = null;
        if (connectionQueue.size() > 0) {
            final Connection connection = connectionQueue.remove();
            con = (Connection) Proxy.newProxyInstance(CustomDataSource.class.getClassLoader(), Connection.class.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("close")) {
                        connectionQueue.add(connection);
                    } else {
                        return method.invoke(connection, args);
                    }
                    return null;
                }
            });
        } else {
            con = DriverManager.getConnection(db_url, username, password);
        }
        return con;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

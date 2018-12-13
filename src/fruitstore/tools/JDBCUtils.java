package fruitstore.tools;

import java.sql.*;

/**
 * 工具类
 */
@SuppressWarnings("all")
public class JDBCUtils {
    // 加载驱动，并建立数据可连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/fruitstore?characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    // 关闭数据库连接，释放资源
    public static void release(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } // try
            statement = null;
        } // if

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } // try
            connection = null;
        } // if
    } // release


    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } // try
            resultSet = null;
        } // if
        release(statement, connection);
    } // release
}

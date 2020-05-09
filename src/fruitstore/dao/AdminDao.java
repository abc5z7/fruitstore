package fruitstore.dao;

import fruitstore.data.DataBase;
import fruitstore.domain.FruitItem;
import fruitstore.domain.UserItem;
import fruitstore.tools.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 管理员数据访问类
 */
@SuppressWarnings("all")
public class AdminDao {
    // 获取所有数据
    public ArrayList<FruitItem> queryAllData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<FruitItem> list = new ArrayList<>();
        try {
            // 获得数据的连接
            connection = JDBCUtils.getConnection();
            // 获得Statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM fruit";
            resultSet = statement.executeQuery(sql);
            // 处理结果集
            while (resultSet.next()) {
                FruitItem fruitItem = new FruitItem();
                fruitItem.setNumber(resultSet.getString("number"));
                fruitItem.setName(resultSet.getString("fruitname"));
                fruitItem.setPrice(resultSet.getDouble("price"));
                fruitItem.setUnit(resultSet.getString("unit"));
                list.add(fruitItem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, statement, connection);
        }
        return null;
    } // queryAddData


    // 添加数据
    public void addFruitItem(FruitItem fruitItem) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 获取数据的连接
            connection = JDBCUtils.getConnection();
            // 获得Statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "INSERT INTO fruit(number, fruitname, price, unit)"
                    + "VALUES(" + fruitItem.getNumber() + ",'"
                    + fruitItem.getName() + "','" +fruitItem.getPrice()
                    + "','" + fruitItem.getUnit() + "')";
            int num = statement.executeUpdate(sql);     // 返回受影响的行数
            if (num > 0) {
                System.out.println("插入数据成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(statement, connection);
        }
    } //addFruitItem


    // 删除数据
    public void delFruitItem(String delNumber) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 获得数据的对象
            connection = JDBCUtils.getConnection();
            // 获得Statement对象
            statement = connection.createStatement();
            //发送SQL语句
            String sql = "DELETE FROM fruit WHERE number = " + delNumber;
            int num = statement.executeUpdate(sql);
            if (num > 0) {
                System.out.println("删除数据成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(statement, connection);
        } // try

        // 查询集合中数据
        for (int i = 0; i < DataBase.data.size(); i++) {
            FruitItem thisFruitItem = DataBase.data.get(i);
            // 如果有水果项的标号与传入编号相同，则从集合中删除
            if (thisFruitItem.getNumber().equals(delNumber)) {
                DataBase.data.remove(i);
            } // if
        } // for
    } // delFruitItem


    public ArrayList<UserItem> queryAllUser() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<UserItem> list = new ArrayList<>();
        try {
            // 获得数据的连接
            connection = JDBCUtils.getConnection();
            // 获得Statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM user";
            resultSet = statement.executeQuery(sql);
            // 处理结果集
            while (resultSet.next()) {
                FruitItem fruitItem = new FruitItem();
                UserItem userItem = new UserItem();
                userItem.setUsername(resultSet.getString("username"));
                userItem.setPwd(resultSet.getString("password"));
                list.add(userItem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(resultSet, statement, connection);
        }
        return null;
    }
}

package fruitstore.service;

import fruitstore.dao.AdminDao;
import fruitstore.domain.FruitItem;
import fruitstore.domain.UserItem;

import java.util.ArrayList;

/**
 * 管理员服务类
 */
public class AdminService {
    private AdminDao adminDao = new AdminDao();
    // 查询服务
    public ArrayList<FruitItem> queryFruitItem() {
        // 调用Dao层的获取所有数据方法所有数据
        ArrayList<FruitItem> data = adminDao.queryAllData();
        // 返回数据
        return data;
    } // queryFruitItem


    // 添加服务
    public boolean addFruitItem(String number, String name, String price, String unit) {

        // 编号判空
        if (number.equals("")) {
            return false;
        }
        // 调用Dao层的获取所有数据方法获取所有数据
        ArrayList<FruitItem> data = queryFruitItem();
        // 使用输入的编号与所有数据对比
        for (FruitItem fruitItem : data) {
            // 如果存在重复的编号数据，则添加不成功
            if (number.equals(fruitItem.getNumber())) {
                return false;
            }
        }
        // 如果没有重复编号，将数据封装为FruitItem对象
        FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
        // 调用DAO层的添加数据方法
        adminDao.addFruitItem(thisFruitItem);
        // 在添加数据后，返回添加成功
        return true;
    } // addFruitItem


    // 修改服务
    public boolean updateFruitItem(String number, String name, String price, String unit) {
        // 调用Dao层的获取所有数据方法获取所有数据
        ArrayList<FruitItem> data = queryFruitItem();
        // 使用输入的编号与所有数据对比
        for (FruitItem fruitItem : data) {
            // 如果存在相同编号数据，则可以更新
            if (number.equals(fruitItem.getNumber())) {
                // 调用Dao层的删除指定编号数据方法
                adminDao.delFruitItem(number);
                // 如果没有重复，将数据封装为FruitItem对象
                FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
                // 调用Dao层的添加数据方法
                adminDao.addFruitItem(thisFruitItem);
                // 在修改数据后，返回添加成功
                return true;
            }
        }
        // 如果不存在相同编号数据，则不可以更新
        return false;
    } // updateFruitItem


    // 删除服务
    public boolean delFruitItem(String delNumber) {
        // 调用Dao层的获取所有数据方法获取所有数据
        ArrayList<FruitItem> data = queryFruitItem();
        // 使用输入的编号与所有数据对比
        for (FruitItem fruitItem : data) {
            // 如果存在相同编号数据，则可以删除
            if (delNumber.equals(fruitItem.getNumber())) {
                // 调用Dao层的删除指定编号数据方法
                adminDao.delFruitItem(delNumber);
                // 在删除数据后，返回添加方法
                return true;
            }
        }
        // 如果不存在相同编号数据，则不可以删除
        return false;
    } // delFruitItem

    public ArrayList<UserItem> queryUserItem() {
        // 调用Dao层的获取所有数据方法所有数据
        ArrayList<UserItem> data = adminDao.queryAllUser();
        // 返回数据
        return data;
    } // queryFruitItem

    public  boolean login(String username, String pwd) {
        ArrayList<UserItem> data = queryUserItem();
        for (UserItem userItem: data) {
            if (username.equals(userItem.getUsername()) && pwd.equals(userItem.getPwd())){
                return true;
            }
        }
        return false;
    }
}

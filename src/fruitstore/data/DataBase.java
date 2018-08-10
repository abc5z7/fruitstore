package fruitstore.data;

import fruitstore.domain.FruitItem;

import java.util.ArrayList;

/**
 * 存储数据
 */
public class DataBase {
    public static ArrayList<FruitItem> data = new ArrayList<>();
    // 初始数据
    static {
        data.add(new FruitItem("1", "苹果", 5.0, "kg"));
    }
}

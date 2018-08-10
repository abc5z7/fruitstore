package fruitstore.test;

import fruitstore.view.AbstractAdminDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 管理界面测试
 */
public class AbstractAdminDialogTest extends AbstractAdminDialog {
    // 定义构造函数初始化数据
    public AbstractAdminDialogTest() {
        super();
    }
    // 加入测试table数据
    @Override
    public void queryFruitItem() {
        String[] thead = new String[]{"水果编号", "水果名称",  "水果单价(/元)", "计价单位"};
        String[][] tbody = new String[][] {
                {"1", "苹果", "5.0", "kg"},
                {"2", "葡萄", "3.2", "斤"}
        };
        TableModel data = new DefaultTableModel(tbody, thead);
        table.setModel(data);
    }
    @Override
    public void addFruitItem() {
    }
    @Override
    public void updateFruitItem() {
    }
    @Override
    public void delFruitItem() {
    }
    // 定义主函数运行程序
    public static void main(String[] agrs) {
        new AbstractAdminDialogTest().setVisible(true);
    }
}

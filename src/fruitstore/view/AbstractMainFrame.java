package fruitstore.view;

import fruitstore.tools.GUITools;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗口类
 */
@SuppressWarnings("serial")
public abstract class AbstractMainFrame extends JFrame {
    // 组件
    private JLabel titleLabel = new JLabel(new ImageIcon("./img/iconFall.jpg"));
    private JButton btn = new JButton("进入系统");      // 顾客按钮
    // 构造函数
    public AbstractMainFrame() {
        this.init();        // 初始化操作
        this.addComponent();        // 添加组件
        this.addListener();     // 添加监听器
    }


    // 初始化操作
    private void init() {
        this.setTitle("水果超市欢迎您!");      // 标题
        this.setSize(600, 400);     // 窗口大小与位置
        this.setResizable(false);       // 窗口大小固定
        GUITools.center(this);      // 设置窗口在屏幕上的位置
        GUITools.setTitleImage(this, "./img/iconFall.jpg");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // init


    // 添加组件
    private void addComponent() {
        // 窗口使用默认的边界布局，北区放入图片
        this.add(this.titleLabel, BorderLayout.NORTH);
        // 创建JPanel对象
        JPanel btnPanel = new JPanel();
        // 清除布局，使JPanel中的组件可以自定义位置
        btnPanel.setLayout(null);
        // 将JPanel对象添加到窗口中
        this.add(btnPanel);
        // 定义边界位置
        btn.setBounds(240, 20, 120, 50);
        // 将按钮添加到JPanel对象中
        btnPanel.add(btn);
    } // addComponent


    // 添加监听器
    private void addListener() {
        btn.addActionListener(e -> showAdminDialog());
    }
    // 展示管理员界面方法
    public abstract void showAdminDialog();

}

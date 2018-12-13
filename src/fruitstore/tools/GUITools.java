package fruitstore.tools;

import javax.swing.*;
import java.awt.*;

public class GUITools {
    // java提供的GUI默认工具类对象
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    // 将指定组件屏幕居中
    public static void center(Component c) {
        int y = (toolkit.getScreenSize().height - c.getHeight()) / 2;
        int x = (toolkit.getScreenSize().width - c.getWidth()) / 2;
        c.setLocation(x, y);
    }


    // 为指定窗口设置图标标题
    public static void setTitleImage(JFrame frame, String titleIconPath) {
        frame.setIconImage(toolkit.createImage(titleIconPath));
    }
}

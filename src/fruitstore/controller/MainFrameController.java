package fruitstore.controller;

import fruitstore.service.AdminService;
import fruitstore.view.AbstractMainFrame;

import javax.swing.*;

/**
 * 主界面操作类
 */
public class MainFrameController extends AbstractMainFrame {

    private AdminService adminService = new AdminService();

    @Override
    public void showAdminDialog() {
        // 在该方法中创建管理员界面并显示
        // this为父窗口（主界面）true：设置组为模态窗口展示
        new AdminDialogController(this, true).setVisible(true);
    }
    @Override
    public void login() {
        String username = usernameText.getText();
        String pwd = pwdText.getText();
        boolean loginSuccess = adminService.login(username, pwd);
        if (loginSuccess) {
            this.showAdminDialog();
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码错误");
        }
    }
}

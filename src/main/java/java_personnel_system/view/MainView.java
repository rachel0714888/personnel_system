package java_personnel_system.view;

import java_personnel_system.controller.ManagerController;
import java_personnel_system.controller.NoticeController;
import java_personnel_system.controller.StaffController;
import java_personnel_system.controller.UserController;
import java_personnel_system.pojo.User;
import java_personnel_system.service.UserService;
import java_personnel_system.util.ConnectionPool;
import java_personnel_system.util.Print;
import java_personnel_system.util.RandomStr;
import lombok.SneakyThrows;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther Rachel
 * @date 2023/6/11 11:20
 */
public class MainView {
    public static ConnectionPool cp = new ConnectionPool(15);
    public static ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,
                    new LinkedBlockingDeque<Runnable>());
    private static Scanner sc = new Scanner(System.in);
    public static User currentUser = null;

    public static void mainView() throws Exception {
        //每有一个用户使用系统，为他分配一个线程
        Runnable r = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                MainView.mainView();
            }
        };
        threadPool.execute(r);
        //必须要登录，且验证是在职员工才能进入系统
        UserService.login();
    }

    public static void adminUserView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.添加用户");
        Print.print("2.删除用户");
        Print.print("3.修改用户");
        Print.print("4.查询用户");
        Print.print("5.返回上一级");
        String inputKey = sc.nextLine();
        UserController.userController(inputKey);
    }

    public static void userSelectView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.查询全部用户");
        Print.print("2.查询指定用户");
        Print.print("3.返回上一级");
        String inputKey = sc.nextLine();
        UserController.userSelectController(inputKey);
    }

    public static void userLikeSelectView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.根据用户名查询用户信息");
        Print.print("2.根据用户状态查询用户信息");
        String inputKey = sc.nextLine();
        UserController.userLikeSelectController(inputKey);
    }

    public static void userRemoveView() throws Exception {
        Print.print("请输入你想根据什么删除用户：");
        Print.print("1.用户id");
        Print.print("2.用户名");
        Print.print("3.用户的员工id");
        Print.print("4.用户状态");
        Print.print("5.返回上一级");
        String inputKey = sc.nextLine();
        UserController.userRemoveController(inputKey);
    }

    public static void staffView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.添加员工");
        Print.print("2.删除员工");
        Print.print("3.修改员工信息");
        Print.print("4.查询员工信息");
        Print.print("5.返回上一级");
        String inputKey = sc.nextLine();
        StaffController.staffController(inputKey);
    }

    public static void staffRemoveView() throws Exception {
        Print.print("请输入你想根据什么删除员工：");
        Print.print("1.员工id");
        Print.print("2.员工名");
        Print.print("3.返回上一级");
        String inputKey = sc.nextLine();
        StaffController.staffRemoveController(inputKey);
    }

    public static void staffSelectView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.查询全部员工");
        Print.print("2.查询指定员工");
        Print.print("3.返回上一级");
        String inputKey = sc.nextLine();
        StaffController.staffSelectController(inputKey);
    }

    public static void staffLikeSelectView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.根据员工id查询员工信息");
        Print.print("2.根据员工姓名查询员工信息");
        Print.print("3.根据员工性别查询员工信息");
        Print.print("4.根据员工部门id查询员工信息");
        Print.print("5.根据员工职位id查询员工信息");
        Print.print("6.根据员工民族查询员工信息");
        Print.print("7.根据员工学历查询员工信息");
        Print.print("8.根据员工身份证查询员工信息");
        Print.print("9.根据员工手机号查询员工信息");
        String inputKey = sc.nextLine();
        StaffController.staffLikeSelectController(inputKey);
    }

    public static void noticeSelectView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.所有公告查询");
        Print.print("2.指定公告查询");
        String inputKey = sc.nextLine();
        NoticeController.noticeSelectViewController(inputKey);
    }

    public static void noticeLikeSelectView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.根据公告名查询");
        Print.print("2.根据公告内容查询");
        String inputKey = sc.nextLine();
        NoticeController.noticeLikeSelectController(inputKey);
    }
}

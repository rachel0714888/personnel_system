package java_personnel_system.view;

import java_personnel_system.DAO.UserDao;
import java_personnel_system.DAO.UserDaoimpl;
import java_personnel_system.controller.OrdinaryUserController;
import java_personnel_system.controller.PersonnelController;
import java_personnel_system.util.Print;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/12 14:53
 */
public class OrdinaryUserView {
    private static Scanner sc = new Scanner(System.in);

    public static void ordinaryUserView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.用户模式");
        Print.print("2.员工模式");
        Print.print("3.公告信息查询");
        String inputKey = sc.nextLine();
        OrdinaryUserController.ordinaryUserController(inputKey);
    }

    public static void userView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.查看用户信息");
        Print.print("2.修改用户信息");
        String inputKey = sc.nextLine();
        OrdinaryUserController.userController(inputKey);
    }

    public static void staffView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.查看员工信息");
        Print.print("2.修改员工信息");
        String inputKey = sc.nextLine();
        OrdinaryUserController.staffController(inputKey);
    }
}

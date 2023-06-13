package java_personnel_system.view;

import java_personnel_system.controller.ManagerController;
import java_personnel_system.controller.UserController;
import java_personnel_system.util.Print;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/12 1:03
 */
public class ManagerView {
    private static Scanner sc = new Scanner(System.in);

    public static void managerView() throws Exception {
        Print.print("请输入你想访问的模块");
        Print.print("1.用户模块");
        Print.print("2.部门模块");
        Print.print("3.职位模块");
        Print.print("4.员工模块");
        Print.print("5.公告模块");
        String inputKey = sc.nextLine();
        ManagerController.managerController(inputKey);
    }

    public static void managerDepartmentView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.添加部门");
        Print.print("2.删除部门");
        Print.print("3.修改部门");
        Print.print("4.查询部门");
        Print.print("5.返回上一级");
        String inputKey = sc.nextLine();
        ManagerController.departmentController(inputKey);
    }

    public static void departmentRemoveView() throws Exception {
        Print.print("请输入你想根据什么删除部门");
        Print.print("1.部门id");
        Print.print("2.部门名");
        String inputKey = sc.nextLine();
        ManagerController.departmentRemoveController(inputKey);
    }

    public static void departmentSelectView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.查询所有部门");
        Print.print("2.查询指定部门");
        String inputKey = sc.nextLine();
        ManagerController.departmentSelectController(inputKey);
    }

    public static void positionView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.添加职位");
        Print.print("2.删除职位");
        Print.print("3.修改职位");
        Print.print("4.查询职位");
        Print.print("5.返回上一级");
        String inputKey = sc.nextLine();
        ManagerController.positionController(inputKey);
    }

    public static void positionRemoveView() throws Exception {
        Print.print("请输入你想根据什么删除职位");
        Print.print("1.职位id");
        Print.print("2.职位名");
        String inputKey = sc.nextLine();
        ManagerController.positionRemoveController(inputKey);
    }

    public static void positionSelectView() throws Exception {
        Print.print("请输入你想访问的功能");
        Print.print("1.查询所有职位");
        Print.print("2.查询指定职位");
        String inputKey = sc.nextLine();
        ManagerController.positionSelectController(inputKey);
    }

    public static void noticeView() throws Exception{
        Print.print("请输入你想访问的功能");
        Print.print("1.发布公告");
        Print.print("2.删除公告");
        Print.print("3.更改公告");
        Print.print("4.查询公告");
        String inputKey = sc.nextLine();
        ManagerController.noticeController(inputKey);
    }



}

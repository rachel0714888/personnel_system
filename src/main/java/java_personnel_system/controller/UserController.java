package java_personnel_system.controller;

import java_personnel_system.service.UserService;
import java_personnel_system.util.Print;
import java_personnel_system.view.MainView;
import java_personnel_system.view.ManagerView;
import java_personnel_system.view.PersonnelView;

/**
 * @auther Rachel
 * @date 2023/6/11 21:17
 */
public class UserController {

    //总经理和人事部长的用户管理
    public static void userController(String key) throws Exception {
        switch (key) {
            case "1":
                UserService.userAdd();
                Print.print("正在为您添加用户...");
                Thread.sleep(3000);
                Print.print("用户添加成功");
                MainView.adminUserView();
                break;
            case "2":
                MainView.userRemoveView();
                Print.print("正在为您删除用户...");
                Thread.sleep(3000);
                Print.print("用户删除成功");
                MainView.adminUserView();
                break;
            case "3":
                UserService.userChange();
                Print.print("正在为您修改用户信息...");
                Thread.sleep(3000);
                Print.print("用户信息修改成功");
                MainView.adminUserView();
                break;
            case "4":
                MainView.userSelectView();
                break;
            case "5":
                if (MainView.currentUser.getUserAuthority() == 0) {
                    ManagerView.managerView();
                }
                if (MainView.currentUser.getUserAuthority() == 1) {
                    PersonnelView.personnelView();
                }
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.adminUserView();
        }
    }

    public static void userSelectController(String key) throws Exception {
        switch (key) {
            case "1":
                UserService.userAllSelect();
                MainView.adminUserView();
                break;
            case "2":
                MainView.userLikeSelectView();
                MainView.adminUserView();
                break;
            case "3":
                MainView.adminUserView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.userSelectView();
        }
    }

    public static void userLikeSelectController(String key) throws Exception {
        switch (key) {
            case "1":
                UserService.userLikeNameSelect();
                break;
            case "2":
                UserService.userLikeIsOnworkSelect();
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.userLikeSelectView();
        }
    }

    public static void userRemoveController(String key) throws Exception {
        switch (key) {
            case "1":
                UserService.userIdRemove();
                break;
            case "2":
                UserService.userNameRemove();
                break;
            case "3":
                UserService.userStaffIdRemove();
                break;
            case "4":
                UserService.userIsWorkRemove();
                break;
            case "5":
                MainView.adminUserView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.userRemoveView();
        }
    }



}


package java_personnel_system.controller;

import java_personnel_system.DAO.UserDao;
import java_personnel_system.DAO.UserDaoimpl;
import java_personnel_system.service.StaffService;
import java_personnel_system.service.UserService;
import java_personnel_system.util.Print;
import java_personnel_system.view.MainView;
import java_personnel_system.view.OrdinaryUserView;

/**
 * @auther Rachel
 * @date 2023/6/12 14:51
 */
public class OrdinaryUserController {

    public static void ordinaryUserController(String key) throws Exception {
        switch (key){
            case "1":
                OrdinaryUserView.userView();
                break;
            case "2":
                OrdinaryUserView.staffView();
                break;
            case "3":
                MainView.noticeSelectView();
                OrdinaryUserView.ordinaryUserView();
                break;
            default:
                Print.print("输入有误");
                OrdinaryUserView.ordinaryUserView();
        }
    }

    public static void userController(String key) throws Exception {
        switch (key){
            case "1":
                Print.ordinaryUserMsgPrint(MainView.currentUser);
                OrdinaryUserView.ordinaryUserView();
                break;
            case "2":
                UserService.ordinaryUserMsgUpdate();
                Print.print("正在为您修改信息...");
                Thread.sleep(3000);
                Print.print("信息修改完毕");
                OrdinaryUserView.ordinaryUserView();
                break;
            default:
                Print.print("输入有误");
                OrdinaryUserView.userView();
        }
    }

    public static void staffController(String key) throws Exception {
        switch (key){
            case "1":
                StaffService.selectStaffIdNoInput(MainView.currentUser.getUserStaffId());
                OrdinaryUserView.ordinaryUserView();
                break;
            case "2":
                StaffService.ordinaryUserUpdateStaffMsg();
                Print.print("正在为您修改信息...");
                Thread.sleep(3000);
                Print.print("信息修改完毕");
                OrdinaryUserView.ordinaryUserView();
                break;
            default:
                Print.print("输入有误");
                OrdinaryUserView.staffView();
        }
    }
}

package java_personnel_system.controller;

import java_personnel_system.service.StaffService;
import java_personnel_system.util.Print;
import java_personnel_system.view.MainView;
import java_personnel_system.view.ManagerView;
import java_personnel_system.view.OrdinaryUserView;
import java_personnel_system.view.PersonnelView;

/**
 * @auther Rachel
 * @date 2023/6/12 10:18
 */
public class StaffController {

    public static void staffController(String key) throws Exception {
        switch (key) {
            case "1":
                StaffService.addStaff();
                Print.print("正在增加员工...");
                Thread.sleep(3000);
                Print.print("员工增加成功");
                MainView.staffView();
                break;
            case "2":
                MainView.staffRemoveView();
                Print.print("正在删除员工...");
                Thread.sleep(3000);
                Print.print("员工删除成功");
                MainView.staffView();
                break;
            case "3":
                StaffService.updateStaffMsg();
                Print.print("正在更新员工信息...");
                Thread.sleep(3000);
                Print.print("员工信息更新成功");
                MainView.staffView();
                break;
            case "4":
                MainView.staffSelectView();
                MainView.staffView();
                break;
            case "5":
                if (MainView.currentUser.getUserAuthority()==0){
                    ManagerView.managerView();
                }
                if (MainView.currentUser.getUserAuthority()==1){
                    PersonnelView.personnelView();
                }
                if (MainView.currentUser.getUserAuthority()==2){
                    OrdinaryUserView.ordinaryUserView();
                }
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.staffView();
        }
    }

    public static void staffRemoveController(String key) throws Exception {
        switch (key) {
            case "1":
                StaffService.removeStaffId();
                break;
            case "2":
                StaffService.removeStaffName();
                break;
            case "3":
                MainView.staffView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.staffRemoveView();
        }
    }

    public static void staffSelectController(String key) throws Exception {
        switch (key) {
            case "1":
                StaffService.selectAllStaffMsg();
                MainView.staffView();
                break;
            case "2":
                MainView.staffLikeSelectView();
                MainView.staffView();
                break;
            case "3":
                MainView.staffView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.staffSelectView();
        }
    }

    public static void staffLikeSelectController(String key) throws Exception {
        switch (key) {
            case "1":
                StaffService.selectStaffId();
                MainView.staffView();
                break;
            case "2":
                StaffService.selectStaffName();
                MainView.staffView();
                break;
            case "3":
                StaffService.selectStaffSex();
                MainView.staffView();
                break;
            case "4":
                StaffService.selectStaffDepartmentId();
                MainView.staffView();
                break;
            case "5":
                StaffService.selectStaffPrositionId();
                MainView.staffView();
                break;
            case "6":
                StaffService.selectStaffNation();
                MainView.staffView();
                break;
            case "7":
                StaffService.selectStaffEducation();
                MainView.staffView();
                break;
            case "8":
                StaffService.selectStaffIdentityId();
                MainView.staffView();
                break;
            case "9":
                StaffService.selectStaffPhonenum();
                MainView.staffView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                MainView.staffSelectView();
        }
    }
}

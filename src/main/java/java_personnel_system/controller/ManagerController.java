package java_personnel_system.controller;

import java_personnel_system.pojo.Notice;
import java_personnel_system.pojo.Position;
import java_personnel_system.service.DepartmentService;
import java_personnel_system.service.NoticeService;
import java_personnel_system.service.PositionService;
import java_personnel_system.util.Print;
import java_personnel_system.view.MainView;
import java_personnel_system.view.ManagerView;

/**
 * @auther Rachel
 * @date 2023/6/12 1:17
 */
public class ManagerController {
    public static void managerController(String key) throws Exception {
        switch (key) {
            case "1":
                Print.print("即将跳转到用户模块...");
                Thread.sleep(3000);
                MainView.adminUserView();
                break;
            case "2":
                Print.print("即将跳转到部门模块...");
                Thread.sleep(3000);
                ManagerView.managerDepartmentView();
                break;
            case "3":
                Print.print("即将跳转到职位模块...");
                Thread.sleep(3000);
                ManagerView.positionView();
                break;
            case "4":
                Print.print("即将跳转到员工模块...");
                Thread.sleep(3000);
                MainView.staffView();
                break;
            case "5":
                Print.print("即将跳转到公告模块...");
                Thread.sleep(3000);
                ManagerView.noticeView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.managerView();
        }
    }

    public static void departmentController(String key) throws Exception {
        switch (key) {
            case "1":
                DepartmentService.addDepartment();
                Print.print("正在添加部门...");
                Thread.sleep(3000);
                Print.print("部门添加成功");
                ManagerView.managerView();
                break;
            case "2":
                ManagerView.departmentRemoveView();
                Print.print("正在删除部门...");
                Thread.sleep(3000);
                Print.print("部门删除成功");
                ManagerView.managerView();
                break;
            case "3":
                DepartmentService.changeDepartmentMsg();
                Print.print("正在更新部门信息...");
                Thread.sleep(3000);
                Print.print("部门信息更新成功");
                ManagerView.managerView();
                break;
            case "4":
                ManagerView.departmentSelectView();
                ManagerView.managerView();
                break;
            case "5":
                ManagerView.managerView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.managerDepartmentView();
        }
    }

    public static void departmentRemoveController(String key) throws Exception {
        switch (key) {
            case "1":
                DepartmentService.removeDepartmentId();
                break;
            case "2":
                DepartmentService.removeDepartmentName();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.departmentRemoveView();
        }
    }

    public static void departmentSelectController(String key) throws Exception {
        switch (key) {
            case "1":
                DepartmentService.selectAllDepartmentMsg();
                break;
            case "2":
                DepartmentService.selectLikeDepartmentName();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.managerDepartmentView();
        }
    }

    public static void positionController(String key) throws Exception {
        switch (key) {
            case "1":
                //在职位页面选择1——添加职位 进入职位服务
                PositionService.addPosition();
                Print.print("正在添加职位...");
                Thread.sleep(3000);
                Print.print("职位添加成功");
                ManagerView.managerView();
                break;
            case "2":
                //在职位页面选择2——删除职位 进入职位删除页面
                ManagerView.positionRemoveView();
                Print.print("正在删除职位...");
                Thread.sleep(3000);
                Print.print("职位删除成功");
                ManagerView.managerView();
                break;
            case "3":
                //在职位页面选择3——修改职位 进入职位服务
                PositionService.changePositionMsg();
                Print.print("正在更改职位...");
                Thread.sleep(3000);
                Print.print("职位更改成功");
                ManagerView.managerView();
                break;
            case "4":

                ManagerView.managerView();
                break;
            case "5":
                ManagerView.managerView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.positionView();
        }
    }

    public static void positionRemoveController(String key) throws Exception {
        switch (key) {
            case "1":
                PositionService.removePositionId();
                break;
            case "2":
                PositionService.removePositionName();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.positionRemoveView();
        }
    }

    public static void positionSelectController(String key) throws Exception {
        switch (key) {
            case "1":
                PositionService.selectAllPositionMsg();
                break;
            case "2":
                PositionService.selectLikePositionName();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.positionView();
        }
    }

    public static void noticeController(String key) throws Exception {
        switch (key) {
            case "1":
                NoticeService.addNotice();
                Print.print("正在添加公告...");
                Thread.sleep(3000);
                Print.print("公告添加成功");
                ManagerView.noticeView();
                break;
            case "2":
                NoticeService.removeNotice();
                Print.print("正在删除公告...");
                Thread.sleep(3000);
                Print.print("公告删除成功");
                ManagerView.noticeView();
                break;
            case "3":
                NoticeService.updateNotice();
                Print.print("正在更改公告...");
                Thread.sleep(3000);
                Print.print("公告更改成功");
                ManagerView.noticeView();
                break;
            case "4":
                MainView.noticeSelectView();
                ManagerView.noticeView();
                break;
            default:
                Print.print("输入有误，请重新输入");
                ManagerView.managerView();
        }
    }

}

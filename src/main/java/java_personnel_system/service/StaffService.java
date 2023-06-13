package java_personnel_system.service;

import java_personnel_system.DAO.StaffDao;
import java_personnel_system.DAO.StaffDaoimpl;
import java_personnel_system.pojo.Staff;
import java_personnel_system.util.Print;
import java_personnel_system.view.MainView;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/12 10:20
 */
public class StaffService {
    private static Scanner sc = new Scanner(System.in);
    private static StaffDao staffDao = new StaffDaoimpl();

    public synchronized static void addStaff() throws Exception {
        Print.print("请输入您想要添加的员工姓名：");
        String staffName = sc.next();
        Print.print("请输入您想要添加的员工性别：");
        String staffSex = sc.next();
        Print.print("请输入您想要添加的员工的部门id：");
        int sdepartmentId = sc.nextInt();
        Print.print("请输入您想要添加的员工的职位id：");
        int spositionId = sc.nextInt();
        Print.print("请输入您想要添加的员工的民族：");
        String staffNation = sc.next();
        Print.print("请输入您想要添加的员工的学历：");
        String staffEducation = sc.next();
        Print.print("请输入您想要添加的员工的身份证：");
        String staffIdentityId = sc.next();
        if (staffDao.staffIdentityIdNameExist(staffIdentityId)) {
            Print.print("员工已存在");
            MainView.staffView();
        }
        Print.print("请输入您想要添加的员工的电话号码：");
        String staffPhonenum = sc.next();
        if (staffDao.staffPhoneNumNameExist(staffPhonenum)) {
            Print.print("员工已存在");
            MainView.staffView();
        }
        staffDao.staffAdd(new Staff(staffName, staffSex, sdepartmentId, spositionId, staffNation, staffEducation, staffIdentityId, staffPhonenum));
    }

    public synchronized static void removeStaffId() throws Exception {
        Print.print("请输入您想要删除的员工id：");
        int staffId = sc.nextInt();
        if (!staffDao.staffIdExist(staffId)){
            Print.print("员工不存在");
            removeStaffId();
        }
        staffDao.removeStaffId(staffId);
        staffDao.tableAlter();
    }

    public synchronized static void removeStaffName() throws Exception {
        Print.print("请输入您想要删除的员工姓名：");
        String staffName = sc.next();
        if (!staffDao.staffNameExist(staffName)){
            Print.print("员工不存在");
            removeStaffName();
        }
        staffDao.removeStaffName(staffName);
        staffDao.tableAlter();
    }

    public static void updateStaffMsg() throws Exception {
        Print.print("请输入您想要修改的员工的员工id");
        int staffId = sc.nextInt();
        if (!staffDao.staffIdExist(staffId)){
            Print.print("员工不存在");
            updateStaffMsg();
        }
        Print.print("请输入您修改后的员工姓名：");
        String staffName = sc.next();
        Print.print("请输入您修改后的员工性别：");
        String staffSex = sc.next();
        Print.print("请输入您修改后的员工的部门id：");
        int sdepartmentId = sc.nextInt();
        Print.print("请输入您修改后的员工的职位id：");
        int spositionId = sc.nextInt();
        Print.print("请输入您修改后的员工的民族：");
        String staffNation = sc.next();
        Print.print("请输入您修改后的员工的学历：");
        String staffEducation = sc.next();
        Print.print("请输入您修改后的员工的身份证：");
        String staffIdentityId = sc.next();
        Print.print("请输入您修改后的员工的电话号码：");
        String staffPhonenum = sc.next();
        staffDao.updateStaffMsg(new Staff(staffId, staffName, staffSex, sdepartmentId, spositionId, staffNation, staffEducation, staffIdentityId, staffPhonenum));
    }

    public static void ordinaryUserUpdateStaffMsg() throws Exception {
        Print.print("请输入您修改后的员工姓名：");
        String staffName = sc.next();
        Print.print("请输入您修改后的员工的身份证：");
        String staffIdentityId = sc.next();
        Print.print("请输入您修改后的员工的电话号码：");
        String staffPhonenum = sc.next();
        staffDao.ordinaryUserUpdateStaffMsg(staffName,staffIdentityId,staffPhonenum);
    }

    public static void selectAllStaffMsg() throws Exception {
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectAllStaffMsg();
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffId() throws Exception {
        Print.print("请输入您想要查询的员工的员工id");
        int staffId = sc.nextInt();
        if (!staffDao.staffIdExist(staffId)){
            Print.print("员工不存在");
            selectStaffId();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffId(staffId);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffIdNoInput(int staffId) throws Exception {
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffId(staffId);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffName() throws Exception {
        Print.print("请输入您要查询的员工姓名：");
        String staffName = sc.next();
        if (!staffDao.staffNameExist(staffName)){
            Print.print("员工不存在");
            selectStaffName();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffName(staffName);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffSex() throws Exception {
        Print.print("请输入您要查询的员工性别：");
        String staffSex = sc.next();
        if (!staffDao.staffSexExist(staffSex)){
            Print.print("员工不存在");
            selectStaffSex();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffSex(staffSex);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffDepartmentId() throws Exception {
        Print.print("请输入您要查询的员工的部门id：");
        int sdepartmentId = sc.nextInt();
        if (!staffDao.staffDepartmentIdExist(sdepartmentId)){
            Print.print("员工不存在");
            selectStaffDepartmentId();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffDepartmentId(sdepartmentId);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffPrositionId() throws Exception {
        Print.print("请输入您要查询的员工的职位id：");
        int spositionId = sc.nextInt();
        if (!staffDao.staffPositionIdExist(spositionId)){
            Print.print("员工不存在");
            selectStaffPrositionId();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffPrositionId(spositionId);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffNation() throws Exception {
        Print.print("请输入您要查询的员工的民族：");
        String staffNation = sc.next();
        if (!staffDao.staffNationNameExist(staffNation)){
            Print.print("员工不存在");
            selectStaffNation();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffNation(staffNation);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffEducation() throws Exception {
        Print.print("请输入您要查询的员工的学历：");
        String staffEducation = sc.next();
        if (!staffDao.staffEducationNameExist(staffEducation)){
            Print.print("员工不存在");
            selectStaffEducation();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffEducation(staffEducation);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffIdentityId() throws Exception {
        Print.print("请输入您要查询的员工的身份证：");
        String staffIdentityId = sc.next();
        if (!staffDao.staffIdentityIdNameExist(staffIdentityId)){
            Print.print("员工不存在");
            selectStaffIdentityId();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffIdentityId(staffIdentityId);
        Print.print("员工信息查询完毕");
    }

    public static void selectStaffPhonenum() throws Exception {
        Print.print("请输入您要查询的员工的电话号码：");
        String staffPhonenum = sc.next();
        if (!staffDao.staffPhoneNumNameExist(staffPhonenum)){
            Print.print("员工不存在");
            selectStaffPhonenum();
        }
        Print.print("正在查询员工信息...");
        Thread.sleep(3000);
        staffDao.selectStaffPhonenum(staffPhonenum);
        Print.print("员工信息查询完毕");
    }

}

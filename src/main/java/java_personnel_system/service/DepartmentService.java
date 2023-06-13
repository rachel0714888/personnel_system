package java_personnel_system.service;

import java_personnel_system.DAO.DepartmentDao;
import java_personnel_system.DAO.DepartmentDaoimpl;
import java_personnel_system.DAO.StaffDao;
import java_personnel_system.DAO.StaffDaoimpl;
import java_personnel_system.pojo.Department;
import java_personnel_system.util.Print;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/12 1:24
 */
public class DepartmentService {
    private static Scanner sc = new Scanner(System.in);
    private static DepartmentDao departmentDao = new DepartmentDaoimpl();
    private static StaffDao staffDao = new StaffDaoimpl();

    public static void addDepartment() throws Exception {
        Print.print("请输入要增加的部门名");
        String departmentName = sc.nextLine();
        if (departmentDao.departmentExist(departmentName)){
            Print.print("部门已存在，请重新输入");
            addDepartment();
        }
        departmentDao.addDepartment(new Department(departmentName));
    }

    public static void removeDepartmentId() throws Exception{
        Print.print("请输入要删除的部门id");
        int departmentId = sc.nextInt();
        if (!departmentDao.departmentExist(departmentId)){
            Print.print("部门不存在，请重新输入");
            removeDepartmentId();
        }
        staffDao.autoUpdateStaffDepartmentId(departmentId);
        departmentDao.removeDepartmentId(departmentId);
        departmentDao.departmentAlter();
    }

    public static void removeDepartmentName() throws Exception{
        Print.print("请输入要删除的部门名");
        String departmentName = sc.next();
        if (!departmentDao.departmentExist(departmentName)){
            Print.print("部门不存在，请重新输入");
            removeDepartmentName();
        }
        Print.print("该部门还要员工，请确认是否删除");
        Print.print("1.是");
        Print.print("2.否");
        int confirm = sc.nextInt();
        if (confirm==1){
            staffDao.autoUpdateStaffDepartmentId(departmentDao.selectLikeDepartmentNameNoPrint(departmentName));
            departmentDao.removeDepartmentName(departmentName);
            departmentDao.departmentAlter();
        }
    }

    public static void changeDepartmentMsg() throws Exception{
        Print.print("请输入要修改的部门id");
        int departmentId = sc.nextInt();
        if (!departmentDao.departmentExist(departmentId)){
            Print.print("部门不存在，请重新输入");
            changeDepartmentMsg();
        }
        Print.print("请输入修改后的部门名");
        String departmentName = sc.next();
        departmentDao.changeDepartmentName(new Department(departmentId,departmentName));
    }

    public static void selectAllDepartmentMsg() throws Exception{
        Print.print("正在查询部门信息...");
        Thread.sleep(3000);
        departmentDao.selectAllDepartment();
        Print.print("部门信息查询成功");
    }

    public static void selectLikeDepartmentName() throws Exception{
        Print.print("请输入要查询的部门名");
        String departmentName = sc.nextLine();
        if (!departmentDao.departmentExist(departmentName)){
            Print.print("部门不存在，请重新输入");
            selectLikeDepartmentName();
        }
        Print.print("正在查询部门信息...");
        Thread.sleep(3000);
        departmentDao.selectLikeDepartmentName(departmentName);
        Print.print("部门信息查询成功");
    }

}

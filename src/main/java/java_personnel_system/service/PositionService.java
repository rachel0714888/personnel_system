package java_personnel_system.service;

import java_personnel_system.DAO.PositionDao;
import java_personnel_system.DAO.PositionDaoimpl;
import java_personnel_system.DAO.StaffDao;
import java_personnel_system.DAO.StaffDaoimpl;
import java_personnel_system.pojo.Department;
import java_personnel_system.pojo.Position;
import java_personnel_system.util.Print;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/12 9:15
 */
public class PositionService {
    private static Scanner sc = new Scanner(System.in);
    private static PositionDao positionDao = new PositionDaoimpl();
    private static StaffDao staffDao = new StaffDaoimpl();

    public static void addPosition() throws Exception {
        Print.print("请输入要增加的职位名");
        String positionName = sc.nextLine();
        if (positionDao.positionExist(positionName)){
            Print.print("职位已存在，请重新输入");
            addPosition();
        }
        positionDao.addPosition(new Position(positionName));
    }

    public static void removePositionId() throws Exception {
        Print.print("请输入要删除的职位id");
        int positionId = sc.nextInt();
        if (!positionDao.positionIdExist(positionId)){
            Print.print("职位不存在，请重新输入");
            removePositionId();
        }
        staffDao.autoUpdateStaffPositionId(positionId);
        positionDao.removePositionId(positionId);
        positionDao.positionAlter();
    }

    public static void removePositionName() throws Exception {
        Print.print("请输入要删除的职位名");
        String positionName = sc.nextLine();
        if (!positionDao.positionExist(positionName)){
            Print.print("职位不存在，请重新输入");
            addPosition();
        }
        staffDao.autoUpdateStaffPositionId(positionDao.selectLikePositionNameNoPrint(positionName));
        positionDao.removePositionName(positionName);
        positionDao.positionAlter();
    }

    public static void changePositionMsg() throws Exception {
        Print.print("请输入要修改的职位id");
        int positionId = sc.nextInt();
        if (!positionDao.positionIdExist(positionId)){
            Print.print("职位不存在，请重新输入");
            changePositionMsg();
        }
        Print.print("请输入修改后的职位名");
        String positionName = sc.next();
        positionDao.changePositionMsg(new Position(positionId, positionName));
    }

    public static void selectAllPositionMsg() throws Exception {
        Print.print("正在查询职位信息...");
        Thread.sleep(3000);
        positionDao.selectAllPositionMsg();
        Print.print("职位信息查询成功");
    }

    public static void selectLikePositionName() throws Exception {
        Print.print("请输入要查询的职位名");
        String positionName = sc.nextLine();
        if (!positionDao.positionExist(positionName)){
            Print.print("职位不存在，请重新输入");
            selectLikePositionName();
        }
        Print.print("正在查询职位信息...");
        Thread.sleep(3000);
        positionDao.selectLikePositionName(positionName);
        Print.print("职位信息查询成功");
    }
}

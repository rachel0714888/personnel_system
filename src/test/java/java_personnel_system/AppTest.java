package java_personnel_system;

import static org.junit.Assert.assertTrue;

import java_personnel_system.pojo.User;
import java_personnel_system.service.*;
import java_personnel_system.util.ConnectionPool;
import java_personnel_system.view.MainView;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() throws Exception {
        UserService.login();
    }

    /**
     * 用户添加
     *
     * @throws Exception
     */
    @Test
    public void userAdd() throws Exception {
        UserService.userAdd();
    }

    /**
     * 根据用户id删除用户
     *
     * @throws Exception
     */
    @Test
    public void userIdRemove() throws Exception {
        UserService.userIdRemove();
    }

    /** 根据用户名删除用户
     * @throws Exception
     */
    @Test
    public void userNameRemove() throws Exception {
        UserService.userNameRemove();
    }

    /** 根据用户的员工id删除用户
     * @throws Exception
     */
    @Test
    public void userStaffIdRemove() throws Exception {
        UserService.userStaffIdRemove();
    }

    /** 根据用户状态删除用户
     * @throws Exception
     */
    @Test
    public void userIsWorkRemove() throws Exception {
        UserService.userIsWorkRemove();
    }

     /** 更改用户数据（权限0、1）
      * @throws Exception
      */
     @Test
     public void userChange() throws Exception {
         UserService.userChange();
     }

     /** 更改用户数据（权限2）
      * @throws Exception
      */
     @Test
     public void ordinaryUserMsgUpdate() throws Exception {
         UserService.ordinaryUserMsgUpdate();
     }

     /** 查看所有用户数据（权限0、1）
      * @throws Exception
      */
     @Test
     public void userAllSelect() throws Exception {
         UserService.userAllSelect();
     }

     /** 根据用户名模糊查询用户数据（权限0、1）
      * @throws Exception
      */
     @Test
     public void userLikeNameSelect() throws Exception {
         UserService.userLikeNameSelect();
     }

     /** 根据用户工作状态查询用户数据（权限0、1）
      * @throws Exception
      */
     @Test
     public void userLikeIsOnworkSelect() throws Exception {
         UserService.userLikeIsOnworkSelect();
     }

     /** 添加员工（权限0、1）
      * @throws Exception
      */
     @Test
     public void addStaff() throws Exception {
         StaffService.addStaff();
     }

     /** 根据员工id删除员工（权限0、1）
      * @throws Exception                             
      */                                              
     @Test                                            
     public void removeStaffId() throws Exception {   
         StaffService.removeStaffId();                 
     }

     /** 根据员工姓名删除员工（权限0、1）
      * @throws Exception
      */
     @Test
     public void removeStaffName() throws Exception {
         StaffService.removeStaffName();
     }

     /** 输入员工id，更改该员工的员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void updateStaffMsg() throws Exception {
         StaffService.updateStaffMsg();
     }

     /** 更改当前用户的员工信息（权限2）
      * @throws Exception
      */
     @Test
     public void ordinaryUserUpdateStaffMsg() throws Exception {
         StaffService.ordinaryUserUpdateStaffMsg();
     }

     /** 查询所有员工员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectAllStaffMsg() throws Exception {
         StaffService.selectAllStaffMsg();
     }

     /** 根据员工id查询员工信息（权限0、1）                             
      * @throws Exception                            
      */                                             
     @Test                                           
     public void selectStaffId() throws Exception {  
         StaffService.selectStaffId();               
     }

     /** 查询当前用户的员工信息（权限2）
      * @throws Exception
      */
     @Test
     public void selectStaffIdNoInput() throws Exception {
         StaffService.selectStaffIdNoInput(MainView.currentUser.getUserStaffId());
     }

     /** 根据员工姓名查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffName() throws Exception {
         StaffService.selectStaffName();
     }

     /** 根据员工性别查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffSex() throws Exception {
         StaffService.selectStaffSex();
     }

     /** 根据员工部门id查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffDepartmentId() throws Exception {
         StaffService.selectStaffDepartmentId();
     }

     /** 根据员工职位id查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffPrositionId() throws Exception {
         StaffService.selectStaffPrositionId();
     }

     /** 根据员工民族查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffNation() throws Exception {
         StaffService.selectStaffNation();
     }

     /** 根据员工教育背景查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffEducation() throws Exception {
         StaffService.selectStaffEducation();
     }

     /** 根据员工身份证查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffIdentityId() throws Exception {
         StaffService.selectStaffIdentityId();
     }

     /** 根据员工手机号查询员工信息（权限0、1）
      * @throws Exception
      */
     @Test
     public void selectStaffPhonenum() throws Exception {
         StaffService.selectStaffPhonenum();
     }

     /** 增加职位（权限0）
      * @throws Exception
      */
     @Test
     public void addPosition() throws Exception {
         PositionService.addPosition();
     }

     /** 根据职位id删除职位（权限0）
      * @throws Exception
      */
     @Test
     public void removePositionId() throws Exception {
         PositionService.removePositionId();
     }

    /** 根据职位名删除职位（权限0）
     * @throws Exception
     */
    @Test
    public void removePositionName() throws Exception {
        PositionService.removePositionName();
    }

    /** 根据职位id修改对应的职位名（权限0）
     * @throws Exception
     */
    @Test
    public void changePositionMsg() throws Exception {
        PositionService.changePositionMsg();
    }

    /** 查询所有职位信息（权限0）
     * @throws Exception
     */
    @Test
    public void selectAllPositionMsg() throws Exception {
        PositionService.selectAllPositionMsg();
    }

    /** 根据职位名查询职位信息（权限0）
     * @throws Exception
     */
    @Test
    public void selectLikePositionName() throws Exception {
        PositionService.selectLikePositionName();
    }

    /** 发布公告（权限0）
     * @throws Exception
     */
    @Test
    public void addNotice() throws Exception {
        NoticeService.addNotice();
    }

    /** 删除公告（权限0）
     * @throws Exception
     */
    @Test
    public void removeNotice() throws Exception {
        NoticeService.removeNotice();
    }

    /** 根据公告id更改对应公告（权限0）
     * @throws Exception
     */
    @Test
    public void updateNotice() throws Exception {
        NoticeService.updateNotice();
    }

    /** 查看所有公告（权限0、1、2）
     * @throws Exception
     */
    @Test
    public void selectAllNotice() throws Exception {
        NoticeService.selectAllNotice();
    }

    /** 根据公告名查看对应公告（权限0、1、2）
     * @throws Exception
     */
    @Test
    public void selectNoticeName() throws Exception {
        NoticeService.selectNoticeName();
    }

    /** 根据公告内容查看对应公告（权限0、1、2）
     * @throws Exception
     */
    @Test
    public void selectNoticeContent() throws Exception {
        NoticeService.selectNoticeContent();
    }

    /** 增加部门（权限0）
     * @throws Exception
     */
    @Test
    public void addDepartment() throws Exception {
        DepartmentService.addDepartment();
    }

    /** 根据部门id删除部门（权限0）
     * @throws Exception
     */
    @Test
    public void removeDepartmentId() throws Exception {
        DepartmentService.removeDepartmentId();
    }

    /** 根据部门名删除部门（权限0）
     * @throws Exception
     */
    @Test
    public void removeDepartmentName() throws Exception {
        DepartmentService.removeDepartmentName();
    }

    /** 根据部门id修改对应部门信息（权限0）
     * @throws Exception
     */
    @Test
    public void changeDepartmentMsg() throws Exception {
        DepartmentService.changeDepartmentMsg();
    }

    /** 查看所有部门信息（权限0）
     * @throws Exception
     */
    @Test
    public void selectAllDepartmentMsg() throws Exception {
        DepartmentService.selectAllDepartmentMsg();
    }

    /** 根据部门名查看部门信息（权限0）
     * @throws Exception
     */
    @Test
    public void selectLikeDepartmentName() throws Exception {
        DepartmentService.selectLikeDepartmentName();
    }








}
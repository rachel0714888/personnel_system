package java_personnel_system.util;

import java_personnel_system.pojo.*;

/**所有的格式化打印语句
 * @auther Rachel
 * @date 2023/6/11 11:21
 */
public class Print {
    public static void print(String message) {
        char[] c = message.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void userAllMessagePrint(User user) {
        String isOnwork = "";
        String isAuthority = "";
        if (user.getIsOnwork()) {
            isOnwork = "在职";
        } else {
            isOnwork = "离职";
        }
        if (user.getUserAuthority() == 0) {
            isAuthority = "总经理";
        } else if (user.getUserAuthority() == 1) {
            isAuthority = "人事部长";
        } else {
            isAuthority = "普通员工";
        }
        print("用户id：" + user.getUserId() + " 用户名：" + user.getUserName() + " 密码：" + user.getUserPassword() +
                " 员工id：" + user.getUserStaffId() + " 用户状态：" + isOnwork + " 用户权限：" + isAuthority);
    }

    public static void ordinaryUserMsgPrint(User user){
        print("用户id：" + user.getUserId() + " 用户名：" + user.getUserName() + " 密码：" + user.getUserPassword() +
                " 员工id：" + user.getUserStaffId());
    }

    public static void departmentAllMsgPrint(Department department) {
        print("部门id：" + department.getDepartmentId() + " 部门名：" + department.getDepartmentName());
    }

    public static void positionAllMsgPrint(Position position) {
        print("职位id：" + position.getPositionId() + " 职位名：" + position.getPositionName());
    }

    public static void staffAllMsgPrint(Staff staff) {
        print("员工id：" + staff.getStaffId() + " 员工姓名：" + staff.getStaffName() + " 员工性别：" + staff.getStaffSex()
                            +" 员工部门id："+staff.getSdepartmentId()+" 员工职位id："+staff.getSpositionId()+" 民族:"+staff.getStaffNation()
                            +" 教育背景："+staff.getStaffEducation()+" 身份证号："+staff.getStaffIdentityId()+" 手机号:"+staff.getStaffPhonenum());
    }

    public static void noticeAllMsgPrint(Notice notice) {
        print("公告id：" + notice.getNoticeId() + " 公告内容：" + notice.getNoticeContent()+" 公告发布者："+notice.getNoticePublisherId()
                +" 公告名:"+notice.getNoticeName());
    }
}

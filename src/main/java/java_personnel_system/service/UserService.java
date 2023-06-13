package java_personnel_system.service;

import java_personnel_system.DAO.UserDao;
import java_personnel_system.DAO.UserDaoimpl;
import java_personnel_system.pojo.User;
import java_personnel_system.util.Print;
import java_personnel_system.util.RandomStr;
import java_personnel_system.view.MainView;
import java_personnel_system.view.ManagerView;
import java_personnel_system.view.OrdinaryUserView;
import java_personnel_system.view.PersonnelView;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/11 19:27
 */
public class UserService {
    private static Scanner sc = new Scanner(System.in);
    private static UserDao userDao = new UserDaoimpl();

    public static void login() throws Exception {
        Print.print("欢迎来到员工管理系统");
        Print.print("请输入你登录的用户名:");
        String inputUserName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = sc.nextLine();
        User inputUser = new User();
        inputUser.setUserName(inputUserName);
        inputUser.setUserPassword(inputPassword);
        String confirmCode = RandomStr.getRandomString();
        Print.print("验证码为:" + confirmCode + ",请输入验证码进行验证,验证码不区分大小写");
        String inputConfirmCode = sc.nextLine();
        if (confirmCode.equalsIgnoreCase(inputConfirmCode)) {
            Print.print("验证码通过,正在验证用户名和密码,请稍后...");
            Thread.sleep(3000);
            int isLogin = userDao.match(inputUser);
            if (isLogin==1) {
                Print.print("登陆成功");
                //登陆成功，判断权限，根据不同的权限进入不同的操作页面
                int authority = MainView.currentUser.getUserAuthority();
                if (authority == 0) {
                    ManagerView.managerView();
                } else if (authority == 1) {
                    PersonnelView.personnelView();
                } else if (authority == 2) {
                    OrdinaryUserView.ordinaryUserView();
                }

            } else if (isLogin==2){
                Print.print("用户已离职");
                login();
            }else if (isLogin==3){
                Print.print("密码错误");
                login();
            }else if (isLogin==4){
                Print.print("用户不存在");
                login();
            }
        } else {
            Print.print("验证码输入错误，请重新登录");
            login();
        }

    }

    public synchronized static void userAdd() throws Exception {
        Print.print("请输入您想要添加的用户名：");
        String inputUserName = sc.next();
        sc.nextLine();
        //判断用户名是否存在，存在则重新输入
        boolean isExistUserName = userDao.userNameExist(inputUserName);
        if (isExistUserName) {
            Print.print("用户名已存在，请重新输入");
            userAdd();
        }
        Print.print("请输入您想要添加的密码：");
        String inputPassword = sc.nextLine();
        Print.print("请输入您想要添加的用户的员工id：");
        int inputUserStaffId = sc.nextInt();
        boolean isExistStaffId = userDao.userStaffIdExist(inputUserStaffId);
        if (isExistStaffId) {
            Print.print("员工已有账号，请重新输入");
            userAdd();
        }
        Print.print("请输入您想要添加的用户是否是在职状态：");
        Print.print("1.是");
        Print.print("2.否");
        //由于数据库中用的是tinyint存储boolean，在这里进行一个转换，默认iswork为false
        int inputIswork = sc.nextInt();
        boolean iswork = false;
        if (inputIswork == 1) {
            iswork = true;
        } else if (inputIswork == 2) {
        } else {
            Print.print("输入错误，请重新输入");
            userAdd();
        }
        Print.print("请输入您想要添加的用户的权限：");
        Print.print("1.人事部长权限");
        Print.print("2.普通员工权限");
        Print.print("3.离职员工权限");
        int inputUserAuthority = sc.nextInt();
        int userAuthority = 2;
        if (inputUserAuthority == 1) {
            userAuthority = 1;
        } else if (inputUserAuthority == 2) {
        } else if (inputUserAuthority == 3) {
            userAuthority = 5;
        } else {
            Print.print("输入错误，请重新输入");
            userAdd();
        }
        //调用Dao的方法做数据库数据插入
        userDao.insert(new User(inputUserName, inputPassword, inputUserStaffId, iswork, userAuthority));
    }

    public synchronized static void userIdRemove() throws Exception {
        Print.print("请输入您想要删除的用户id：");
        int inputUserId = sc.nextInt();
        if (userDao.userIdExist(inputUserId)){
            userDao.idRemove(inputUserId);
            userDao.userTableAlter();
        }
        else {
            Print.print("用户不存在");
        }
    }

    public synchronized static void userNameRemove() throws Exception {
        Print.print("请输入您想要删除的用户名：");
        String inputUserName = sc.nextLine();
        if (userDao.userNameExist(inputUserName)){
            userDao.nameRemove(inputUserName);
            userDao.userTableAlter();
        }
        else {
            Print.print("用户不存在");
        }
    }

    public synchronized static void userStaffIdRemove() throws Exception {
        Print.print("请输入您想要删除的用户员工id：");
        int inputUserStaffId = sc.nextInt();
        if (userDao.userStaffIdExist(inputUserStaffId)){
            userDao.staffIdRemove(inputUserStaffId);
            userDao.userTableAlter();
        }
        else {
            Print.print("用户不存在");
        }
    }

    public synchronized static void userIsWorkRemove() throws Exception {
        Print.print("请输入您想要删除什么状态的员工：");
        Print.print("1.在职");
        Print.print("2.离职");
        int choose = sc.nextInt();
        int isWork = 0;
        if (choose == 1) {
            isWork = 1;
        } else if (choose == 2) {
            isWork = 0;
        } else {
            Print.print("输入错误，请重新输入");
            userIsWorkRemove();
        }
        userDao.isWorkRemove(isWork);
        userDao.userTableAlter();
    }

    public synchronized static void userChange() throws Exception {
        Print.print("请输入要修改的用户id：");
        int userId = sc.nextInt();
        if (!userDao.userIdExist(userId)){
            Print.print("用户不存在");
            userChange();
        }
        Print.print("请输入修改后的用户名：");
        String userName = sc.next();
        Print.print("请输入修改后的用户密码：");
        String password = sc.next();
        Print.print("请输入修改后的员工id：");
        int staffId = sc.nextInt();
        Print.print("请输入修改后的员工状态");
        Print.print("0.离职");
        Print.print("1.在职");
        int isWork = sc.nextInt();
        boolean isOnwork = false;
        if (isWork == 0) {
            isOnwork = false;
        } else if (isWork == 1) {
            isOnwork = true;
        }
        Print.print("请输入修改后的员工权限");
        Print.print("1.人事部长");
        Print.print("2.普通职员");
        Print.print("3.离职");
        int authority = sc.nextInt();
        if (authority == 3) {
            authority = 5;
        }
        userDao.userChange(new User(userId, userName, password, staffId, isOnwork, authority));
    }

    public static void ordinaryUserMsgUpdate()throws Exception{
        Print.print("请输入修改后的用户名：");
        String userName = sc.next();
        Print.print("请输入修改后的用户密码：");
        String password = sc.next();
        userDao.ordinaryUserMsgUpdate(userName,password);
    }

    public static void userAllSelect() throws Exception {
        Print.print("正在为您查询用户信息...");
        Thread.sleep(3000);
        userDao.userAllSelect();
        Print.print("用户信息查询成功");
    }

    public static void userLikeNameSelect() throws Exception {
        Print.print("请输入要查询的用户名：");
        String userName = sc.next();
        if (!userDao.userNameExist(userName)){
            Print.print("用户不存在");
            userLikeNameSelect();
        }
        Print.print("正在为您查询用户信息...");
        Thread.sleep(3000);
        userDao.userLikeNameSelect(userName);
        Print.print("用户信息查询成功");
    }

    public static void userLikeIsOnworkSelect() throws Exception {
        Print.print("请输入要查询的用户状态：");
        Print.print("0.离职");
        Print.print("1.在职");
        int iswork = sc.nextInt();
        Print.print("正在为您查询用户信息...");
        Thread.sleep(3000);
        userDao.userLikeIsworkSelect(iswork);
        Print.print("用户信息查询成功");
    }

    public static int getUserStaffId(String userName)throws Exception{
        return userDao.selectUserStaffId(userName);
    }


}

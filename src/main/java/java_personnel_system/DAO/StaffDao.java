package java_personnel_system.DAO;

import java_personnel_system.pojo.Staff;

/**
 * @auther Rachel
 * @date 2023/6/12 10:15
 */
public interface StaffDao {
    /**
     * 通过员工身份证和手机号 判断增加的员工是否存在
     *
     * @param staffIdentityId 存入增加员工的身份证
     * @param staffPhonenum   存入增加员工的手机号
     * @return 存在返回true
     * @throws Exception 向上抛出异常
     */
    boolean staffExist(String staffIdentityId, String staffPhonenum) throws Exception;

    /**
     * 增加员工
     *
     * @param staff 存放要增加的员工数据
     * @throws Exception 向上抛出异常
     */
    void staffAdd(Staff staff) throws Exception;

    /**
     * 根据提供的员工id删除对应的员工数据
     *
     * @param staffId 存入要删除的员工的员工id
     * @throws Exception 向上抛出异常
     */
    void removeStaffId(int staffId) throws Exception;

    /**
     * 根据提供的员工姓名删除对应的员工数据
     *
     * @param staffName 存入要删除的员工的员工姓名
     * @throws Exception 向上抛出异常
     */
    void removeStaffName(String staffName) throws Exception;

    /**
     * 防止手动删除数据导致主键增长不连续
     *
     * @throws Exception 向上抛出异常
     */
    void tableAlter() throws Exception;

    /**
     * 在删除职位的时候调用 根据该职位的所有员工的员工id 自动将这些员工的职位id改为12（未定义）
     *
     * @param staffId 存放要修改的员工id
     * @throws Exception 向上抛出异常
     */
    void autoUpdateStaffPositionId(int staffId) throws Exception;

    /**
     * 在删除部门的时候调用 根据该部门的所有员工的员工id 自动将这些员工的部门id改为6（未定义）
     *
     * @param staffId 存放要修改的员工id
     * @throws Exception 向上抛出异常
     */
    void autoUpdateStaffDepartmentId(int staffId) throws Exception;

    /**
     * 根据输入的员工id 更新员工信息
     *
     * @param staff 存放要更改的员工的id和准备更新的员工信息
     * @throws Exception 向上抛出异常
     */
    void updateStaffMsg(Staff staff) throws Exception;


    /**普通员工权限只能修改自己的名字、身份证、电话号
     * @param staffName 要修改的名字
     * @param staffIdentityId 要修改的身份证
     * @param staffPhonenum 要修改的电话号
     * @throws Exception
     */
    void ordinaryUserUpdateStaffMsg(String staffName,String staffIdentityId,String staffPhonenum) throws Exception;

    /**
     * 查询所有员工的信息
     *
     * @throws Exception 向上抛出异常
     */
    void selectAllStaffMsg() throws Exception;

    /**
     * 根据员工id查询员工信息
     *
     * @param staffId 存放要查询的员工的员工id
     * @throws Exception
     */
    void selectStaffId(int staffId) throws Exception;

    /**
     * 根据员工姓名查询员工信息
     *
     * @param staffName 存放要查询的员工的员工姓名
     * @throws Exception
     */
    void selectStaffName(String staffName) throws Exception;

    /**根据员工性别查询员工信息
     * @param staffSex 存放要查询的员工的员工性别
     * @throws Exception
     */
    void selectStaffSex(String staffSex) throws Exception;

    /**根据员工部门id查询员工信息
     * @param sdepartmentId 存放要查询的员工的员工部门id
     * @throws Exception
     */
    void selectStaffDepartmentId(int sdepartmentId) throws Exception;

    /**根据员工职位id查询员工信息
     * @param spositionId 存放要查询的员工的员工职位id
     * @throws Exception
     */
    void selectStaffPrositionId(int spositionId) throws Exception;

    /**根据员工民族查询员工信息
     * @param staffNation 存放要查询的员工的员工民族
     * @throws Exception
     */
    void selectStaffNation(String staffNation) throws Exception;

    /**根据员工教育背景查询员工信息
     * @param staffEducation 存放要查询的员工的员工教育背景
     * @throws Exception
     */
    void selectStaffEducation(String staffEducation) throws Exception;

    /**根据员工身份证查询员工信息
     * @param staffIdentityId 存放要查询的员工的身份证
     * @throws Exception
     */
    void selectStaffIdentityId(String staffIdentityId) throws Exception;

    /**根据员工手机号查询员工信息
     * @param staffPhonenum 存放要查询的员工的手机号
     * @throws Exception
     */
    void selectStaffPhonenum(String staffPhonenum) throws Exception;

}

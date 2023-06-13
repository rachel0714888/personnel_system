package java_personnel_system.DAO;

import java_personnel_system.pojo.Department;

/**
 * @auther Rachel
 * @date 2023/6/12 1:26
 */
public interface DepartmentDao {

    /**判断这个部门id的部门还有人吗
     * @param departmentId 部门id
     * @return 有返回true
     * @throws Exception
     */
    boolean isdepartmentIdHaveStaff(int departmentId) throws Exception;

    /**判断这个部门名的部门还有人吗
     * @param departmentName 部门名
     * @return 有返回true
     * @throws Exception
     */
    boolean isdepartmentNameHaveStaff(String departmentName) throws Exception;

    /**
     * 增加一个新的部门
     *
     * @param department 存放新部门的信息
     * @throws Exception 抛出异常 如果有异常，抛出
     */
    void addDepartment(Department department) throws Exception;

    /**判断部门名是否存在
     * @param departmentName 要判断的部门名
     * @return 存在返回true
     * @throws Exception 抛出异常
     */
    boolean departmentExist(String departmentName) throws Exception;

    /**判断部门id是否存在
     * @param departmentId 要判断的部门id
     * @return 存在返回true
     * @throws Exception 抛出异常
     */
    boolean departmentExist(int departmentId) throws Exception;

    /**根据部门id删除部门
     * @param departmentId 存放要删除的部门的部门id
     * @throws Exception 抛出异常 如果有异常，抛出
     */
    void removeDepartmentId(int departmentId) throws Exception;

    /**防止手动删除数据时主键不连续
     * @throws Exception 抛出异常 如果有异常，抛出
     */
    void departmentAlter() throws Exception;

    /**根据部门名字删除部门
     * @param departmentName 存放要删除的部门的名字
     * @throws Exception 抛出异常 如果有异常，抛出
     */
    void removeDepartmentName(String departmentName) throws Exception;

    /**修改部门信息
     * @param department 存放要修改的部门和要修改的部门信息
     * @throws Exception 抛出异常 如果有异常，抛出
     */
    void changeDepartmentName(Department department) throws Exception;

    /** 查询所有部门信息
     * @throws Exception 抛出异常  如果有异常，抛出
     */
    void selectAllDepartment() throws Exception;

    /** 查询指定部门信息，根据输入的字符对部门名字进行模糊匹配
     * @param departmentName 存放输入的部门名或部分部门名
     * @throws Exception 抛出异常 如果有异常，抛出
     */
    void selectLikeDepartmentName(String departmentName) throws Exception;

    /**查询指定部门信息，根据输入的字符对部门名字进行模糊匹配
     * @param departmentName 存放输入的部门名或部分部门名
     * @return 返回指定部门的部门id
     * @throws Exception 抛出异常
     */
    int selectLikeDepartmentNameNoPrint(String departmentName) throws Exception;
}

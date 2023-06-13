package java_personnel_system.DAO;

import java_personnel_system.pojo.Position;
import java_personnel_system.util.Print;

/**
 * @auther Rachel
 * @date 2023/6/12 9:15
 */
public interface PositionDao {
    /**
     * 添加职位
     *
     * @param position 需要要添加的职位信息
     * @throws Exception 抛出异常 如果有异常，向上抛出异常
     */
    void addPosition(Position position) throws Exception;

    /**
     * 根据输入的职位id删除职位
     *
     * @param positionId 存入要删除的职位的职位id
     * @throws Exception 抛出异常 如果有异常，向上抛出异常
     */
    void removePositionId(int positionId) throws Exception;

    /**
     * 防止手动删除数据后出现主键增长不连续的问题
     *
     * @throws Exception 抛出异常 如果有异常，向上抛出异常
     */
    void positionAlter() throws Exception;

    /**
     * 根据职位名删除职位
     *
     * @param positionName 存入要删除的职位的职位名
     * @throws Exception 抛出异常 如果有异常，向上抛出异常
     */
    void removePositionName(String positionName) throws Exception;

    /**
     * 更改职位信息 根据要更改的职位的职位id确认要更改的职位数据
     *
     * @param position 存入要更改的职位的职位id和更改后的职位数据
     * @throws Exception 抛出异常 如果有异常，向上抛出异常
     */
    void changePositionMsg(Position position) throws Exception;

    /**
     * 查询所有的职位信息
     *
     * @throws Exception 抛出异常 如果有异常，向上抛出异常
     */
    void selectAllPositionMsg() throws Exception;

    /**
     * 根据输入的职位名或部分职位名查询职位信息
     *
     * @param positionName 存入要查询的职位名或部分职位名
     * @throws Exception 抛出异常
     */
    void selectLikePositionName(String positionName) throws Exception;

    /**
     * 根据输入的职位名或部分职位名查询职位信息 但不将其打印 而是返回这个职位的id
     *
     * @param positionName 存入要查询的职位名或部分职位名
     * @return 返回查找到的职位的id
     * @throws Exception 抛出异常
     */
    int selectLikePositionNameNoPrint(String positionName) throws Exception;

    /**
     * 根据职位名判断职位是否存在
     *
     * @param positionName 要判断的职位名
     * @return 存在返回true
     * @throws Exception 抛出异常
     */
    boolean positionExist(String positionName) throws Exception;

    /**根据职位id判断职位是否存在
     * @param positionId 要判断的职位id
     * @return 存在返回true
     * @throws Exception 抛出异常
     */
    boolean positionIdExist(int positionId) throws Exception;
}

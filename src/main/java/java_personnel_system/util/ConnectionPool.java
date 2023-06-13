package java_personnel_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**数据库连接池 personnel_management_system
 * @auther Rachel
 * @date 2023/6/11 19:58
 */
public class ConnectionPool {

    List<Connection> cs = new ArrayList<>();

    int size;

    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/personnel_management_system?characterEncoding=utf8",
                        "root","123456");
                cs.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ConnectionPool(int size){
        this.size=size;
        init();
    }

    public synchronized Connection getConnection(){
        while (cs.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }

    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }

}

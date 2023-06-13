package java_personnel_system.DAO;

import java_personnel_system.pojo.Notice;
import java_personnel_system.util.Print;
import java_personnel_system.view.MainView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Rachel
 * @date 2023/6/12 10:13
 */
public class NoticeDaoimpl implements NoticeDao {
    Object o = new Object();
    Lock lock = new ReentrantLock();

    @Override
    public void addNotice(Notice notice) throws Exception {
        synchronized (o) {
            Connection c = MainView.cp.getConnection();
            String sql = "insert into notice_table(notice_content,notice_publisher_id,notice_name) values(?,1,?)";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, notice.getNoticeContent());
            ps.setString(2, notice.getNoticeName());
            ps.execute();
            MainView.cp.returnConnection(c);
        }
    }

    @Override
    public void removeNotice(int noticeId) throws Exception {
        synchronized (o) {
            Connection c = MainView.cp.getConnection();
            String sql = "delete from notice_table where notice_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, noticeId);
            ps.execute();
            MainView.cp.returnConnection(c);
        }
    }

    @Override
    public void updateNotice(Notice notice) throws Exception {
        synchronized (o) {
            Connection c = MainView.cp.getConnection();
            String sql = "update notice_table set notice_content = ?,notice_name = ? where notice_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, notice.getNoticeContent());
            ps.setString(2, notice.getNoticeName());
            ps.setInt(3, notice.getNoticeId());
            ps.execute();
            MainView.cp.returnConnection(c);
        }
    }

    @Override
    public void noticeAlter() throws Exception {
        Connection c = MainView.cp.getConnection();
        String sql = "ALTER TABLE notice_table AUTO_INCREMENT = 1;";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.execute();
        MainView.cp.returnConnection(c);
    }

    @Override
    public void selectAllNotice() throws Exception {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                Connection c = MainView.cp.getConnection();
                String sql = "select * from notice";
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Print.noticeAllMsgPrint(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4));
                }
                MainView.cp.returnConnection(c);
            } else {
                Print.print("网络繁忙，请稍后再进行操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    @Override
    public boolean noticeIdExist(int noticeId) throws Exception {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                Connection c = MainView.cp.getConnection();
                String sql = "select * from notice_table where notice_id = ?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, noticeId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
                MainView.cp.returnConnection(c);
            } else {
                Print.print("网络繁忙，请稍后再进行操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return false;
    }

    @Override
    public boolean noticeNameExist(String noticeName) throws Exception {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                Connection c = MainView.cp.getConnection();
                String sql = "select * from notice_table where notice_name like concat('%',?,'%') ";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, noticeName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
                MainView.cp.returnConnection(c);
            } else {
                Print.print("网络繁忙，请稍后再进行操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return false;
    }

    @Override
    public boolean noticeContentExist(String noticeContent) throws Exception {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                Connection c = MainView.cp.getConnection();
                String sql = "select * from notice_table where notice_content like concat('%',?,'%') ";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, noticeContent);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
                MainView.cp.returnConnection(c);
            } else {
                Print.print("网络繁忙，请稍后再进行操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        return false;
    }

    @Override
    public void selectNoticeName(String noticeName) throws Exception {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                Connection c = MainView.cp.getConnection();
                String sql = "select * from notice where notice_name like concat('%',?,'%')";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, noticeName);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Print.noticeAllMsgPrint(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4));
                }
                MainView.cp.returnConnection(c);
            } else {
                Print.print("网络繁忙，请稍后再进行操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    @Override
    public void selectNoticeContent(String noticeContent) throws Exception {
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                Connection c = MainView.cp.getConnection();
                String sql = "select * from notice where notice_content like concat('%',?,'%')";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, noticeContent);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Print.noticeAllMsgPrint(rs.getInt(1), rs.getString(2),
                            rs.getString(3), rs.getString(4));
                }
                MainView.cp.returnConnection(c);
            } else {
                Print.print("网络繁忙，请稍后再进行操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }
}

package java_personnel_system.service;

import java_personnel_system.DAO.NoticeDao;
import java_personnel_system.DAO.NoticeDaoimpl;
import java_personnel_system.pojo.Notice;
import java_personnel_system.pojo.Position;
import java_personnel_system.util.Print;

import java.util.Scanner;

/**
 * @auther Rachel
 * @date 2023/6/12 13:19
 */
public class NoticeService {
    private static Scanner sc = new Scanner(System.in);
    private static NoticeDao noticeDao = new NoticeDaoimpl();

    public static void addNotice() throws Exception {
        Print.print("请输入要增加的公告内容");
        String noticeContent = sc.next();
        Print.print("请输入要增加的公告名");
        String noticeName = sc.next();
        noticeDao.addNotice(new Notice(noticeContent, noticeName));
    }

    public static void removeNotice() throws Exception {
        Print.print("请输入要删除的公告的id");
        int noticeId = sc.nextInt();
        if (!noticeDao.noticeIdExist(noticeId)){
            Print.print("公告不存在，请重新输入");
            removeNotice();
        }
        noticeDao.removeNotice(noticeId);
        noticeDao.noticeAlter();
    }

    public static void updateNotice() throws Exception {
        Print.print("请输入要更改的公告的id");
        int noticeId = sc.nextInt();
        if (!noticeDao.noticeIdExist(noticeId)){
            Print.print("公告不存在，请重新输入");
            removeNotice();
        }
        Print.print("请输入更改后的公告内容");
        String noticeContent = sc.next();
        Print.print("请输入更改后的公告名");
        String noticeName = sc.next();
        noticeDao.updateNotice(new Notice(noticeId, noticeContent, noticeName));
    }

    public static void selectAllNotice() throws Exception {
        Print.print("正在查询公告...");
        Thread.sleep(3000);
        noticeDao.selectAllNotice();
        Print.print("公告查询完毕");
    }

    public static void selectNoticeName() throws Exception {
        Print.print("请输入要查询的公告名");
        String noticeName = sc.next();
        if (!noticeDao.noticeNameExist(noticeName)){
            Print.print("公告不存在，请重新输入");
            selectNoticeName();
        }
        Print.print("正在查询公告...");
        Thread.sleep(3000);
        noticeDao.selectNoticeName(noticeName);
        Print.print("公告查询完毕");
    }

    public static void selectNoticeContent() throws Exception {
        Print.print("请输入要查询的公告内容");
        String noticeContent = sc.next();
        if (!noticeDao.noticeContentExist(noticeContent)){
            Print.print("公告不存在，请重新输入");
            selectNoticeContent();
        }
        Print.print("正在查询公告...");
        Thread.sleep(3000);
        noticeDao.selectNoticeContent(noticeContent);
        Print.print("公告查询完毕");
    }
}

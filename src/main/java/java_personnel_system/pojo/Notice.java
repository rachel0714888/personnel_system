package java_personnel_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther Rachel
 * @date 2023/6/11 11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Integer noticeId;
    private String noticeContent;
    private Integer noticePublisherId;
    private String noticeName;

    public Notice(String noticeContent, String noticeName) {
        this.noticeContent = noticeContent;
        this.noticeName = noticeName;
    }

    public Notice(Integer noticeId, String noticeContent, String noticeName) {
        this.noticeId = noticeId;
        this.noticeContent = noticeContent;
        this.noticeName = noticeName;
    }
}

package java_personnel_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther Rachel
 * @date 2023/6/11 11:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private Integer staffId;
    private String staffName;
    private String staffSex;
    private Integer sdepartmentId;
    private Integer spositionId;
    private String staffNation;
    private String staffEducation;
    private String staffIdentityId;
    private String staffPhonenum;

    public Staff(String staffName, String staffSex, Integer sdepartmentId, Integer spositionId, String staffNation, String staffEducation, String staffIdentityId, String staffPhonenum) {
        this.staffName = staffName;
        this.staffSex = staffSex;
        this.sdepartmentId = sdepartmentId;
        this.spositionId = spositionId;
        this.staffNation = staffNation;
        this.staffEducation = staffEducation;
        this.staffIdentityId = staffIdentityId;
        this.staffPhonenum = staffPhonenum;
    }
}

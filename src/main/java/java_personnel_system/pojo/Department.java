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
public class Department {
    private Integer departmentId;
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Integer departmentId) {
        this.departmentId = departmentId;
    }
}

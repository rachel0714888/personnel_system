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
public class Position {
    private Integer positionId;
    private String positionName;

    public Position(String positionName) {
        this.positionName = positionName;
    }


}

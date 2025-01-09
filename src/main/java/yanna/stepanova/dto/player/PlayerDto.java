package yanna.stepanova.dto.player;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto implements Serializable {
    private Long id;
    private String name;
    private int experienceInMonths;
    private int age;
    private Long teamId;
}

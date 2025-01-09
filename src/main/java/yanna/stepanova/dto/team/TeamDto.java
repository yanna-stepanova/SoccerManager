package yanna.stepanova.dto.team;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto implements Serializable {
    private Long id;
    private String name;
    private BigDecimal balance;
    private float commission;
}

package yanna.stepanova.dto.transfer;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yanna.stepanova.dto.player.PlayerDto;
import yanna.stepanova.dto.team.TeamDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto implements Serializable {
    private PlayerDto player;
    private BigDecimal sumOfTransfer;
    private TeamDto oldTeam;
    private TeamDto newTeam;
}

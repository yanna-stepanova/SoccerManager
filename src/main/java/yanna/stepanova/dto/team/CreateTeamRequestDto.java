package yanna.stepanova.dto.team;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record CreateTeamRequestDto(
        @NotBlank String name,
        @NotNull BigDecimal balance,
        @NotNull @PositiveOrZero @Max(10) float commission) {
}

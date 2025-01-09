package yanna.stepanova.dto.player;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record CreatePlayerRequestDto(
        @NotBlank String name,
        @NotNull @PositiveOrZero int experienceInMonths,
        @NotNull @Positive int age,
        @NotNull @Positive Long teamId) {}

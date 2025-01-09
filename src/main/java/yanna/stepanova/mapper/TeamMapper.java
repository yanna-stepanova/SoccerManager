package yanna.stepanova.mapper;

import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import yanna.stepanova.config.MapperConfig;
import yanna.stepanova.dto.team.CreateTeamRequestDto;
import yanna.stepanova.dto.team.TeamDto;
import yanna.stepanova.model.Team;

@Mapper(config = MapperConfig.class)
public interface TeamMapper {
    Team toModel(CreateTeamRequestDto requestDto);

    TeamDto toDto(Team team);

    Team updateTeamFromDto(@MappingTarget Team team, CreateTeamRequestDto requestDto);

    @Named("teamFromId")
    default Team teamFromId(Long id) {
        return Optional.ofNullable(id)
                .map(Team::new)
                .orElse(null);
    }
}

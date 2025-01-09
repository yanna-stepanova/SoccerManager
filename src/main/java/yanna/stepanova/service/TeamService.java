package yanna.stepanova.service;

import java.util.List;
import yanna.stepanova.dto.team.CreateTeamRequestDto;
import yanna.stepanova.dto.team.TeamDto;

public interface TeamService {
    TeamDto save(CreateTeamRequestDto requestDto);

    TeamDto getTeamById(Long id);

    List<TeamDto> getAll();

    TeamDto updateTeamById(Long id, CreateTeamRequestDto requestDto);

    void deleteTeamById(Long id);
}

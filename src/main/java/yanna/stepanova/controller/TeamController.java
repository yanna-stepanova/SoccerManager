package yanna.stepanova.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yanna.stepanova.dto.team.CreateTeamRequestDto;
import yanna.stepanova.dto.team.TeamDto;
import yanna.stepanova.service.TeamService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teams")
@Validated
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public TeamDto createTeam(@RequestBody @Valid CreateTeamRequestDto requestDto) {
        return teamService.save(requestDto);
    }

    @GetMapping("/{id}")
    public TeamDto getTeamById(@PathVariable @Positive Long id) {
        return teamService.getTeamById(id);
    }

    @GetMapping
    public List<TeamDto> getAllTeams() {
        return teamService.getAll();
    }

    @PutMapping("/{id}")
    public TeamDto updateTeamById(@PathVariable @Positive Long id,
                                  @RequestBody @Valid CreateTeamRequestDto requestDto) {
        return teamService.updateTeamById(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamById(@PathVariable @Positive Long id) {
        teamService.deleteTeamById(id);
    }
}

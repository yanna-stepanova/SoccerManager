package yanna.stepanova.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yanna.stepanova.dto.team.CreateTeamRequestDto;
import yanna.stepanova.dto.team.TeamDto;
import yanna.stepanova.exception.EntityNotFoundCustomException;
import yanna.stepanova.mapper.TeamMapper;
import yanna.stepanova.model.Team;
import yanna.stepanova.repository.TeamRepository;
import yanna.stepanova.service.TeamService;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepo;
    private final TeamMapper teamMapper;

    @Override
    @Transactional
    public TeamDto save(CreateTeamRequestDto requestDto) {
        return teamMapper.toDto(teamRepo.save(teamMapper.toModel(requestDto)));
    }

    @Override
    public TeamDto getTeamById(Long id) {
        return teamRepo.findById(id)
                .map(teamMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundCustomException(
                        String.format("Team with id = %s not found", id)));
    }

    @Override
    public List<TeamDto> getAll() {
        return teamRepo.findAll().stream()
                .map(teamMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public TeamDto updateTeamById(Long id, CreateTeamRequestDto requestDto) {
        Team team = teamRepo.findById(id).orElseThrow(() -> new EntityNotFoundCustomException(
                String.format("Team with id = %s not found", id)));
        return teamMapper.toDto(teamMapper.updateTeamFromDto(team, requestDto));
    }

    @Override
    @Transactional
    public void deleteTeamById(Long id) {
        teamRepo.deleteById(id);
    }
}

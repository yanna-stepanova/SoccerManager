package yanna.stepanova.service;

import java.util.List;
import yanna.stepanova.dto.player.CreatePlayerRequestDto;
import yanna.stepanova.dto.player.PlayerDto;

public interface PlayerService {
    PlayerDto save(CreatePlayerRequestDto requestDto);

    PlayerDto getPlayerById(Long id);

    List<PlayerDto> getAll();

    PlayerDto updatePlayerById(Long id, CreatePlayerRequestDto requestDto);

    void deletePlayerById(Long id);

    List<PlayerDto> getAllByTeamId(Long teamId);
}

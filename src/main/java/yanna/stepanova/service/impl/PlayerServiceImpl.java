package yanna.stepanova.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yanna.stepanova.dto.player.CreatePlayerRequestDto;
import yanna.stepanova.dto.player.PlayerDto;
import yanna.stepanova.exception.EntityNotFoundCustomException;
import yanna.stepanova.mapper.PlayerMapper;
import yanna.stepanova.model.Player;
import yanna.stepanova.repository.PlayerRepository;
import yanna.stepanova.service.PlayerService;

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepo;

    @Override
    @Transactional
    public PlayerDto save(CreatePlayerRequestDto requestDto) {
        return playerMapper.toDto(playerRepo.save(playerMapper.toModel(requestDto)));
    }

    @Override
    public PlayerDto getPlayerById(Long id) {
        return playerRepo.findById(id)
                .map(playerMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundCustomException(
                        String.format("Player with id = %s noy found", id)));
    }

    @Override
    public List<PlayerDto> getAll() {
        return playerRepo.findAll().stream()
                .map(playerMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public PlayerDto updatePlayerById(Long id, CreatePlayerRequestDto requestDto) {
        Player player = playerRepo.findById(id).orElseThrow(() -> new EntityNotFoundCustomException(
                String.format("Player with id = %s not found", id)));
        return playerMapper.toDto(playerMapper.updatePlayerFromDto(player, requestDto));
    }

    @Override
    @Transactional
    public void deletePlayerById(Long id) {
        playerRepo.deleteById(id);
    }

    @Override
    public List<PlayerDto> getAllByTeamId(Long teamId) {
        return playerRepo.findAllByTeamId(teamId).stream()
                .map(playerMapper::toDto)
                .toList();
    }
}

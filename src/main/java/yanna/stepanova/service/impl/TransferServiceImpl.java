package yanna.stepanova.service.impl;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yanna.stepanova.dto.transfer.TransferDto;
import yanna.stepanova.exception.EntityNotFoundCustomException;
import yanna.stepanova.exception.InsufficientBalanceCustomException;
import yanna.stepanova.mapper.TransferMapper;
import yanna.stepanova.model.Player;
import yanna.stepanova.model.Team;
import yanna.stepanova.repository.PlayerRepository;
import yanna.stepanova.repository.TeamRepository;
import yanna.stepanova.service.TransferService;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService {
    private final TeamRepository teamRepo;
    private final PlayerRepository playerRepo;
    private final TransferMapper transferMapper;

    @Override
    @Transactional
    public TransferDto transferPlayer(Long playerId, Long teamId) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundCustomException("Player wasn't found"));
        Team newTeam = teamRepo.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundCustomException("New team not found"));

        BigDecimal totalTransferCost = calculateTransfer(player);
        if (newTeam.getBalance().compareTo(totalTransferCost) < 0) {
            throw new InsufficientBalanceCustomException(
                    "The team doesn't have enough money on balance for the transfer");
        }
        Team oldTeam = player.getTeam();
        transferFunds(newTeam, oldTeam, totalTransferCost);
        player.setTeam(newTeam);

        teamRepo.save(oldTeam);
        teamRepo.save(newTeam);
        playerRepo.save(player);

        return transferMapper.toDto(player, totalTransferCost, oldTeam, newTeam);
    }

    private void transferFunds(Team teamFrom, Team teamTo, BigDecimal totalTransferCost) {
        teamFrom.setBalance(teamFrom.getBalance().subtract(totalTransferCost));
        teamTo.setBalance(teamTo.getBalance().add(totalTransferCost));
    }

    private BigDecimal calculateTransfer(Player player) {
        double transferCost = (player.getExperienceInMonths() * 100000.0) / player.getAge();
        double transferCommission = transferCost * (player.getTeam().getCommission() / 100.0);
        return BigDecimal.valueOf(transferCost + transferCommission);
    }
}

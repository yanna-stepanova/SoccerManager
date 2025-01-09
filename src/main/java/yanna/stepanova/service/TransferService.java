package yanna.stepanova.service;

import yanna.stepanova.dto.transfer.TransferDto;

public interface TransferService {
    TransferDto transferPlayer(Long playerId, Long teamId);
}

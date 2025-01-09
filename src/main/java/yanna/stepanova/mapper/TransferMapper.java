package yanna.stepanova.mapper;

import java.math.BigDecimal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import yanna.stepanova.config.MapperConfig;
import yanna.stepanova.dto.transfer.TransferDto;
import yanna.stepanova.model.Player;
import yanna.stepanova.model.Team;

@Mapper(config = MapperConfig.class, uses = {TeamMapper.class, PlayerMapper.class})
public interface TransferMapper {
    @Mapping(target = "player", source = "player")
    @Mapping(target = "sumOfTransfer", source = "totalTransferCost")
    @Mapping(target = "oldTeam", source = "teamFrom")
    @Mapping(target = "newTeam", source = "teamTo")
    TransferDto toDto(Player player, BigDecimal totalTransferCost, Team teamFrom, Team teamTo);
}

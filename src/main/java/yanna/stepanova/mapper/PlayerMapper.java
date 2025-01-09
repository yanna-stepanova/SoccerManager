package yanna.stepanova.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import yanna.stepanova.config.MapperConfig;
import yanna.stepanova.dto.player.CreatePlayerRequestDto;
import yanna.stepanova.dto.player.PlayerDto;
import yanna.stepanova.model.Player;

@Mapper(config = MapperConfig.class, uses = TeamMapper.class)
public interface PlayerMapper {
    @Mapping(target = "team", source = "teamId", qualifiedByName = "teamFromId")
    Player toModel(CreatePlayerRequestDto requestDto);

    @Mapping(source = "team.id", target = "teamId")
    PlayerDto toDto(Player player);

    @Mapping(target = "team", source = "teamId", qualifiedByName = "teamFromId")
    Player updatePlayerFromDto(@MappingTarget Player player, CreatePlayerRequestDto requestDto);
}

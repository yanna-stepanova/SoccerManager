package yanna.stepanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yanna.stepanova.model.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByTeamId(Long teamId);
}

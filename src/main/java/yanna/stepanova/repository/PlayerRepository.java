package yanna.stepanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yanna.stepanova.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

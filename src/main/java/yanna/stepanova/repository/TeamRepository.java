package yanna.stepanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yanna.stepanova.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}

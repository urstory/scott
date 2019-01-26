package my.examples.scott.repository;

import my.examples.scott.domain.Bonus;
import my.examples.scott.domain.BonusId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, BonusId> {
}

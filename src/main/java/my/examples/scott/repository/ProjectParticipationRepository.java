package my.examples.scott.repository;

import my.examples.scott.domain.ProjectParticipation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectParticipationRepository extends JpaRepository<ProjectParticipation, Integer> {
}

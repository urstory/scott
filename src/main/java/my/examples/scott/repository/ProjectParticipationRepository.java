package my.examples.scott.repository;

import my.examples.scott.domain.ProjectParticipation;
import my.examples.scott.domain.ProjectParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectParticipationRepository extends JpaRepository<ProjectParticipation, ProjectParticipationId> {
}

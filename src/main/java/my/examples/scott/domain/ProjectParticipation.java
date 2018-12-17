package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project_participation")
@Getter
@Setter
public class ProjectParticipation {
    @EmbeddedId
    private ProjectParticipationId projectParticipationId;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

/*
CREATE TABLE PROJECT_PARTICIPATION(
   projectno    INTEGER NOT NULL,
   empno        INTEGER NOT NULL,
   start_date   VARCHAR(12) NOT NULL,
   end_date     VARCHAR(12),
   role_id      INTEGER
);
 */
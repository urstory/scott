package my.examples.scott.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProjectParticipationId   implements Serializable {
    private Integer projectno;
    private Integer empno;

    @Column(name = "start_date", length = 12)
    private String startDate;
}

/*
   projectno    INTEGER NOT NULL,
   empno        INTEGER NOT NULL,
   start_date   VARCHAR(12) NOT NULL,
 */
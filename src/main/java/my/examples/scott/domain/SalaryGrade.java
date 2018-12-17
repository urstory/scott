package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salarygrade")
@Getter
@Setter
public class SalaryGrade {
    @Id
    private Integer grade;
    private Integer losal;
    private Integer hisal;
}

/*
CREATE TABLE SALARYGRADE(
   grade      INTEGER NOT NULL,
   losal      INTEGER NOT NULL,
   hisal      INTEGER NOT NULL
);
 */
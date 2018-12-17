package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bonus")
@Getter
@Setter
public class Bonus {
    @EmbeddedId
    private BonusId bonusId;
    private Double sal;
    private Double comm;
}

/*
CREATE TABLE BONUS (
   ename      VARCHAR(10) NOT NULL,
   job        VARCHAR(9) NOT NULL,
   sal        DECIMAL(7, 2),
   comm       DECIMAL(7, 2)
);
 */
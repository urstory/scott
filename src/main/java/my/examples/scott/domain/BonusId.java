package my.examples.scott.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class BonusId  implements Serializable {
    @Column(length = 10)
    private String ename;

    @Column(length = 9)
    private String job;
}

/*
   ename      VARCHAR(10) NOT NULL,
   job        VARCHAR(9) NOT NULL,
 */
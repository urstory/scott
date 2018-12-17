package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {
    @Id
    private Integer projectno;

    @Column(length = 100)
    private String description;

    @Column(length = 12)
    private String startDate;

    @Column(length = 12)
    private String endDate;
}

/*
CREATE TABLE PROJECT(
   projectno    INTEGER NOT NULL,
   description  VARCHAR(100),
   start_date   VARCHAR(12),
   end_date     VARCHAR(12)
);
 */
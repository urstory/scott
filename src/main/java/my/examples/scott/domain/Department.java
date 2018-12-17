package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department {
    @Id
    private Integer deptno;

    @Column(length = 14)
    private String name;

    @Column(length = 13)
    private String location;
}

/*
CREATE TABLE DEPARTMENT(
   deptno     INTEGER NOT NULL,
   name       VARCHAR(14),
   location   VARCHAR(13)
);
 */
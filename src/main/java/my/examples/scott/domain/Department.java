package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.jdo.annotations.Join;
import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}

/*
CREATE TABLE DEPARTMENT(
   deptno     INTEGER NOT NULL,
   name       VARCHAR(14),
   location   VARCHAR(13)
);
 */
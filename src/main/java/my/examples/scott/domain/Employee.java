package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    private Integer empno;

    @Column(length = 10)
    private String name;

    @Column(length = 9)
    private String job;

    @ManyToOne
    @JoinColumn(name = "boss")
    private Employee boss;

    @Column(length = 12)
    private String hiredate;

    private Double salary;

    private Double comm;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Department department;
}

/*
CREATE TABLE EMPLOYEE(
   empno      INTEGER NOT NULL,
   name       VARCHAR(10),
   job        VARCHAR(9),
   boss       INTEGER,
   hiredate   VARCHAR(12),
   salary     DECIMAL(7, 2),
   comm       DECIMAL(7, 2),
   deptno     INTEGER
);
 */

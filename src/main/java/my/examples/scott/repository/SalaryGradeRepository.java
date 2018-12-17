package my.examples.scott.repository;

import my.examples.scott.domain.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryGradeRepository extends JpaRepository<SalaryGrade, Integer> {
}

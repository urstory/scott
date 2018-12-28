package my.examples.scott.repository.custom;

import com.querydsl.core.Tuple;
import my.examples.scott.domain.Employee;
import my.examples.scott.dto.NameAndGrade;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepositoryCustom {
    public List<Employee> findEmployees(String searchKind, String searchStr);

    public List<Tuple> getNameAndGradeByQuerydsl();
}

package my.examples.scott.repository.custom;

import my.examples.scott.domain.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    public List<Employee> findEmployees(String searchKind, String searchStr);
}

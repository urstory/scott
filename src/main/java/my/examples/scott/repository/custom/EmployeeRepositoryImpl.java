package my.examples.scott.repository.custom;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import my.examples.scott.domain.Employee;
import my.examples.scott.domain.QEmployee;
import my.examples.scott.domain.QSalaryGrade;
import my.examples.scott.dto.NameAndGrade;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class EmployeeRepositoryImpl extends QuerydslRepositorySupport implements EmployeeRepositoryCustom{
    public EmployeeRepositoryImpl(){
        super(Employee.class);
    }

    public List<Employee> findEmployees(String searchKind, String searchStr){
        QEmployee qEmployee = QEmployee.employee;

        // select e from Employee e inner join fetch e.department
//        JPQLQuery<Employee> jpqlQuery = from(qEmployee);
//        JPQLQuery<Employee> jpqlQuery = from(qEmployee).innerJoin(qEmployee.department).leftJoin(qEmployee.boss).fetchJoin();
//        JPQLQuery<Employee> jpqlQuery = from(qEmployee).innerJoin(qEmployee.department).fetchJoin().leftJoin(qEmployee.boss);
        JPQLQuery<Employee> jpqlQuery = from(qEmployee).innerJoin(qEmployee.department).fetchJoin().leftJoin(qEmployee.boss).fetchJoin();

        if(searchKind.equals("name")) {
            // select e from Employee e where e.name like ?
            jpqlQuery.where(qEmployee.name.like("%" + searchStr + "%"));
        }else{
            // select e from Employee e where e.department.name like ?
            jpqlQuery.where(qEmployee.department.name.like("%" + searchStr + "%"));
        }
        return jpqlQuery.fetch();
    }


    @Override
    public List<Tuple> getNameAndGradeByQuerydsl() {
        QEmployee qEmployee = QEmployee.employee;
        QSalaryGrade qSalaryGrade = QSalaryGrade.salaryGrade;

        JPQLQuery<Tuple> jpqlQuery = from(qEmployee, qSalaryGrade)
                .select(qEmployee.name, qSalaryGrade.grade)
                .where(qEmployee.salary.between(qSalaryGrade.losal, qSalaryGrade.hisal));
        return jpqlQuery.fetch();
    }
}

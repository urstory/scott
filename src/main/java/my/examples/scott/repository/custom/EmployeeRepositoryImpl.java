package my.examples.scott.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import my.examples.scott.domain.Employee;
import my.examples.scott.domain.QEmployee;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class EmployeeRepositoryImpl extends QuerydslRepositorySupport implements EmployeeRepositoryCustom{
    public EmployeeRepositoryImpl(){
        super(Employee.class);
    }

    public List<Employee> findEmployees(String searchKind, String searchStr){
        QEmployee qEmployee = QEmployee.employee;

//        JPQLQuery<Employee> jpqlQuery = from(qEmployee);
//        JPQLQuery<Employee> jpqlQuery = from(qEmployee).innerJoin(qEmployee.department).leftJoin(qEmployee.boss).fetchJoin();
//        JPQLQuery<Employee> jpqlQuery = from(qEmployee).innerJoin(qEmployee.department).fetchJoin().leftJoin(qEmployee.boss);
        JPQLQuery<Employee> jpqlQuery = from(qEmployee).innerJoin(qEmployee.department).fetchJoin().leftJoin(qEmployee.boss).fetchJoin();

        if(searchKind.equals("name")) {
            jpqlQuery.where(qEmployee.name.like("%" + searchStr + "%"));
        }else{
            jpqlQuery.where(qEmployee.department.name.like("%" + searchStr + "%"));
        }
        return jpqlQuery.fetch();
    }

}

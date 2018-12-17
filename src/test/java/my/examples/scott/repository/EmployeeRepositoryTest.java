package my.examples.scott.repository;

import my.examples.scott.domain.Employee;
import my.examples.scott.dto.NameAndGrade;
import my.examples.scott.dto.NameAndSalary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void getAlls() throws Exception{
        List<Employee> all = employeeRepository.findAll();
        for(Employee employee: all){
            System.out.println(employee.getEmpno());
        }
    }

    @Test
    public void getEmployeesOrderBySalPlusComm() throws Exception{
        List<Employee> all = employeeRepository.getEmployeesOrderBySalPlusComm();
        for(Employee employee: all){
            System.out.println(employee.getEmpno() + ", " + employee.getSalary() + ", " + employee.getComm());
        }
    }

    @Test
    public void getEnameAndSal() throws Exception{
        List<NameAndSalary> all = employeeRepository.getEnameAndSal();
        for(NameAndSalary employee: all){
            System.out.println(employee.getName() + ", " + employee.getSalary() + ", " + employee.getBonus());
        }
    }

    @Test
    public void getEmployeesBySalary() throws Exception{
        List<Employee> all = employeeRepository.getEmployeesBySalary();
        for(Employee employee: all){
            System.out.println(employee.getName() + ", " + employee.getSalary() );
        }
    }

    @Test
    public void getNameAndGrade() throws Exception{
        List<NameAndGrade> all = employeeRepository.getNameAndGrade();
        for(NameAndGrade employee: all){
            System.out.println(employee.getName() + ", " + employee.getSalaryGrade());
        }
    }
}

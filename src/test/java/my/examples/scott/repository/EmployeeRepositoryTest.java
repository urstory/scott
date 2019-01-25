package my.examples.scott.repository;

import com.querydsl.core.Tuple;
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

import javax.persistence.TupleElement;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeById(){
        Employee employee = employeeRepository.getEmployeeById(7369);
        System.out.println(employee.getEmpno() + "," + employee.getDepartment().getDeptno() );
        if(employee.getBoss() != null)
            System.out.println(employee.getBoss().getName());
    }
    @Test
    public void getEmployees1(){
        List<Employee> employees1 = employeeRepository.getEmployees1();
        for(Employee e : employees1){
            System.out.println(e.getEmpno() + ": " + e.getName() + ": " +  e.getDepartment().getName());
        }
    }

    @Test
    public void getAlls() throws Exception{
        List<Employee> all = employeeRepository.getEmployees2();
        for(Employee employee: all){
            System.out.println(employee.getEmpno() + "," + employee.getDepartment().getDeptno() );
            if(employee.getBoss() != null)
                System.out.println(employee.getBoss().getName());
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

    @Test
    public void findEmployees() throws Exception{
        List<Employee> employees = employeeRepository.findEmployees("name", "S"); // KING
        for(Employee employee : employees){
            System.out.println(employee.getName() + " , " + employee.getSalary() + "," + (employee.getBoss() != null ? employee.getBoss().getName() : ""));
        }

        System.out.println("-------------------------------------------------");
        employees = employeeRepository.findEmployees("department", "ACCOUNTING");
        for(Employee employee : employees){
            System.out.println(employee.getName() + " , " + employee.getSalary()+ "," + (employee.getBoss() != null ? employee.getBoss().getName() : ""));
        }
    }

    @Test
    public void getNameAndGradeByQuerydsl() throws Exception{
        List<Tuple> tuples = employeeRepository.getNameAndGradeByQuerydsl();
        for(Tuple t : tuples){
            System.out.println(t.get(0, String.class) + "," +
                    t.get(1, Integer.class));
        }
    }
}

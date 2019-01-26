package my.examples.scott.repository;

import my.examples.scott.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Employee2RepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository; // test 할 Repository를 주입받는다.

    // 사원목록을 구하는 쿼리 1건 + 부서정보를 쿼리 3건
    @Test
    public void findAll() throws Exception{
        List<Employee> findAll = employeeRepository.getEmployeesOrderBySalPlusComm();
        for(Employee employee : findAll){
            System.out.println(employee.getName() + ", " + employee.getDepartment().getName());
        }
    }

    @Test
    public void findById() throws Exception{
        Employee employee
                = employeeRepository.getEmployeeById(7369);
        System.out.println(employee.getName());
        System.out.println(employee.getDepartment().getName());
    }
}

package my.examples.scott.repository;

import my.examples.scott.domain.Employee;
import my.examples.scott.dto.NameAndGrade;
import my.examples.scott.dto.NameAndSalary;
import my.examples.scott.repository.custom.EmployeeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {
    /*
    사원의 이름, 급여, 커미션, 총액(급여+커미션)을 구하여 총액이 많은 순서로 출력하여라.
    (단, 커미션이 nll인 사원도 0으로 해서 포함하여라.)

    select ename,sal,nvl(comm, 0),nvl(sal+comm,0) total
    fom emp
    order by  nvl(sal+comm,0) desc ;
     */
// nvl은 사용할 수 없다.
//    @Query("select e from Employee e order by   CASE WHEN (e.salary + e.comm) is null THEN e.salary ELSE (e.salary + e.comm) END desc ")
    @Query("select e from Employee e order by e.salary + coalesce(e.comm, 0) desc ")
    public List<Employee> getEmployeesOrderBySalPlusComm();


    /*
    10번 부서의 모든 사원에게 급여의 13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스 금액, 부서 번호를 출력하여라.
    select ename ,sal,(sal*0.13) bonus,deptno from emp where deptno = 10;
     */
    @Query("select new my.examples.scott.dto.NameAndSalary(e.name, e.salary, e.salary * 0.13) from Employee e ")
    public List<NameAndSalary> getEnameAndSal();

    /*
    급여가 $1,500부터 $3,000 사이의 사원에 대해서만 급여의 15%를 회비로 지불하기로 하였다.
    모든 사원의 이름, 급여, 회비(소수이하 2자리까지  반올림)를 출력하여라.

    select ename 이름,sal 급여,round(sal*0.15,1) 회비 from emp where sal  between 1500 and 3000 order by sal;
     */
    @Query("select e from Employee e join fetch e.department where e.salary between 1500 and 3000 order by e.salary")
    public List<Employee> getEmployeesBySalary();

    /*
    사원의 이름과 그 사원의 급여 등급을 출력하시오.

    select e.name, sg.grade from employee e, salarygrade sg where e.salary between sg.losal and sg.hisal
     */
    @Query("select new my.examples.scott.dto.NameAndGrade(e.name, sg.grade) from Employee e, SalaryGrade sg where e.salary between sg.losal and sg.hisal")
    public List<NameAndGrade> getNameAndGrade();
}

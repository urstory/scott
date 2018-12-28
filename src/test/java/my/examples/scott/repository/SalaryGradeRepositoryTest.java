package my.examples.scott.repository;

import my.examples.scott.domain.Bonus;
import my.examples.scott.domain.SalaryGrade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalaryGradeRepositoryTest {
    @Autowired
    SalaryGradeRepository salaryGradeRepository;

    @Test
    public void delete() throws Exception{
        salaryGradeRepository.deleteById(2);
        SalaryGrade one =
                salaryGradeRepository.getOne(2);
        System.out.println(one);
    }
}

package my.examples.scott.repository;

import my.examples.scott.domain.Bonus;
import my.examples.scott.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BonusRepositoryTest {
    @Autowired
    BonusRepository bonusRepository;

    @Test
    public void getAlls() throws Exception{
        List<Bonus> all = bonusRepository.findAll();
        for(Bonus bonus: all){
            System.out.println(bonus.getBonusId());
        }
    }
}

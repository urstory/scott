package my.examples.scott.repository;

import my.examples.scott.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void getAll() throws Exception{
        System.out.println(boardRepository.getClass().getName());
        List<Board> boards = boardRepository.findAll();
        boards.forEach(System.out::println);
    }

    @Test
    @Rollback(false)
    public void addBoard() throws Exception{
        Board board = new Board();
        board.setName("kim");
        board.setTitle("title kim");
        board.setContent("content kim");
        board.setReadCount(0);
        board.setRegdate(new Date());
        board = boardRepository.save(board);
        System.out.println(board);
    }
}

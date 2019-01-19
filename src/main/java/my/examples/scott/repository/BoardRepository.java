package my.examples.scott.repository;

import my.examples.scott.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<엔티티클래스명, ID의클래스명>를 상속받는 인터페이스를 작성한다.
public interface BoardRepository extends JpaRepository<Board, Long> {
}

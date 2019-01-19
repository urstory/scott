package my.examples.scott.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board")
@Setter
@Getter
public class Board {
    @Id // 엔티티는 id 가 있어야 한다. (식별자.)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 사용자가 입력하는 값이 아니라 자동 생성.
    private Long id;
    private String name;
    private String title;
    private String content;
    private int readCount;
    private Date regdate;

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", readCount=" + readCount +
                ", regdate=" + regdate +
                '}';
    }
}

/*
CREATE TABLE board(
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) not null,
    title VARCHAR(255) not null,
    content LONGTEXT not null,
    read_count INTEGER,
    regdate DATE,
    PRIMARY KEY(id)
);
 */
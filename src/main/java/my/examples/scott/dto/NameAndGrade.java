package my.examples.scott.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameAndGrade {
    private String name;
    private Integer salaryGrade;
}

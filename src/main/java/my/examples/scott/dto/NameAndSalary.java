package my.examples.scott.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameAndSalary {
    private String name;
    private double salary;
    private double bonus;
}

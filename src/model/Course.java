package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String title;
    private String [] instructorName;
    private String [] requirement;
    private String startDate;
    public static Integer generateId(){
        return ((new Random().nextInt(9000) + 1001));
    }
}

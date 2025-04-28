package tadjik.ilyosjon.onlinecoursemanagementsystem.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Student;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {

    private Long student;
    private Long course;
}

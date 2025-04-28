package tadjik.ilyosjon.onlinecoursemanagementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {
    private String fullName;
    private Integer experienceYears;
    private String email;
    private Long course;
}

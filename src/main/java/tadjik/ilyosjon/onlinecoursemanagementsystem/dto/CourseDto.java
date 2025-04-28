package tadjik.ilyosjon.onlinecoursemanagementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Instructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String title;
    private String description;
    private Integer durationInWeeks;
    private Long instructor;
}

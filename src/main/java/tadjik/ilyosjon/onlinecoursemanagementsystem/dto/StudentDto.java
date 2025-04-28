package tadjik.ilyosjon.onlinecoursemanagementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Enrollment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String fullname;
    private Integer age;
    private String email;
    private Long enrollments;
}

package tadjik.ilyosjon.onlinecoursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String email;
    @OneToMany
    private List<Enrollment> enrollments;
}

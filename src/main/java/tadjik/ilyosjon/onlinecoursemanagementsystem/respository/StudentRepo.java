package tadjik.ilyosjon.onlinecoursemanagementsystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}

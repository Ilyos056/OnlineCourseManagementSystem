package tadjik.ilyosjon.onlinecoursemanagementsystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {
}

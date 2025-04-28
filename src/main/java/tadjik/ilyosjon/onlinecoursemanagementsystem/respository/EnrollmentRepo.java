package tadjik.ilyosjon.onlinecoursemanagementsystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}

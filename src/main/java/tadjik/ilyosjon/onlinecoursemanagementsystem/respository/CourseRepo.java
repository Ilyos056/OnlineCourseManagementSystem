package tadjik.ilyosjon.onlinecoursemanagementsystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {
}

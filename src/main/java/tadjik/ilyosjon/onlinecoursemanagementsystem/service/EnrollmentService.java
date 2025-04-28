package tadjik.ilyosjon.onlinecoursemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.EnrollmentDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Enrollment;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Student;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.CourseRepo;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.EnrollmentRepo;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    @Autowired
    EnrollmentRepo enrollmentRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;

    public List<Enrollment> getAll() {
        return enrollmentRepo.findAll();
    }

    public Enrollment getById(Long id) {
        return enrollmentRepo.findById(id).get();
    }

    public Result create(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = new Enrollment();

        Optional<Student> studentOptional = studentRepo.findById(enrollmentDto.getStudent());
        Student student = studentOptional.get();
        enrollment.setStudent(student);

        Optional<Course> courseOptional = courseRepo.findById(enrollmentDto.getCourse());
        Course course = courseOptional.get();
        enrollment.setCourse(course);
        enrollmentRepo.save(enrollment);
        return new Result(true, "Enrollment created");
    }

    public Result update(Long id, EnrollmentDto enrollmentDto) {
        Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(id);
        if (enrollmentOptional.isPresent()) {
            Enrollment enrollment = enrollmentOptional.get();
            Optional<Student> studentOptional = studentRepo.findById(enrollmentDto.getStudent());
            Student student = studentOptional.get();
            enrollment.setStudent(student);
            Optional<Course> courseOptional = courseRepo.findById(enrollmentDto.getCourse());
            Course course = courseOptional.get();
            enrollment.setCourse(course);
            enrollmentRepo.save(enrollment);
            return new Result(true, "Enrollment updated");
        }
        return new Result(false, "Enrollment not found");
    }

    public Result delete(Long id) {
        enrollmentRepo.deleteById(id);
        return new Result(true, "Enrollment deleted");
    }
}


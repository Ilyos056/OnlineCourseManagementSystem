package tadjik.ilyosjon.onlinecoursemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.StudentDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Enrollment;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Student;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.EnrollmentRepo;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    EnrollmentRepo enrollmentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getById(Long id) {
        return studentRepo.findById(id).get();
    }

    public Result create(StudentDto studentDto) {
        Student student = new Student();
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());
        student.setFullname(studentDto.getFullname());

        Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(studentDto.getEnrollments());
        Enrollment enrollment = enrollmentOptional.get();
        student.setEnrollments((List<Enrollment>) enrollment);
        studentRepo.save(student);
        return new Result(true,"Successfully created");
    }

    public Result update(Long id, StudentDto studentDto) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setAge(studentDto.getAge());
            student.setEmail(studentDto.getEmail());
            student.setFullname(studentDto.getFullname());

            Optional<Enrollment> enrollmentOptional = enrollmentRepo.findById(studentDto.getEnrollments());
            Enrollment enrollment = enrollmentOptional.get();
            student.setEnrollments((List<Enrollment>) enrollment);

            studentRepo.save(student);
            return new Result(true,"Successfully updated");
        }
        return new Result(false,"No such student");
    }

    public Result delete(Long id) {
        studentRepo.deleteById(id);
        return new Result(true,"Successfully deleted");
    }

}

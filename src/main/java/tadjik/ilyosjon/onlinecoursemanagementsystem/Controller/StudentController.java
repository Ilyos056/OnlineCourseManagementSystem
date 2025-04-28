package tadjik.ilyosjon.onlinecoursemanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.CourseDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.StudentDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Student;
import tadjik.ilyosjon.onlinecoursemanagementsystem.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Student> getall = studentService.getAllStudents();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        Student getbyid = studentService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody StudentDto studentDto) {
        Result result = studentService.create(studentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody StudentDto studentDto) {
        Result update = studentService.update(id, studentDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = studentService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}

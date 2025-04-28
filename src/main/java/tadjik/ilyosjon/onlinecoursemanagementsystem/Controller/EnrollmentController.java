package tadjik.ilyosjon.onlinecoursemanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.CourseDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.EnrollmentDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Enrollment;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Enrollment> getall = enrollmentService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        Enrollment getbyid = enrollmentService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody EnrollmentDto  enrollmentDto) {
        Result result = enrollmentService.create(enrollmentDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody EnrollmentDto enrollmentDto) {
        Result update = enrollmentService.update(id, enrollmentDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = enrollmentService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}

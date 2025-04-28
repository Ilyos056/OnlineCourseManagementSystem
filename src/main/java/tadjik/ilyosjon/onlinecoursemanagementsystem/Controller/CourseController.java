package tadjik.ilyosjon.onlinecoursemanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.CourseDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Course> getall = courseService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        Course getbyid = courseService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody CourseDto courseDto) {
        Result result = courseService.create(courseDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody CourseDto courseDto) {
        Result update = courseService.update(id, courseDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = courseService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}

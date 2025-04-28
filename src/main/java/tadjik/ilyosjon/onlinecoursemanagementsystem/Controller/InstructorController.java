package tadjik.ilyosjon.onlinecoursemanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.InstructorDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.StudentDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Instructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Student;
import tadjik.ilyosjon.onlinecoursemanagementsystem.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/instuctor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Instructor> getall = instructorService.getAll();
        return new ResponseEntity<>(getall, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Long id) {
        Instructor getbyid = instructorService.getById(id);
        return new ResponseEntity<>(getbyid, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody InstructorDto instructorDto) {
        Result result = instructorService.create(instructorDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id,  @RequestBody InstructorDto instructorDto) {
        Result update = instructorService.update(id, instructorDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = instructorService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}

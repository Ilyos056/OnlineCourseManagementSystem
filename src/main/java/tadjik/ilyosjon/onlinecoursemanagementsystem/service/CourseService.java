package tadjik.ilyosjon.onlinecoursemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.CourseDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Instructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.CourseRepo;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.InstructorRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    InstructorRepo instructorRepo;

    public List<Course> getAll(){
        return courseRepo.findAll();
    }

    public Course getById(Long id){
        return courseRepo.findById(id).get();
    }

    public Result create(CourseDto courseDto){
        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setDurationInWeeks(courseDto.getDurationInWeeks());

        Optional<Instructor> instructorOptional = instructorRepo.findById(courseDto.getInstructor());
        Instructor instructor = instructorOptional.get();
        course.setInstructor((List<Instructor>) instructor);
        courseRepo.save(course);
        return new Result(true,"Course created");
    }

    public Result update(Long id, CourseDto courseDto){
        Optional<Course> courseOptional = courseRepo.findById(id);
        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            course.setTitle(courseDto.getTitle());
            course.setDescription(courseDto.getDescription());
            course.setDurationInWeeks(courseDto.getDurationInWeeks());

            Optional<Instructor> instructorOptional = instructorRepo.findById(courseDto.getInstructor());
            Instructor instructor = instructorOptional.get();
            course.setInstructor((List<Instructor>) instructor);
            courseRepo.save(course);
            return new Result(true,"Course updated");
        }
        return new Result(false,"Course not found");
    }

    public Result delete(Long id){
        courseRepo.deleteById(id);
        return new Result(true,"Course deleted");
    }
}

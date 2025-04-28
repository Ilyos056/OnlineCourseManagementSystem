package tadjik.ilyosjon.onlinecoursemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.CourseDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.dto.InstructorDto;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Course;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Instructor;
import tadjik.ilyosjon.onlinecoursemanagementsystem.model.Result;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.CourseRepo;
import tadjik.ilyosjon.onlinecoursemanagementsystem.respository.InstructorRepo;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    InstructorRepo instructorRepo;

    @Autowired
    CourseRepo courseRepo;

    public List<Instructor> getAll(){
        return instructorRepo.findAll();
    }

    public Instructor getById(Long id){
        return instructorRepo.findById(id).get();
    }

    public Result create(InstructorDto instructorDto){
        Instructor instructor = new Instructor();
        instructor.setEmail(instructorDto.getEmail());
        instructor.setFullName(instructorDto.getFullName());
        instructor.setExperienceYears(instructorDto.getExperienceYears());

        Optional<Course> courseOptional = courseRepo.findById(instructorDto.getCourse());
        Course course = courseOptional.get();
        instructor.setCourse((List<Course>) course);
        instructorRepo.save(instructor);
        return new Result(true, "Successfully created instructor");
    }

    public Result update(Long id, InstructorDto instructorDto){
        Optional<Instructor> instructorOptional = instructorRepo.findById(id);
        if (instructorOptional.isPresent()) {
            Instructor instructor = instructorOptional.get();
            instructor.setFullName(instructorDto.getFullName());
            instructor.setExperienceYears(instructorDto.getExperienceYears());

            Optional<Course> courseOptional = courseRepo.findById(instructorDto.getCourse());
            Course course = courseOptional.get();
            instructor.setCourse((List<Course>) course);
            instructorRepo.save(instructor);
            return new Result(true, "Successfully updated instructor");
        }
        return new Result(false, "Course not found");
    }

    public Result delete(Long id){
        instructorRepo.deleteById(id);
        return new Result(true, "Successfully deleted");
    }

}

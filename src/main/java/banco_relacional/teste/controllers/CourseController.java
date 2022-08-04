package banco_relacional.teste.controllers;

import banco_relacional.teste.dtos.CourseDto;
import banco_relacional.teste.entities.Course;
import banco_relacional.teste.entities.Student;
import banco_relacional.teste.repositories.CourseRepository;
import banco_relacional.teste.services.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }


    @GetMapping(value = "/page:{page}/size:{size}")
    public Page<Course> findAllPaged(@PathVariable int page, @PathVariable int size) {
        return courseService.findAllPaged(page, size);
    }

    @GetMapping(value = "/{id}")
    public CourseDto findById(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        CourseDto courseDto = new CourseDto();

        courseDto.setCourseName(course.get().getCourseName());
        courseDto.setRoom(course.get().getRoom());
        courseDto.setStudents(course.get().getStudents());

        return courseDto;
    }



    @PostMapping
    public Course insert(@RequestBody CourseDto courseDto) {
        return courseService.insert(courseDto);
    }

}

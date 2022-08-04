package banco_relacional.teste.services.implementations;

import banco_relacional.teste.dtos.CourseDto;
import banco_relacional.teste.entities.Course;
import banco_relacional.teste.repositories.CourseRepository;
import banco_relacional.teste.services.interfaces.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImplem implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course insert(CourseDto courseDto) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> coursesWithStudents() {
        return courseRepository.coursesWithStudents();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Page<Course> findAllPaged(int page, int size) {
        Pageable pagedElements = PageRequest.of(page, size);
        return courseRepository.findAll(pagedElements);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

}

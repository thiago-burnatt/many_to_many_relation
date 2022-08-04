package banco_relacional.teste.services.interfaces;

import banco_relacional.teste.dtos.CourseDto;
import banco_relacional.teste.entities.Course;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course insert(CourseDto courseDto);
    List<Course> findAll();

    List<Course> coursesWithStudents();
    Optional<Course> findById(Long id);

    Page<Course> findAllPaged(int page, int size);
    void deleteById(Long id);

}

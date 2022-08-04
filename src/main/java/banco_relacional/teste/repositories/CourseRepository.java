package banco_relacional.teste.repositories;

import banco_relacional.teste.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {



    @Query("SELECT obj FROM Course obj JOIN FETCH obj.students")
    List<Course> coursesWithStudents();
}

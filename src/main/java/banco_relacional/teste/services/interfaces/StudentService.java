package banco_relacional.teste.services.interfaces;

import banco_relacional.teste.dtos.StudentDto;
import banco_relacional.teste.entities.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student insert(StudentDto studentDto);

    List<Student> findAll();

    Optional<Student> findById(Long id);

    Page<Student> findAllPaged(int page, int size);

    void update(Student student);
    void deleteById(Long id);
}
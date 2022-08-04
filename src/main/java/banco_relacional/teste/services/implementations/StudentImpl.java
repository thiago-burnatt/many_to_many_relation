package banco_relacional.teste.services.implementations;

import banco_relacional.teste.dtos.StudentDto;
import banco_relacional.teste.entities.Student;
import banco_relacional.teste.repositories.StudentRepository;
import banco_relacional.teste.services.interfaces.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student insert(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        List<Student> result = studentRepository.findAll();
        return result;
    }

    @Override
    public Optional<Student>findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Page<Student> findAllPaged(int page, int size) {
        Pageable pagedElements = PageRequest.of(page, size);
        return studentRepository.findAll(pagedElements);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}

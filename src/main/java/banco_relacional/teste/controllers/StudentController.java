package banco_relacional.teste.controllers;

import banco_relacional.teste.dtos.StudentDto;
import banco_relacional.teste.entities.Student;
import banco_relacional.teste.services.interfaces.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/page:{page}/size:{size}")
    public Page<Student> findAllPaged(@PathVariable int page, @PathVariable int size) {
        return studentService.findAllPaged(page, size);
    }

    @GetMapping(value = "/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student insert(@RequestBody StudentDto studentDto) {
        return studentService.insert(studentDto);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Optional<Student> data = studentService.findById(id);
        Student student = new Student();
        data.orElseThrow().setName(studentDto.getName());

        student.setName(data.get().getName());
        student.setCity(data.get().getCity());

        studentService.update(student);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}

package banco_relacional.teste.repositories;

import banco_relacional.teste.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
}

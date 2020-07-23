package co.id.mhanifmuhsin.mysqldemo.student;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
//Repository
public interface StudentRepository extends CrudRepository<Student,String> {
    Optional<Student> findById(String id);
    List<Student>findAll();
    Optional<Student>findAllByLastName(String lastName);
}

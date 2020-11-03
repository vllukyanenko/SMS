package ua.lukianenko.ums.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lukianenko.ums.model.persons.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    Page<Student> findAll(Pageable pageable);
}

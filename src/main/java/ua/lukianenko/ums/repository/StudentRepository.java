package ua.lukianenko.ums.repository;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import ua.lukianenko.ums.model.persons.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    @NonNullApi
    Page<Student> findAll(Pageable pageable);
}

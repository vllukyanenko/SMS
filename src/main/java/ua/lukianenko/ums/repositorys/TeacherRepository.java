package ua.lukianenko.ums.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.lukianenko.ums.model.persons.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Override
    Page<Teacher> findAll(Pageable pageable);
}

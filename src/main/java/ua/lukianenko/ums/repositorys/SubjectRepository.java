package ua.lukianenko.ums.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lukianenko.ums.model.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Override
    Page<Subject> findAll(Pageable pageable);
}

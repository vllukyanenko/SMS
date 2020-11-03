package ua.lukianenko.ums.repository;

import ua.lukianenko.ums.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    Page<Group> findAll(Pageable pageable);
}

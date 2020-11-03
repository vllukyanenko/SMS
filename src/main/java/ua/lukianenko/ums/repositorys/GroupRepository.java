package ua.lukianenko.ums.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lukianenko.ums.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    Page<Group> findAll(Pageable pageable);
}

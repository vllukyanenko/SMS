package ua.lukianenko.ums.model;

import ua.lukianenko.ums.model.persons.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.util.*;

@Data
@Entity(name = "Subject")
@Table(name = "subjects", schema = "ums")
@RequiredArgsConstructor
@NoArgsConstructor
public class Subject extends AbstractEntity {

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column(length = 200)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Teacher> teachers = new HashSet<>();
}
package ua.lukianenko.ums.model;

import ua.lukianenko.ums.model.persons.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Data
@Entity(name = "Group")
@Table(name = "groups", schema = "ums")
@NoArgsConstructor
public class Group extends AbstractEntity {

    @Column(nullable = false)
    @NonNull
    private String name;

    @OneToOne
    @JoinColumn(name = "headman_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Student headman;

}
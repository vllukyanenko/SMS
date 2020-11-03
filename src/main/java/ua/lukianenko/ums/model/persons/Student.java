package ua.lukianenko.ums.model.persons;

import ua.lukianenko.ums.model.Group;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "Student")
@Table(name = "students", schema = "ums")
@NoArgsConstructor
public class Student extends Person {

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    public Student(String firstName, String lastName, Date dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }
}
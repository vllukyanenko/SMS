package ua.lukianenko.ums.model.persons;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "Teacher")
@Table(name = "teacher", schema = "ums")
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor
public class Teacher extends Person {

    @Column(nullable = false)
    @NonNull
    private String phoneNumber;

    @Builder
    public Teacher(String firstName, String lastName, Date dateOfBirth, String phoneNumber) {
        super(firstName, lastName, dateOfBirth);
        this.phoneNumber = phoneNumber;
    }
}

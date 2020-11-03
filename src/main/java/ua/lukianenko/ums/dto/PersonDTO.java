package ua.lukianenko.ums.dto;

import lombok.*;

import java.sql.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonDTO extends AbstractDTO {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
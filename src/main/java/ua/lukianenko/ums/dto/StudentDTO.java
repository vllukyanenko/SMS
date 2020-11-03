package ua.lukianenko.ums.dto;

import ua.lukianenko.ums.model.Group;
import lombok.*;


@Getter
@ToString
@Setter
@NoArgsConstructor
public class StudentDTO extends PersonDTO {

    private String phoneNumber;
    private Group group;
}
package ua.lukianenko.ums.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends PersonDTO {

    private String phoneNumber;
}

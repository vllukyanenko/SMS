package ua.lukianenko.ums.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends PersonDTO {

    private String phoneNumber;
}

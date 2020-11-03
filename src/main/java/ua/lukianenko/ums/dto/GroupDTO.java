package ua.lukianenko.ums.dto;

import ua.lukianenko.ums.model.persons.Student;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class GroupDTO extends AbstractDTO {
    @NonNull
    private String name;
    private Student headman;
}
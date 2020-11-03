package ua.lukianenko.ums.dto;

import ua.lukianenko.ums.model.persons.Teacher;
import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class SubjectDTO extends AbstractDTO {
    @NonNull
    private String name;
    private String description;
    private Set<Teacher> teachers;
}
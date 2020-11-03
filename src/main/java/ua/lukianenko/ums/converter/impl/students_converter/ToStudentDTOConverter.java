package ua.lukianenko.ums.converter.impl.students_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.StudentDTO;
import ua.lukianenko.ums.model.persons.Student;
@Slf4j
@Component
public class ToStudentDTOConverter extends AbstractConverterImpl<Student, StudentDTO> {
    @Override
    protected StudentDTO generateTarget() {
        log.info("Generate StudentsDTO");
        return new StudentDTO();
    }

    @Override
    public void convert(Student source, StudentDTO target) {
        log.info("Convert to StudentDTO");
        target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setGroup(source.getGroup());
    }
}

package ua.lukianenko.ums.converter.impl.students_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.StudentDTO;
import ua.lukianenko.ums.model.persons.Student;

@Slf4j
@Component
public class ToStudentConverter extends AbstractConverterImpl<StudentDTO, Student> {

    @Override
    protected Student generateTarget() {
        log.info("Generate new Student");
        return new Student();
    }

    @Override
    public void convert(StudentDTO source, Student target) {
        log.info("Convert to Student");
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setGroup(target.getGroup());

    }
}

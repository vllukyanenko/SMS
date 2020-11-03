package ua.lukianenko.ums.converter.impl.teacher_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.TeacherDTO;
import ua.lukianenko.ums.model.persons.Teacher;

@Slf4j
@Component
public class ToTeacherDTOConverter extends AbstractConverterImpl<Teacher, TeacherDTO> {

    @Override
    protected TeacherDTO generateTarget() {
        log.info("Generate TeacherDTO");
        return new TeacherDTO();
    }

    @Override
    public void convert(Teacher source, TeacherDTO target) {
        log.info("Convert to TeacherDTO");
        target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setPhoneNumber(source.getPhoneNumber());

    }
}

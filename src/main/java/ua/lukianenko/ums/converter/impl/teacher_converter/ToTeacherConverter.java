package ua.lukianenko.ums.converter.impl.teacher_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.TeacherDTO;
import ua.lukianenko.ums.model.persons.Teacher;

@Slf4j
@Component
public class ToTeacherConverter extends AbstractConverterImpl<TeacherDTO, Teacher> {

    @Override
    protected Teacher generateTarget() {
        log.info("Generate NEW Teacher");
        return new Teacher();
    }

    @Override
    public void convert(TeacherDTO source, Teacher target) {
        log.info("Convert to Teacher");
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setPhoneNumber(source.getPhoneNumber());
    }
}

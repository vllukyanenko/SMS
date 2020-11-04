package ua.lukianenko.ums.converter.impl.sabject_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.SubjectDTO;
import ua.lukianenko.ums.model.Subject;
@Slf4j
@Component
public class ToSubjectConverter extends AbstractConverterImpl<SubjectDTO, Subject> {
    @Override
    protected Subject generateTarget() {
        log.info("Generate NEW Subject");
        return new Subject();
    }

    @Override
    public void convert(SubjectDTO source, Subject target) {
        log.info("Convert to Subject");
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setTeachers(source.getTeachers());
    }
}

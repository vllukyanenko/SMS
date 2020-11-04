package ua.lukianenko.ums.converter.impl.sabject_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.SubjectDTO;
import ua.lukianenko.ums.model.Subject;
@Slf4j
@Component
public class ToSubjectDTOConverter extends AbstractConverterImpl<Subject, SubjectDTO> {
    @Override
    protected SubjectDTO generateTarget() {
        log.info("Generate NEW Subject");
        return new SubjectDTO();
    }

    @Override
    public void convert(Subject source, SubjectDTO target) {
        log.info("Convert to Subject");
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setTeachers(source.getTeachers());
    }
}

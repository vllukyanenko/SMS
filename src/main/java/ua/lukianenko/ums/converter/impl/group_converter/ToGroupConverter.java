package ua.lukianenko.ums.converter.impl.group_converter;

import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.GroupDTO;
import ua.lukianenko.ums.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ToGroupConverter extends AbstractConverterImpl<GroupDTO, Group> {
    @Override
    protected Group generateTarget() {
        log.info("Generate Group");
        return new Group();
    }

    @Override
    public void convert(GroupDTO source, Group target) {
        log.info("Convert to Group");
        target.setId(source.getId());
        target.setName(source.getName());
        target.setHeadman(source.getHeadman());
    }
}

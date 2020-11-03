package ua.lukianenko.ums.converter.impl.group_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.lukianenko.ums.converter.impl.AbstractConverterImpl;
import ua.lukianenko.ums.dto.GroupDTO;
import ua.lukianenko.ums.model.Group;

@Slf4j
@Component
public class ToGroupDTOConverter extends AbstractConverterImpl<Group, GroupDTO> {
    @Override
    protected GroupDTO generateTarget() {
        log.info("Generate GroupDTO");
        return new GroupDTO();
    }


    @Override
    public void convert(Group source, GroupDTO target) {
        log.info("Convert to GroupDTO");
        target.setId(source.getId());
        target.setName(source.getName());
        target.setHeadman(source.getHeadman());

    }
}


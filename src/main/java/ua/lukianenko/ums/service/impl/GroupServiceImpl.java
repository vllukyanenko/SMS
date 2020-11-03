package ua.lukianenko.ums.service.impl;

import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.exceptions.ObjectNotFoundException;
import ua.lukianenko.ums.converter.impl.group_converter.ToGroupConverter;
import ua.lukianenko.ums.converter.impl.group_converter.ToGroupDTOConverter;
import ua.lukianenko.ums.dto.GroupDTO;
import ua.lukianenko.ums.model.Group;
import ua.lukianenko.ums.repositorys.GroupRepository;
import ua.lukianenko.ums.service.GroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    @NonNull
    private final GroupRepository groupRepository;
    @NonNull
    private final ToGroupDTOConverter toGroupDTOConverter;
    @NonNull
    private final ToGroupConverter toGroupConverter;


    @Transactional
    @Override
    public ResponseEntity<Long> save(GroupDTO groupDTO) {
        log.info("IN GroupServiceIml saveGroupDTO {}", groupDTO);

        return new ResponseEntity<>(groupRepository.save(toGroupConverter.convert(groupDTO)).getId()
                , HttpStatus.CREATED);

    }

    @Transactional
    @Override
    public ResponseEntity<Long> deleteById(Long id) {
        log.info("IN GroupServiceImpl deleteById {}", id);
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Group.class));

        groupRepository.deleteById(id);
        return new ResponseEntity<>(group.getId(), HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<GroupDTO> getById(Long id) {
        log.info("IN GroupServiceImpl getById {}", id);

        return new ResponseEntity<>(toGroupDTOConverter.convert(groupRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id,Group.class))), HttpStatus.OK);

    }

    @Transactional
    @Override
    public ResponseEntity<Long> updateById(Long id, GroupDTO groupDTO) {
        log.info("IN GroupServiceImpl updateById");
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Group.class));

        group.setName(groupDTO.getName());
        group.setHeadman(groupDTO.getHeadman());

        return new ResponseEntity<>(toGroupDTOConverter.convert(groupRepository.save(group)).getId(), HttpStatus.OK);
    }


    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<GroupDTO>> getAll() {
        log.info("IN GroupServiceImpl getAll");
       List<GroupDTO> groups = toGroupDTOConverter.convert(groupRepository.findAll());

        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @Override
    public PageResponse<GroupDTO> getPage(int pageNo, int pageSize, String sorting, String name) {
        log.info("IN GroupServiceImpl getPage with sorting");

        Sort sort = name.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending():
                Sort.by(sorting).descending();
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);

        Page<Group> groupPage =groupRepository.findAll(pageable);

        return new PageResponse<>(
                toGroupDTOConverter.convert( groupPage.getContent()),
                groupPage.getTotalElements(),
                groupPage.getNumber()+1,
                groupPage.getSize());
    }
}

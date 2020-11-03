package ua.lukianenko.ums.service;

import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.GroupDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GroupService {

    ResponseEntity<GroupDTO> getById(Long id);

    ResponseEntity<Long> save(GroupDTO groupDTO);

    ResponseEntity<Long> updateById(Long id, GroupDTO groupDTO);

    ResponseEntity<Long> deleteById(Long id);

    ResponseEntity<List<GroupDTO>> getAll();

    PageResponse<GroupDTO> getPage(int pageNo, int pageSize, String sorting, String name);

}
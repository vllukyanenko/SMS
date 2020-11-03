package ua.lukianenko.ums.controllers;

import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.GroupDTO;
import ua.lukianenko.ums.service.GroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupsController {
    @NonNull
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<Long> saveGroup(@RequestBody GroupDTO groupDTO) {
        return this.groupService.saveGroup(groupDTO);
    }

    @GetMapping()
    public PageResponse<GroupDTO> getGroupsPage(@RequestParam(value ="pageNumber" ) Integer pageNumber,
                                                   @RequestParam(value = "pageSize" ) Integer pageSize,
                                                   @RequestParam(value = "sorting" ) String sorting,
                                                   @RequestParam(value = "name" ) String name) {

        return this.groupService.getPage(pageNumber,pageSize, sorting, name);
    }

    @GetMapping("/all groups")
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return this.groupService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
        return this.groupService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteGroupByID(@PathVariable Long id) {
        return this.groupService.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Long> updateGroup(@PathVariable Long id, @RequestBody GroupDTO groupDTO) {
        return this.groupService.updateById(id, groupDTO);
    }
}

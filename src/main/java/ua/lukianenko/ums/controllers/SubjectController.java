package ua.lukianenko.ums.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.SubjectDTO;
import ua.lukianenko.ums.service.impl.SubjectServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    @NonNull
    private final SubjectServiceImpl subjectService;

    @GetMapping("{id}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable Long id){
        return this.subjectService.getById(id);
    }

    @GetMapping("/all subjects")
    public ResponseEntity<List<SubjectDTO>> getAllStudents(){
        return this.subjectService.getAll();
    }
    @GetMapping
    public PageResponse<SubjectDTO> getStudentsPage(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                    @RequestParam(value = "pageSize") Integer pageSize,
                                                    @RequestParam(value = "sorting") String sorting,
                                                    @RequestParam(value = "name" ) String name){

        return this.subjectService.getPage(pageNumber,pageSize,sorting, name);
    }
    @PostMapping
    public ResponseEntity<Long> saveStudent(@RequestBody SubjectDTO subjectDTO){
        return this.subjectService.save(subjectDTO);
    }
    @PutMapping("{id}")
    public ResponseEntity<Long> updateStudent(@PathVariable Long id,
                                              @RequestBody SubjectDTO subjectDTO){
        return this.subjectService.updateById(id,subjectDTO);
    }
}

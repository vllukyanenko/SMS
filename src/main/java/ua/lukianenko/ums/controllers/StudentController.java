package ua.lukianenko.ums.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.StudentDTO;
import ua.lukianenko.ums.service.impl.StudentServiceImpl;
import java.util.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    @NonNull
    private final StudentServiceImpl studentService;

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
        return this.studentService.getById(id);
    }
    @GetMapping("/all students")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return this.studentService.getAll();
    }
    @GetMapping
    public PageResponse<StudentDTO> getStudentsPage(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                    @RequestParam(value = "pageSize") Integer pageSize,
                                                    @RequestParam(value = "sorting") String sorting,
                                                    @RequestParam(value = "name" ) String name){

        return this.studentService.getPage(pageNumber,pageSize,sorting, name);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteGroupByID(@PathVariable Long id) {
        return this.studentService.deleteById(id);
    }


    @PostMapping
    public ResponseEntity<Long> saveStudent(@RequestBody StudentDTO studentDTO){
        return this.studentService.save(studentDTO);
   }

   @PutMapping("{id}")
    public ResponseEntity<Long> updateStudent(@PathVariable Long id,
                                              @RequestBody StudentDTO studentDTO){
        return this.studentService.updateById(id,studentDTO);
   }
}

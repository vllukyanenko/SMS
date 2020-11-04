package ua.lukianenko.ums.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.StudentDTO;
import ua.lukianenko.ums.dto.TeacherDTO;
import ua.lukianenko.ums.model.persons.Teacher;
import ua.lukianenko.ums.service.impl.StudentServiceImpl;
import ua.lukianenko.ums.service.impl.TeacherServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    @NonNull
    private final TeacherServiceImpl teacherService;

    @GetMapping("{id}")
    public ResponseEntity<TeacherDTO> getTeacher(@PathVariable Long id){
        return this.teacherService.getById(id);
    }
    @GetMapping("/all teachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
        return this.teacherService.getAll();
    }
    @GetMapping
    public PageResponse<TeacherDTO> getTeachersPage(@RequestParam(value = "pageNumber") Integer pageNumber,
                                                    @RequestParam(value = "pageSize") Integer pageSize,
                                                    @RequestParam(value = "sorting") String sorting,
                                                    @RequestParam(value = "name" ) String name){

        return this.teacherService.getPage(pageNumber,pageSize,sorting, name);
    }

    @PostMapping
    public ResponseEntity<Long> saveTeacher(@RequestBody TeacherDTO teacherDTO){
        return this.teacherService.save(teacherDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<Long> updateTeacher(@PathVariable Long id,
                                              @RequestBody TeacherDTO teacherDTO){
        return this.teacherService.updateById(id,teacherDTO);
    }
}

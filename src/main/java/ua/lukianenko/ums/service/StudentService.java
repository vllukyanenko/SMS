package ua.lukianenko.ums.service;

import org.springframework.http.ResponseEntity;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    ResponseEntity<StudentDTO> getById(Long id);

    ResponseEntity<Long> save(StudentDTO studentDTO);

    ResponseEntity<Long> updateById(Long id, StudentDTO studentDTO);

    ResponseEntity<Long> deleteById(Long id);

    ResponseEntity<List<StudentDTO>> getAll();

    PageResponse<StudentDTO> getPage(int pageNo, int pageSize, String sorting, String name);
}

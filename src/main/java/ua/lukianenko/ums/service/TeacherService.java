package ua.lukianenko.ums.service;

import org.springframework.http.ResponseEntity;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    ResponseEntity<TeacherDTO> getById(Long id);

    ResponseEntity<Long> save(TeacherDTO teacherDTO);

    ResponseEntity<Long> updateById(Long id, TeacherDTO teacherDTO);

    ResponseEntity<Long> deleteById(Long id);

    ResponseEntity<List<TeacherDTO>> getAll();

    PageResponse<TeacherDTO> getPage(int pageNo, int pageSize, String sorting, String name);
}


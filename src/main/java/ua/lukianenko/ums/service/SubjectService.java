package ua.lukianenko.ums.service;

import org.springframework.http.ResponseEntity;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.dto.SubjectDTO;
import ua.lukianenko.ums.dto.TeacherDTO;

import java.util.List;

public interface SubjectService {
    ResponseEntity<SubjectDTO> getById(Long id);

    ResponseEntity<Long> save(SubjectDTO subjectDTO);

    ResponseEntity<Long> updateById(Long id, SubjectDTO subjectDTO);

    ResponseEntity<Long> deleteById(Long id);

    ResponseEntity<List<SubjectDTO>> getAll();

    PageResponse<SubjectDTO> getPage(int pageNo, int pageSize, String sorting, String name);
}
